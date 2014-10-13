package com.fr.station.component.system.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.QueryException;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fr.station.common.bean.report.EmployeeBean;
import com.fr.station.common.data.ApplicationContext;
import com.fr.station.common.entity.system.EmployeeEntity;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.system.dao.AbstractBaseDAO;
import com.fr.station.component.system.dao.EmployeeDAO;

/**
 * The action for dashboard. It handles the user request from the web sites. Mainly responsible to handle user login
 * 
 * @author henry
 */
@Repository
public class EmployeeDaoImpl extends AbstractBaseDAO<EmployeeEntity> implements EmployeeDAO {

	// ------- Constants (static final) ----------------------------------------
	private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

	private static final String NAME = "name";

	private static final String ID = "id";

	private static final String USER_NO = "userNum";

	private static final String POST_TYPE = "postType";

	private static final String CLASS_ID = "shiftId";

	private static final String CREATE_DATE = "createDate";

	private static final String USER_NUM = "userNum";

	private static final String SHIFT_ID = "shiftId";

	private static final String CONTACT_TEL = "contactTel";

	private static final String POST_STATS = "postStats";

	private static final String CONTACT_ADDR = "contactAddr";

	private static final String STATS = "stats";

	private static final String ID_NUMBER = "idNumber";

	private static final String BANK_NUM = "bankNum";

	private static final String EDUCATION = "education";

	private static final String POLITICAL_STATUS = "politicalStatus";

	private static final String BANK_TYPE = "bankType";

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	private final String updateEmplSql = "UPDATE EmployeeEntity e SET e.postType = ? WHERE e.id = ?";

	// ------- Constructors ----------------------------------------------------

	// ------- Instance Methods (public) ---------------------------------------

	// ------- Instance Methods (protected) ------------------------------------

	@Override
	public void addEmployee(EmployeeEntity employee) {
		this.save(employee);
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() throws Exception {
		return this.findAll();
	}

	@Override
	public void updateEmployee(EmployeeBean employeeBean, Object... args) {
		this.upateBySql(this.updateEmplSql, args);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<EmployeeBean> getAllEmployees(EmployeeBean employeeBean) throws Exception {
		List<EmployeeBean> resultList = null;
		try {
			Criteria criteria = this.findByCriteria(this.getEntityClass()).setProjection(this.idicateReturnColumn());
			this.validateInputCriteria(employeeBean, criteria);
			resultList = this.convertDataToBean(criteria.list());
		} catch (QueryException e) {
			resultList = new ArrayList<EmployeeBean>();
			log.info("Get DB data occured error, more detail please see the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return resultList;
		}
		return resultList;
	}

	@Override
	public void deleteEmployee(EmployeeEntity employeeEntity) {
		this.delete(employeeEntity);
	}

	// ------- Instance Methods (private) --------------------------------------

	private List<EmployeeBean> convertDataToBean(List<Object[]> dataResult) {
		List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
		EmployeeBean employeeBean = null;
		String stationNum = ApplicationContext.getInstance().getStationNum();
		for (Object[] dataRow : dataResult) {
			employeeBean = new EmployeeBean();
			employeeBean.setEmployeeName(String.valueOf(dataRow[0]));
			employeeBean.setEmployeeNum(String.valueOf(dataRow[1]));
			employeeBean.setShiftType(String.valueOf(dataRow[2]));
			employeeBean.setShiftNum(String.valueOf(dataRow[3]));
			employeeBean.setTelephone(String.valueOf(dataRow[4]));
			employeeBean.setShiftStatus(String.valueOf(dataRow[5]));
			employeeBean.setCreateData((Timestamp) dataRow[6]);
			employeeBean.setAddress(String.valueOf(dataRow[7]));
			employeeBean.setLoginStatus(String.valueOf(dataRow[8]));
			employeeBean.setId((int) (dataRow[9]));
			employeeBean.setIdentity(String.valueOf(dataRow[10]));
			employeeBean.setBankAccount(String.valueOf(dataRow[11]));
			employeeBean.setEducation(String.valueOf(dataRow[12]));
			employeeBean.setPolitical(String.valueOf(dataRow[13]));
			employeeBean.setBankType(String.valueOf(dataRow[14]));
			employeeBean.setIdentity(String.valueOf(dataRow[15]));
			employeeBean.setStationNum(stationNum);
			employeeList.add(employeeBean);
		}
		return employeeList;
	}

	private ProjectionList idicateReturnColumn() {
		return Projections.projectionList().add(Property.forName(NAME)).add(Property.forName(USER_NUM))
				.add(Property.forName(POST_TYPE)).add(Property.forName(SHIFT_ID)).add(Property.forName(CONTACT_TEL))
				.add(Property.forName(POST_STATS)).add(Property.forName(CREATE_DATE)).add(Property.forName(CONTACT_ADDR))
				.add(Property.forName(STATS)).add(Property.forName(ID)).add(Property.forName(ID_NUMBER))
				.add(Property.forName(BANK_NUM)).add(Property.forName(EDUCATION)).add(Property.forName(POLITICAL_STATUS))
				.add(Property.forName(BANK_TYPE)).add(Property.forName(ID_NUMBER));
	}

	private void validateInputCriteria(EmployeeBean employeeBean, Criteria criteria) {
		if (employeeBean.getId() != null) {
			criteria.add(Restrictions.eq(ID, Integer.valueOf(employeeBean.getId())));
		}
		if (StringUtils.isNotEmpty(employeeBean.getEmployeeName())) {
			criteria.add(Restrictions.eq(NAME, employeeBean.getEmployeeName()));
		}
		if (StringUtils.isNotEmpty(employeeBean.getEmployeeNum())) {
			criteria.add(Restrictions.eq(USER_NO, employeeBean.getEmployeeNum()));
		}
		if (StringUtils.isNotEmpty(employeeBean.getShiftType())) {
			criteria.add(Restrictions.eq(POST_TYPE, employeeBean.getShiftType()));
		}
		if (StringUtils.isNotEmpty(employeeBean.getShiftNum())) {
			criteria.add(Restrictions.eq(CLASS_ID, employeeBean.getShiftNum()));
		}
		if (employeeBean.getStartDate() != null && employeeBean.getEndDate() != null) {
			criteria.add(Restrictions.between(CREATE_DATE, employeeBean.getStartDate(), employeeBean.getEndDate()));
		} else if (employeeBean.getStartDate() != null && employeeBean.getEndDate() == null) {
			criteria.add(Restrictions.ge(CREATE_DATE, employeeBean.getStartDate()));
		} else if (employeeBean.getStartDate() == null && employeeBean.getEndDate() != null) {
			criteria.add(Restrictions.ge(CREATE_DATE, employeeBean.getEndDate()));
		}
	}

}
