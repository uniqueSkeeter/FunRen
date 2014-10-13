package com.fr.station.component.system.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fr.station.common.bean.system.MenuTypeEnum;
import com.fr.station.common.bean.system.NodeBean;
import com.fr.station.common.consts.AppConsts;
import com.fr.station.common.consts.NumberConsts;
import com.fr.station.common.data.ApplicationContext;
import com.fr.station.common.data.DataCollections;
import com.fr.station.common.entity.system.EmployeeEntity;
import com.fr.station.common.entity.system.FunctionInfoEntity;
import com.fr.station.common.entity.system.OperatorEntity;
import com.fr.station.common.entity.system.RoleFunctionInfoEntity;
import com.fr.station.common.entity.system.RoleInfoEntity;
import com.fr.station.common.entity.system.StationEntity;
import com.fr.station.common.utility.MD5;
import com.fr.station.common.utility.StringUtil;
import com.fr.station.component.system.dao.UserDAO;
import com.fr.station.component.system.dao.impl.UserDaoImpl;
import com.fr.station.component.system.exception.EmployeeException;
import com.fr.station.component.system.service.UserService;

@Service("/userService")
public class UserServiceImpl extends AbstractBaseService<OperatorEntity> implements UserService {

	// ------- Constants (static final) ----------------------------------------
	private static Logger log = Logger.getLogger(UserServiceImpl.class);

	private static final String TOPNAVIMENUMAP = "topNaviMenuMap";

	private OperatorEntity operatorEntity;

	private static int userId;

	private static int roleId;

	private static final Map<String, Map<String, List<NodeBean>>> dataCache = new HashMap<String, Map<String, List<NodeBean>>>();

	private static final Map<String, List<NodeBean>> naviMenuMap = new HashMap<String, List<NodeBean>>();

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	private UserDAO userDaoImpl;

	// ------- Constructors ----------------------------------------------------

	public UserServiceImpl() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addUser(OperatorEntity user) {
		log.info("Persist user entity begain...");
		this.save(user);
		log.info("Succefully saved userEntity entity...");

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteUser(OperatorEntity userEntity) {
		log.info("Delete user entity begain...");
		this.delete(userEntity);
		log.info("Succefully removed user entity from DB...");

	}

	@Autowired
	public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		super.setBaseDao(userDaoImpl);
		this.userDaoImpl = userDaoImpl;
	}

