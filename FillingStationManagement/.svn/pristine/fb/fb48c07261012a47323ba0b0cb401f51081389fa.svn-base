package com.fr.station.component.customer.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.fr.station.common.bean.customer.RegisterCustomerBean;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.customer.service.RegistMultiCustomerService;
import com.fr.station.component.system.action.AbstractAction;

/**
 * The action for saleMultiUserCard
 */
@Namespace("/registMultiCustomer")
@ParentPackage("custom-default")
public class RegistMultiCustomerAction extends AbstractAction {

	// ------- Constants (static final) ----------------------------------------

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(RegistMultiCustomerAction.class);

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------
	@Autowired
	protected RegistMultiCustomerService registMultiCustomerServiceImpl;

	protected RegisterCustomerBean registerCustomerBean;

	private List<RegisterCustomerBean> departmentList = new ArrayList<RegisterCustomerBean>();

	private String jsonData;

	// ------- Constructors ----------------------------------------------------
	public RegistMultiCustomerAction() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------
	/**
	 * action for link to saleMultiUserCard.jsp
	 */
	@Action(value = "registMultiCustomerInit", results = { @Result(name = "success", location = "/view/card/customer/saleMultiUserCard/saleMultiUserCard.jsp") })
	public String registerCustomerInit() {

		return SUCCESS;
	}

	/**
	 * action for link to addMultiCustomer.jsp
	 */
	@Action(value = "customerAdd", results = { @Result(name = "success", location = "/view/card/customer/saleMultiUserCard/addMultiCustomer.jsp") })
	public String customerAdd() {

		return SUCCESS;
	}

	/**
	 * action for link to departmentMaintain.jsp
	 */
	@Action(value = "depMaintain", results = { @Result(name = "success", location = "/view/card/customer/saleMultiUserCard/departmentMaintain.jsp") })
	public String depMaintain() {

		return SUCCESS;
	}

