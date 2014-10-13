package com.fr.station.component.customer.action;

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
import com.fr.station.component.customer.service.RegisterCustomerService;
import com.fr.station.component.system.action.AbstractAction;

/**
 * The action for registerCustomer
 * 
 * @author WR
 */
@Namespace("/registCustomer")
@ParentPackage("custom-default")
public class RegistCustomerAction extends AbstractAction {

	// ------- Constants (static final) ----------------------------------------

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(RegistCustomerAction.class);

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	@Autowired
	protected RegisterCustomerService registerCustomerServiceImpl;

	protected RegisterCustomerBean registerCustomerBean;

	private String jsonData;

	// ------- Constructors ----------------------------------------------------

	public RegistCustomerAction() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	/**
	 * action for link to displayRegisterCustomer.jsp
	 */
	@Action(value = "registerCustomerInit", results = {
			@Result(name = "success", location = "/view/card/customer/displayRegisterCustomer.jsp"),
			@Result(name = "error", location = "/view/login.jsp") })
	public String registerCustomerInit() {

		return SUCCESS;
	}

	/**
	 * action for click search button in displayRegisterCustomer.jsp to display the search results
	 */
	@Action(value = "showCustomerList", results = { @Result(name = "success", type = "json"), })
	public String showCustomerList() {
		log.info("Starting to load registerCustomer records from DB");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		List<RegisterCustomerBean> registerCustomerBeanList = null;
		try {
			registerCustomerBeanList = this.registerCustomerServiceImpl
					.findRegisterCustomerRecordsByCriteria(this.registerCustomerBean);
			if (!registerCustomerBeanList.isEmpty()) {
				map.put(this.TOTAL, registerCustomerBeanList.get(0).getTotalData());
				map.put(this.ROWS, registerCustomerBeanList);
				this.jsonData = JSONObject.fromObject(map).toString();
				log.info("Successfully Convert search records to Json object");
			} else {
				map.clear();
				log.info("can not find a search record in DB");
			}
			flag = true;
		} catch (net.sf.json.JSONException e) {
			log.info("Convert to Json object occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Loading registerCustomer data from DB occured error, please references the detail log\n " + "[" + e
					+ "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * action for click saleCard button to saleAnonymousCard and salePersonalCard 2014-7-25
	 */
	@Action(value = "saveCardInfo", results = { @Result(name = "success", type = "json"), })
	public String saveCardInfo() {
		log.info("Starting to save Card(anonymousCard and personalCard) infomation into DB");
		boolean flag = false;
		try {
			this.registerCustomerServiceImpl.addCardInfo(this.registerCustomerBean);
			flag = true;
		} catch (Exception e) {
			log.info("save card data into DB occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully save Card(anonymousCard and personalCard) data into DB");
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

}