	/**
	 * {@inheritDoc}
	 * @throws Exception
	 *
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int getUserRoleByCriteria(String userName, String passWord, Map<String, Object> session,
			Map<String, Object> application) throws EmployeeException, Exception{
		log.info("Start to get user based on the input criteria");
		this.operatorEntity = this.retrieveDataFromDB(userName, passWord);
		if(this.operatorEntity == null){
			throw new EmployeeException("Can't get the records from DB, there is no corresponding data in DB, please change you name and pass");
		}
		// retrieve role entity information
		this.retrieveRoleEntity(this.operatorEntity);

		final EmployeeEntity employee = this.retrieveEmployeeEntity();
		// retrieve station info
		this.retriveStationInfo(employee);
		// save operator number
		ApplicationContext.getInstance().setOperatorNo(this.operatorEntity.getOperatorNum());
		userId = employee.getId();
		// check the latest menu
		this.refreshMenu(userName, passWord, userId, session, application);
		// save navigate button
		this.saveNavigateValue(session, application);
		log.info("Successfully to get user by input criteria");
		return roleId;
	}

	private EmployeeEntity retrieveEmployeeEntity() {
		final EmployeeEntity employee = this.operatorEntity.getEmplEntity();
		return employee;
	}

	private RoleInfoEntity retrieveRoleEntity(OperatorEntity operatorEntity) {

		RoleInfoEntity roleInfoEntity = this.operatorEntity.getRoleEntity() != null ? this.operatorEntity.getRoleEntity() : null;
		roleId = this.getMenuItem(roleInfoEntity);
		String roleName = roleInfoEntity.getName();
		ApplicationContext.getInstance().setRoleName(roleName);
		return roleInfoEntity;
	}

	@Override
	@Transactional
	public List<OperatorEntity> getAllUsers() {
		List<OperatorEntity> resultList = null;
		try {
			resultList = this.userDaoImpl.getAllUsers();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void getUserAuthor(int roleId) {
		try {
			DataCollections.dicMenuTree.clear();
			DataCollections.dicMenuBtn.clear();
			final List treeList = this.userDaoImpl.getUserAuthor(roleId);
			List<NodeBean> retTreeList = new ArrayList<NodeBean>();
			List<NodeBean> retNotTreeList = new ArrayList<NodeBean>();
			NodeBean nodeBean = null;
			int upStep = -1;
			if (!StringUtil.isEmpty(treeList)) {
				for (final Object obj : treeList) {
					nodeBean = new NodeBean();
					if (obj instanceof Object[]) {
						final Object[] objTemp = (Object[]) obj;

						// 名称
						nodeBean.setText((String) objTemp[1]);
						// 是否展开
						nodeBean.setOpen((int) objTemp[5]);
						// 当前节点
						nodeBean.setStep((int) objTemp[3]);
						// 上级节点
						nodeBean.setUpStep((int) objTemp[2]);
						// URL
						nodeBean.setUrl((String) objTemp[6]);
						if ((int) objTemp[4] == AppConsts.TREE_SHOW) {
							if (nodeBean.getUpStep() == 0) {
								retTreeList = new ArrayList<NodeBean>();
								retTreeList.add(nodeBean);
								DataCollections.dicMenuTree.put(nodeBean.getStep(), retTreeList);
								upStep = nodeBean.getStep();
							} else {
								retTreeList = DataCollections.dicMenuTree.get(nodeBean.getUpStep());
								if (!StringUtil.isEmpty(retTreeList)) {
									this.doSetChild(nodeBean, DataCollections.dicMenuTree.get(nodeBean.getUpStep()));
								} else {
									this.doSetChild(nodeBean, DataCollections.dicMenuTree.get(upStep));
								}
							}
						} else if ((int) objTemp[4] == AppConsts.TREE_NOT_SHOW) {
							retNotTreeList = DataCollections.dicMenuBtn.get(nodeBean.getUpStep());
							if (!StringUtil.isEmpty(retNotTreeList)) {
								this.doSetChild(nodeBean, retNotTreeList);
							} else {
								retNotTreeList = new ArrayList<NodeBean>();
								retNotTreeList.add(nodeBean);
								DataCollections.dicMenuBtn.put(nodeBean.getUpStep(), retNotTreeList);
							}
						}
					}
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	/**
	 *
	 * @param nodeBean
	 */
	private void doSetChild(NodeBean nodeBean, List<NodeBean> beanList) {
		if (StringUtil.isEmpty(beanList)) {
			beanList.add(nodeBean);
		} else {
			for (final NodeBean bean : beanList) {
				if (bean.getStep() == nodeBean.getUpStep()) {
					bean.getChildren().add(nodeBean);
				} else if (!StringUtil.isEmpty(bean.getChildren())) {
					this.doSetChild(nodeBean, bean.getChildren());
				}
			}
		}
	}

	/**
	 * Concrete nodeBean instance
	 *
	 * @param funcEntity the function entity fromDB.
	 * @return nodeBean nodeBean just created.
	 */
	private NodeBean createNodeBean(FunctionInfoEntity funcEntity) {
		final NodeBean nodeBean = new NodeBean();
		nodeBean.setStep(funcEntity.getStep());
		nodeBean.setUrl(funcEntity.getUrl());
		nodeBean.setText(funcEntity.getName());
		return nodeBean;
	}

