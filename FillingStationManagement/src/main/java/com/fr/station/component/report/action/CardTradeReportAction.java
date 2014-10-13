package com.fr.station.component.report.action;

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

import com.fr.station.common.bean.report.CardTradeReportBean;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.report.service.CardTradeReportService;
import com.fr.station.component.system.action.AbstractAction;

@Namespace("/cardTradeReport")
@ParentPackage("custom-default")
public class CardTradeReportAction extends AbstractAction {

	// ------- Constants (static final) ----------------------------------------
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(CardTradeReportAction.class);

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------
	@Autowired
	protected CardTradeReportService cardTradeReportService;

	protected CardTradeReportBean cardTradeReportBean;

	private String jsonData;

	// ------- Constructors ----------------------------------------------------

	public CardTradeReportAction() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	/**
	 * 
	 * receive the request from http and handle the request to dispatch different ways based on the parameters
	 * 
	 * @param
	 * @return displayCardList jsp
	 * @throws
	 */

	@Action(value = "showCardTradeRecords", results = { @Result(name = "success", type = "json"), })
	public String showCardTradeRecords() {
		log.info("Starting to load show card trade records information from DB");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		List<CardTradeReportBean> cardTradeBeanList = null;
		try {
			cardTradeBeanList = this.cardTradeReportService.findCardTradeRecordsByCriteria(this.cardTradeReportBean);
			if (!cardTradeBeanList.isEmpty()) {
				map.put(TOTAL, cardTradeBeanList.get(0).getTotalData());
				map.put(ROWS, cardTradeBeanList);
				this.jsonData = JSONObject.fromObject(map).toString();
			} else {
				map.clear();
			}
			flag = true;
		} catch (net.sf.json.JSONException e) {
			log.info("Convert to Json object occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Loading showCardTradeRecords data from DB occured error, please references the detail log\n " + "[" + e
					+ "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully load showCardTradeRecords data from DB");
			return SUCCESS;
		}
		return ERROR;
	}

	@Action(value = "showGuestPaymentRecords", results = { @Result(name = "success", type = "json"), })
	public String showGuestPaymentRecords() {
		log.info("Starting to load show guest payment Records infomation from DB");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		List<CardTradeReportBean> cardTradeBeanList = null;
		try {
			cardTradeBeanList = this.cardTradeReportService.findGuestCreditRecordsByCriteria(this.cardTradeReportBean);
			if (!cardTradeBeanList.isEmpty()) {
				map.put(TOTAL, cardTradeBeanList.get(0).getTotalData());
				map.put(ROWS, cardTradeBeanList);
				this.jsonData = JSONObject.fromObject(map).toString();
			} else {
				map.clear();
			}
			flag = true;
		} catch (net.sf.json.JSONException e) {
			log.info("Convert to Json object occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Loading show guest payment Records data from DB occured error, please references the detail log\n " + "["
					+ e + "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully load show guest payment records data from DB");
			return SUCCESS;
		}
		return ERROR;
	}

	@Action(value = "showCardPredistributionRecords", results = { @Result(name = "success", type = "json"), })
	public String showCardPredistributionRecords() {
		log.info("Starting to load show card predistribution records infomation from DB");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		List<CardTradeReportBean> cardTradeBeanList = null;
		try {
			cardTradeBeanList = this.cardTradeReportService.findCardPredistributionRecordsByCriteria(this.cardTradeReportBean);
			if (!cardTradeBeanList.isEmpty()) {
				map.put(TOTAL, cardTradeBeanList.get(0).getTotalData());
				map.put(ROWS, cardTradeBeanList);
				this.jsonData = JSONObject.fromObject(map).toString();
			} else {
				log.info("Cannot find respond data information from DB");
				map.clear();
			}
			flag = true;
		} catch (net.sf.json.JSONException e) {
			log.info("Convert to Json object occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Loading show card predistribution records data from DB occured error, please references the detail log\n "
					+ "[" + e + "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully load show card predistribution records data from DB");
			return SUCCESS;
		}
		return ERROR;
	}

	public CardTradeReportBean getCardTradeReportBean() {
		return this.cardTradeReportBean;
	}

	public void setCardTradeReportBean(CardTradeReportBean cardTradeReportBean) {
		this.cardTradeReportBean = cardTradeReportBean;
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
