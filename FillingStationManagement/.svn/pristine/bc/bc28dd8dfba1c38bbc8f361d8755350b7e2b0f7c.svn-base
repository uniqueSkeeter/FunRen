package com.fr.station.component.customer.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.fr.station.common.bean.customer.CardChargeBean;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.customer.service.CardChargeService;
import com.fr.station.component.system.action.AbstractAction;

/**
 * The action for cardCharge
 * 
 * @author WR
 */
@Namespace("/cardCharge")
@ParentPackage("custom-default")
public class CardChargeAction extends AbstractAction {

	// ------- Constants (static final) ----------------------------------------
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(CardChargeAction.class);

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------
	@Autowired
	protected CardChargeService cardChargeServiceImpl;

	protected CardChargeBean cardChargeBean;

	protected List<CardChargeBean> cardChargeBeanList = new ArrayList<CardChargeBean>();

	private String jsonData;

	// ------- Constructors ----------------------------------------------------
	public CardChargeAction() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------
	/**
	 * action for link to displayCardChargeList.jsp
	 */
	@Action(value = "cardChargeInit", results = {
			@Result(name = "success", location = "/view/card/card/cardCharge/displayCardChargeList.jsp"),
			@Result(name = "error", location = "/view/login.jsp") })
	public String cardChargeInit() {

		return SUCCESS;
	}

	/**
	 * action for click search button to display cardAccount info
	 */
	@Action(value = "showCardAccountInfo", results = { @Result(name = "success", location = "/view/card/card/cardCharge/displayCardChargeList.jsp"), })
	public String showAccountInfo() {
		log.info("Starting to show Card Account info");
		boolean flag = false;
		try {
			this.cardChargeBeanList = this.cardChargeServiceImpl.findCardAccountRecordsByCriteria(this.cardChargeBean);
			if (this.cardChargeBeanList.size() > 0) {
				this.cardChargeBean = this.cardChargeBeanList.get(0);
				log.info("Successfully get a Card Account record");
			} else {
				this.cardChargeBean = null;
				log.info("can not get a Card Account record");
			}
			flag = true;
		} catch (Exception e) {
			log.info("execute findCardAccountRecordsByCriteria occured error, please references the detail log\n " + "[" + e
					+ "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * action for click charge button in displayCardChargeList.jsp 2014-7-25
	 */
	@Action(value = "saveCardChargeInfo", results = { @Result(name = "success", type = "json"), })
	public String saveCardChargeInfo() {
		log.info("Starting to save CardChargeInfo  into DB");
		boolean flag = false;
		try {
			this.cardChargeServiceImpl.addCardChargeInfo(this.cardChargeBean);
			flag = true;
		} catch (Exception e) {
			log.info("save cardCharge data into DB occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully save CardChargeInfo into DB");
			return SUCCESS;
		}
		return ERROR;
	}

	public CardChargeBean getCardChargeBean() {
		return this.cardChargeBean;
	}

	public void setCardChargeBean(CardChargeBean cardChargeBean) {
		this.cardChargeBean = cardChargeBean;
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