	private int getTopMenuList(RoleInfoEntity roleInfoEntity) {
		if (roleInfoEntity == null) {
			return 0;
		}
		final int roleId = roleInfoEntity.getId();
		final Set<RoleFunctionInfoEntity> roleFunctionInfoEntity = roleInfoEntity.getFunctionId();
		for (final RoleFunctionInfoEntity roleFunEntity : roleFunctionInfoEntity) {
			final int referenceId = roleFunEntity.getRoleId().getId();
			final FunctionInfoEntity funcEntity = roleFunEntity.getFunctionId();
			if (referenceId == roleId && MenuTypeEnum.TOP_MENU.getColumnName().equals(String.valueOf(funcEntity.getUpStep()))) {
				final NodeBean nodeBean = this.createNodeBean(funcEntity);
				this.addNaviMenuMap(MenuTypeEnum.TOP_MENU.name(), nodeBean);
				Collections.sort(naviMenuMap.get(MenuTypeEnum.TOP_MENU.name()), new Comparator<NodeBean>() {

					@Override
					public int compare(NodeBean o1, NodeBean o2) {
						return o1.getStep() - o2.getStep();
					}
				});
			}
		}
		return roleId;
	}

	private void addNaviMenuMap(String key, NodeBean nodeBean) {
		List<NodeBean> nodeBeanList = naviMenuMap.get(key);
		if (nodeBeanList == null) {
			nodeBeanList = new ArrayList<NodeBean>();
			naviMenuMap.put(key, nodeBeanList);
		}
		nodeBeanList.add(nodeBean);

	}

	// TODO
	private void addDataCacheMap(String outKey, String innerKey, NodeBean nodeBean) {

		Map<String, List<NodeBean>> menuMap = dataCache.get(outKey);
		if (menuMap == null) {
			menuMap = new HashMap<String, List<NodeBean>>();
		}
		List<NodeBean> nodeBeanList = menuMap.get(innerKey);
		if (nodeBeanList == null) {
			nodeBeanList = new ArrayList<NodeBean>();
		}
		nodeBeanList.add(nodeBean);
		menuMap.put(innerKey, nodeBeanList);
		dataCache.put(outKey, menuMap);
	}

	private void refreshCacheMapData(String userName, String passWord) throws Exception {
		this.operatorEntity = this.retrieveDataFromDB(userName, passWord);
//		this.retrieveRoleEntity();
	}

	private OperatorEntity retrieveDataFromDB(String userName, String passWord) throws Exception {
		// retrieve operator value from db
		final OperatorEntity operatorEntity = this.userDaoImpl.getUserByCriteria(userName, MD5.GetMD5Code(passWord));
		if (operatorEntity != null) {
			return operatorEntity;
		}
		return null;
	}

	private int getMenuItem(RoleInfoEntity roleInfoEntity) {

		final List<MenuTypeEnum> typeEnumList = Arrays.asList(MenuTypeEnum.EMPLOYEE_NAVI_MENU, MenuTypeEnum.CUSTOMER_NAVI_MENU,
				MenuTypeEnum.IC_CARD_NAVI_MENU);
		// get top menu show list
		final int roleId = this.getTopMenuList(roleInfoEntity);

		// get top navi menu show list
		for (final MenuTypeEnum menuEnum : typeEnumList) {
			this.getTopNaviMenuList(roleInfoEntity, menuEnum);
		}
		return roleId;
	}

	private void refreshMenu(String userName, String passWord, int userId, Map<String, Object> session,
			Map<String, Object> application) throws Exception {
		MenuTypeEnum field = null;

		if (application.get(String.valueOf(userId)) != null) {
			for (final Map.Entry<String, List<NodeBean>> entry : naviMenuMap.entrySet()) {
				if (entry.getKey().equalsIgnoreCase(MenuTypeEnum.TOP_MENU.name())) {
					field = MenuTypeEnum.TOP_MENU;
				} else if (entry.getKey().equalsIgnoreCase(MenuTypeEnum.CUSTOMER_NAVI_MENU.name())) {
					field = MenuTypeEnum.CUSTOMER_NAVI_MENU;
				} else if (entry.getKey().equalsIgnoreCase(MenuTypeEnum.EMPLOYEE_NAVI_MENU.name())) {
					field = MenuTypeEnum.EMPLOYEE_NAVI_MENU;
				} else if (entry.getKey().equalsIgnoreCase(MenuTypeEnum.IC_CARD_NAVI_MENU.name())) {
					field = MenuTypeEnum.IC_CARD_NAVI_MENU;
				} else {
					field = MenuTypeEnum.DEFAULT;
				}
//				this.getFieldItem(field, entry.getValue().size(), userName, passWord, session);
				break;
			}
		}
	}

