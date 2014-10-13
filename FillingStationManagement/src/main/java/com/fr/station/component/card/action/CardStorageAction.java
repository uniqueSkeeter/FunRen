package com.fr.station.component.card.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.fr.station.common.bean.card.CardStorageBean;
import com.fr.station.common.bean.card.CardStorageDetailBean;
import com.fr.station.common.utility.DateJsonValueProcessor;
import com.fr.station.common.utility.DateUtil;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.card.service.CardStorageService;
import com.fr.station.component.system.action.AbstractAction;

@Namespace("/cardStorage")
@ParentPackage("custom-default")
public class CardStorageAction extends AbstractAction {

	// ------- Constants (static final) ----------------------------------------
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(CardStorageAction.class);

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------
	private List<CardStorageBean> cardStorageList = new ArrayList<CardStorageBean>();

	@Autowired
	protected CardStorageService cardStorageService;

	protected CardStorageBean cardStorageBean;

	private CardStorageDetailBean cardStorageDetailBean;

	private String jsonData;

	// ------- Constructors ----------------------------------------------------
	public CardStorageAction() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	@Action(value = "cardStorageInit", results = { @Result(name = "success", location = "/view/card/card/displayCardList.jsp"),
			@Result(name = "error", location = "/view/login.jsp") })
	public String cardStorageInit() {
		try {
			// jsonObject = JSONObject.fromObject(DataCollections.dicMenuTree.get(
			// currfunc).get(0));
			// System.out.println(DataCollections.dicMenuTree.get(currfunc).get(0));
		} catch (Exception e) {
			log.info(ErrorLogUtil.printInfo(e));
		}
		return SUCCESS;
	}

	/**
	 * 
	 * receive the request from http and handle the request to dispatch different ways based on the parameters
	 * 
	 * @param
	 * @return displayCardList jsp
	 * @throws
	 */

	@Action(value = "showCardStorageRecords", results = { @Result(name = "success", type = "json"), })
	public String showCardStorageRecords() {
		log.info("Starting to load showStorageCardList infomation from DB");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		List<CardStorageBean> cardStorageBeanList = null;
		try {
			cardStorageBeanList = this.cardStorageService.findCardStorageRecordsByCriteria(this.cardStorageBean);
			if (!cardStorageBeanList.isEmpty()) {
				JsonConfig config = new JsonConfig();
				config.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor(DateUtil.DATE_PATTERN_2));
				map.put(TOTAL, cardStorageBeanList.get(0).getTotalData());
				map.put(ROWS, cardStorageBeanList);
				this.jsonData = JSONObject.fromObject(map).toString();
			} else {
				log.info("Cannot find any card storage records from DB !");
				map.clear();
			}
			flag = true;
		} catch (net.sf.json.JSONException e) {
			log.info("Convert to Json object occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Loading card storage records data from DB occured error, please references the detail log\n " + "[" + e
					+ "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully load card storage records data from DB");
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * 
	 * receive the request from http and handle the request to dispatch different ways based on the parameters
	 * 
	 * @param
	 * @return displayCardList jsp
	 * @throws
	 */
	@Action(value = "saveCardOrder", results = { @Result(name = "success", type = "json"), })
	public String saveCardOrder() {
		log.info("Starting to save card order infomation into DB");
		boolean flag = true;
		try {
			this.cardStorageService.addCardOrder(this.cardStorageBean);
		} catch (Exception e) {
			log.info("Loading card order detail from DB occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully save card order data into DB");
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * 
	 * receive the request from http and handle the request to dispatch different ways based on the parameters
	 * 
	 * @param
	 * @return modifyCardStorage.jsp
	 * @throws com.fr.station.card.ICCard.exception.ICCardException
	 */
	@Action(value = "refreshCardOrder", results = { @Result(name = "success", location = "/view/card/card/modifyCardStorage.jsp"), })
	public String refreshCardOrder() {
		log.info("Starting to transfer card order data");
		boolean flag = false;
		try {
			this.cardStorageList = this.cardStorageService.getCardByFormCondition(this.getCardStorageBean());
			if (this.cardStorageList.size() > 0) {
				this.cardStorageBean = this.cardStorageList.get(0);
			}
			flag = true;
		} catch (Exception e) {
			log.info("transfer card order data occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully transfer card order data");
			return SUCCESS;
		}
		return ERROR;
	}

	public CardStorageBean getCardStorageBean() {
		return this.cardStorageBean;
	}

	public void setCardStorageBean(CardStorageBean cardStorageBean) {
		this.cardStorageBean = cardStorageBean;
	}

	public CardStorageDetailBean getCardStorageDetailBean() {
		return this.cardStorageDetailBean;
	}

	public void setCardStorageDetailBean(CardStorageDetailBean cardStorageDetailBean) {
		this.cardStorageDetailBean = cardStorageDetailBean;
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