	/**
	 * action for link to departmentAdd.jsp when click departmentEdit button
	 */
	@Action(value = "refreshDepAdd", results = { @Result(name = "success", location = "/view/card/customer/saleMultiUserCard/departmentAdd.jsp"), })
	public String refreshDepAdd() {
		log.info("Starting to refresh department data");
		boolean flag = false;
		try {
			this.departmentList = this.registMultiCustomerServiceImpl.getDepByFormCondition(this.getRegisterCustomerBean());
			if (this.departmentList.size() > 0) {
				this.registerCustomerBean = this.departmentList.get(0);
				log.info("Successfully get a department record");
			} else {
				log.info("can not get a department record");
			}
			flag = true;
		} catch (Exception e) {
			log.info("execute getDepByFormCondition occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * action for link to departmentAdd.jsp when click departmentAdd button
	 */
	@Action(value = "depAddInit", results = { @Result(name = "success", location = "/view/card/customer/saleMultiUserCard/departmentAdd.jsp"), })
	public String depAddInit() {
		log.info("Starting to refresh department data");
		boolean flag = false;
		try {
			this.departmentList = this.registMultiCustomerServiceImpl.getGuestNoByBean(this.getRegisterCustomerBean());
			if (this.departmentList.size() > 0) {
				this.registerCustomerBean = this.departmentList.get(0);
				log.info("Successfully get guestNo");
			} else {
				log.info("can not get guestNo");
			}
			flag = true;
		} catch (Exception e) {
			log.info("execute getGuestNoByBean occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * action for link to driverAdd.jsp when click driverAdd button
	 */
	@Action(value = "driverAddInit", results = { @Result(name = "success", location = "/view/card/customer/saleMultiUserCard/driverAdd.jsp"), })
	public String driverAddInit() {
		log.info("Starting to refresh driver data");
		boolean flag = false;
		try {
			this.departmentList = this.registMultiCustomerServiceImpl.getGuestNoAndDepNoByBean(this.getRegisterCustomerBean());
			if (this.departmentList.size() > 0) {
				this.registerCustomerBean = this.departmentList.get(0);
				log.info("Successfully get guestNo and depNo");
			} else {
				log.info("can not get guestNo and depNo");
			}
			flag = true;
		} catch (Exception e) {
			log.info("execute getGuestNoAndDepNoByBean occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * action for link to departmentAdd.jsp when click departmentAdd button
	 */
	@Action(value = "departmentChangeInit", results = { @Result(name = "success", location = "/view/card/customer/saleMultiUserCard/departmentChange.jsp"), })
	public String departmentChangeInit() {
		log.info("Starting to refresh department data");
		boolean flag = false;
		try {
			this.departmentList = this.registMultiCustomerServiceImpl.getDepNoByCardNo(this.getRegisterCustomerBean());
			if (this.departmentList.size() > 0) {
				this.registerCustomerBean = this.departmentList.get(0);
				log.info("Successfully get depNo");
			} else {
				log.info("can not get depNo");
			}
			flag = true;
		} catch (Exception e) {
			log.info("execute getDepNoByCardNo occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * action for click search button in saleMultiUserCard.jsp to display the search results
	 */
	@Action(value = "showDriverList", results = { @Result(name = "success", type = "json"), })
	public String showDriverList() {
		log.info("Starting to show driver list");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		List<RegisterCustomerBean> registerCustomerBeanList = null;
		try {
			registerCustomerBeanList = this.registMultiCustomerServiceImpl
					.findDriverRecordsByCriteria(this.registerCustomerBean);
			if (!registerCustomerBeanList.isEmpty()) {
				map.put(this.TOTAL, registerCustomerBeanList.get(0).getTotalData());
				map.put(this.ROWS, registerCustomerBeanList);
				this.jsonData = JSONObject.fromObject(map).toString();
				log.info("Successfully get driver records");
			} else {
				map.clear();
				log.info("can not get driver records");
			}
			flag = true;
		} catch (net.sf.json.JSONException e) {
			log.info("Convert to Json object occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("execute findDriverRecordsByCriteria occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * action for click search button in departmentMaintain.jsp to display the search results
	 */
	@Action(value = "showDepartmentList", results = { @Result(name = "success", type = "json"), })
	public String showDepartmentList() {
		log.info("Starting to show dapartment list");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		List<RegisterCustomerBean> registerCustomerBeanList = null;
		try {
			registerCustomerBeanList = this.registMultiCustomerServiceImpl.findDepRecordsByCriteria(this.registerCustomerBean);
			if (!registerCustomerBeanList.isEmpty()) {
				map.put(this.TOTAL, registerCustomerBeanList.get(0).getTotalData());
				map.put(this.ROWS, registerCustomerBeanList);
				this.jsonData = JSONObject.fromObject(map).toString();
				log.info("Successfully get department records");
			} else {
				map.clear();
				log.info("can not get department records");
			}
			flag = true;
		} catch (net.sf.json.JSONException e) {
			log.info("Convert to Json object occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("execute findDepRecordsByCriteria occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * action for click saleCard button in customerAdd.jsp
	 */
	@Action(value = "saveCustomer", results = { @Result(name = "success", type = "json"), })
	public String saveCustomer() {
		log.info("Starting to save Card(mainCard) infomation into DB");
		boolean flag = false;
		try {
			this.registMultiCustomerServiceImpl.addCustomer(this.registerCustomerBean);
			flag = true;
		} catch (Exception e) {
			log.info("save main card data into DB occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully save Card(mainCard) data into DB");
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * action for click saleCard button in driverAdd.jsp
	 */
	@Action(value = "saveDriver", results = { @Result(name = "success", type = "json"), })
	public String saveDriver() {
		log.info("Starting to save Card(sonCard) infomation into DB");
		boolean flag = false;
		try {
			this.registMultiCustomerServiceImpl.addDriver(this.registerCustomerBean);
			flag = true;
		} catch (Exception e) {
			log.info("save son card data into DB occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully save Card(sonCard) data into DB");
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * action for click departmentAdd button in departmentAdd.jsp 2014-7-28
	 */
	@Action(value = "saveDepartment", results = { @Result(name = "success", type = "json"), })
	public String saveDepartment() {
		log.info("Starting to save department infomation into DB");
		boolean flag = false;
		try {
			this.registMultiCustomerServiceImpl.addDepartment(this.registerCustomerBean);
			flag = true;
		} catch (Exception e) {
			log.info("save department data into DB occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully save department data into DB");
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * action for click departmentEdit button in departmentAdd.jsp 2014-7-28
	 */
	@Action(value = "updateDepartment", results = { @Result(name = "success", type = "json"), })
	public String updateDepartment() {
		log.info("Starting to update department infomation into DB");
		boolean flag = false;
		try {
			this.registMultiCustomerServiceImpl.updateDepartment(this.registerCustomerBean);
			flag = true;
		} catch (Exception e) {
			log.info("update department data into DB occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully update department data into DB");
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * action for click departmentChange button in saleMultiUserCard.jsp
	 */
	@Action(value = "changeDriverDepNo", results = { @Result(name = "success", type = "json"), })
	public String changeDriverDepNo() {
		log.info("Starting to change driver depNo");
		boolean flag = false;
		try {
			this.registMultiCustomerServiceImpl.updateDriverDepNo(this.registerCustomerBean);
			flag = true;
		} catch (Exception e) {
			log.info("execute updateDriverDepNo occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully change driver depNo");
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * action for click departmentDelete button in departmentMaintain.jsp
	 */
	@Action(value = "deleteDepartment", results = { @Result(name = "success", type = "json"), })
	public String deleteDepartment() {
		log.info("Starting to delete department infomation into DB");
		boolean flag = false;
		try {
			this.registMultiCustomerServiceImpl.deleteDepartment(this.registerCustomerBean);
			flag = true;
		} catch (Exception e) {
			log.info("execute deleteDepartment occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully delete department data into DB");
			return SUCCESS;
		}
		return ERROR;
	}

	public RegisterCustomerBean getRegisterCustomerBean() {
		return this.registerCustomerBean;
	}

	public void setRegisterCustomerBean(RegisterCustomerBean registerCustomerBean) {
		this.registerCustomerBean = registerCustomerBean;
	}

	public String getJsonData() {
		return this.jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