	private void reloadMenuItem(String userName, String passWord, Map<String, Object> session) throws Exception {
		this.refreshCacheMapData(userName, passWord);
	}

	private void getFieldItem(MenuTypeEnum field, int size, String userName, String passWord, Map<String, Object> session)
			throws Exception {
		// reload latest DB menu count
		final long topMenuCount = this.userDaoImpl.findCountByCriteria(MenuTypeEnum.TOP_MENU.getColumnName(), 1);
		final long employeeMenuCount = this.userDaoImpl.findCountByCriteria(MenuTypeEnum.EMPLOYEE_NAVI_MENU.getColumnName(), 0);
		final long customerMenuCount = this.userDaoImpl.findCountByCriteria(MenuTypeEnum.CUSTOMER_NAVI_MENU.getColumnName(), 0);
		final long cardMenuCount = this.userDaoImpl.findCountByCriteria(MenuTypeEnum.IC_CARD_NAVI_MENU.getColumnName(), 0);
		switch (field) {
			case TOP_MENU:
				if (topMenuCount > size) {
					this.reloadMenuItem(userName, passWord, session);
				}
				break;
			case CUSTOMER_NAVI_MENU:
				if (employeeMenuCount > size) {
					this.reloadMenuItem(userName, passWord, session);
				}
				break;
			case EMPLOYEE_NAVI_MENU:
				if (customerMenuCount > size) {
					this.reloadMenuItem(userName, passWord, session);
				}
				break;
			case IC_CARD_NAVI_MENU:
				if (cardMenuCount > size) {
					this.reloadMenuItem(userName, passWord, session);
				}
				break;
			default:
				break;
		}
	}

	private int getTopNaviMenuList(RoleInfoEntity roleInfoEntity, MenuTypeEnum menuEnum) {
		if (roleInfoEntity == null) {
			return 0;
		}
		final int roleId = roleInfoEntity.getId();
		final Set<RoleFunctionInfoEntity> roleFunctionInfoEntity = roleInfoEntity.getFunctionId();
		for (final RoleFunctionInfoEntity roleFunEntity : roleFunctionInfoEntity) {
			final int referenceId = roleFunEntity.getRoleId().getId();
			final FunctionInfoEntity funcEntity = roleFunEntity.getFunctionId();
			if (referenceId == roleId && menuEnum.getColumnName().equals(String.valueOf(funcEntity.getUpStep()))
					&& funcEntity.getLtree() == NumberConsts.NUM_0) {
				final NodeBean nodeBean = this.createNodeBean(funcEntity);
				this.addNaviMenuMap(menuEnum.name(), nodeBean);
			}
		}
		if(naviMenuMap.size() <= 0){
			return roleId;
		}
		Collections.sort(naviMenuMap.get(menuEnum.name()), new Comparator<NodeBean>() {

			@Override
			public int compare(NodeBean o1, NodeBean o2) {
				return o1.getStep() - o2.getStep();
			}
		});
		return roleId;
	}

	private void retriveStationInfo(EmployeeEntity employee) {
		StationEntity stationEntity = employee.getStationId();
		ApplicationContext.getInstance().setStationNum(stationEntity.getStationNum());
		ApplicationContext.getInstance().setStationName(stationEntity.getName());
		List<StationEntity> limitStationList = ApplicationContext.getInstance().getLimitStationMap().get(stationEntity.getUpCompany());
		if(limitStationList == null) {
			DataCollections.stationLimit.clear();;
			return;
		}
		for (StationEntity station : limitStationList) {
			DataCollections.stationLimit.put(station.getStationNum(), station.getName());
		}
	}

	private void saveNavigateValue(Map<String, Object> session, Map<String, Object> application) {
		// save value to session
		session.put(TOPNAVIMENUMAP, naviMenuMap);
		session.put(String.valueOf(roleId), roleId);
		application.put(String.valueOf(userId), userId);
	}

}
