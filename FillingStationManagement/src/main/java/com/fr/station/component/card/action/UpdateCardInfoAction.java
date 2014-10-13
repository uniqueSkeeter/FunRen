package com.fr.station.component.card.action;

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

import com.fr.station.common.bean.card.UpdateCardInfoBean;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.card.service.CardInfoService;
import com.fr.station.component.system.action.AbstractAction;

/**
 * 卡片明细的action，用于处理得到卡片明细的数据
 * 
 * @author yy
 */
@Namespace("/updateCardInfo")
@ParentPackage("custom-default")
public class UpdateCardInfoAction extends AbstractAction {

	// ------- Constants (static final) ----------------------------------------

	private static final long serialVersionUID = 1L;

	protected static Logger log = Logger.getLogger(UpdateCardInfoAction.class);

	// ------- Static Variables (static) ---------------------------------------

	@Autowired
	protected CardInfoService cardInfoService;

	public UpdateCardInfoAction() {
		super();
	}

	protected UpdateCardInfoBean updateCardInfoBean = new UpdateCardInfoBean();

	private List<UpdateCardInfoBean> cardInfoList = new ArrayList<UpdateCardInfoBean>();

	private String jsonData;

	// ------- Instance Methods (public) ---------------------------------------

	public UpdateCardInfoBean getUpdateCardInfoBean() {
		return this.updateCardInfoBean;
	}

	public void setUpdateCardInfoBean(UpdateCardInfoBean updateCardInfoBean) {
		this.updateCardInfoBean = updateCardInfoBean;
	}

	public String getJsonData() {
		return this.jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	/**
	 * 
	 * 卡片明细初始化
	 */
	@Action(value = "cardInfoInit", results = {
			@Result(name = "success", location = "/view/card/card/maintain/updatePersonalCard.jsp"),
			@Result(name = "error", location = "/view/login.jsp") })
	public String cardInfoInit() {
		try {
		} catch (Exception e) {
			log.info(ErrorLogUtil.printInfo(e));
		}
		return SUCCESS;
	}

	/**
	 * 主卡卡片明细初始化
	 */
	@Action(value = "mainCardInfoInit", results = {
			@Result(name = "success", location = "/view/card/card/maintain/displayCorpCard.jsp"),
			@Result(name = "error", location = "/view/login.jsp") })
	public String mainCardInfoInit() {
		try {
		} catch (Exception e) {
			log.info(ErrorLogUtil.printInfo(e));
		}
		return SUCCESS;
	}

	/**
	 * 显示卡片详细信息
	 */
	@Action(value = "showCardInfo", results = {
			@Result(name = "success", location = "/view/card/card/maintain/updatePersonalCard.jsp"),
			@Result(name = "error", location = "/view/login.jsp") })
	public String showCardInfo() {
		log.info("Starting to search for card info data");
		try {
			this.updateCardInfoBean = this.cardInfoService.getCardInfo(this.updateCardInfoBean);
			if (this.updateCardInfoBean != null) {
				log.info("Successfully find card detail data");
			} else {
				log.info("Can not find coresponding card detail data from database based on the input criteria");
			}
		} catch (Exception e) {
			log.info("search for card detail data error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 显示卡片详细信息
	 */
	@Action(value = "showMainCardInfo", results = { @Result(name = "success", type = "json") })
	public String showMainCardInfo() {
		log.info("Starting to search for maincard info data");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		try {
			this.cardInfoList = this.cardInfoService.findViceCardsRecordsByCriteria(this.updateCardInfoBean);
			if (!this.cardInfoList.isEmpty()) {
				map.put(TOTAL, this.cardInfoList.get(0).getTotalData());
				map.put(ROWS, this.cardInfoList);
				this.jsonData = JSONObject.fromObject(map).toString();
				log.info("Successfully find maincard info data");
			} else {
				log.info("Cannot find maincard info from DB");
				map.clear();
			}
			flag = true;
		} catch (net.sf.json.JSONException e) {
			log.info("Convert to Json object occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Loading maincard info from DB occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * 得到司机卡信息
	 */

	@Action(value = "loadDriver", results = {
			@Result(name = "success", location = "/view/card/card/maintain/updateSubCard.jsp"),
			@Result(name = "error", location = "/view/login.jsp") })
	public String loadDriver() {
		log.info("Starting to search for (driver) card information data");
		try {
			this.updateCardInfoBean = this.cardInfoService.getDriverCardInfo(this.updateCardInfoBean);
			if (this.updateCardInfoBean != null) {
				log.info("Successfully find card detail data");
			} else {
				log.info("Can not find coresponding card detail data from database based on the input criteria");
			}
		} catch (Exception e) {
			log.info("find driver card info occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 更改卡片信息
	 */
	@Action(value = "saveCardInfo", results = { @Result(name = "success", type = "json"), })
	public String saveCardInfo() {
		log.info("Starting to save Card(cardinfo) infomation into DB");
		boolean flag = false;
		try {
			this.cardInfoService.saveCardInfo(this.updateCardInfoBean);
			flag = true;
		} catch (Exception e) {
			log.info("save cardinfo data into DB occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully save Card(cardinfo) data into DB");
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * 
	 * 卡片详细初始化
	 */
	@Action(value = "cardDetailInit", results = {
			@Result(name = "success", location = "/view/card/card/maintain/cardDetail.jsp"),
			@Result(name = "error", location = "/view/login.jsp") })
	public String cardDetailInit() {
		try {
		} catch (Exception e) {
			log.info(ErrorLogUtil.printInfo(e));
		}
		return SUCCESS;
	}

	/**
	 * 显示卡片详细信息
	 */
	@Action(value = "showCardDetail", results = {
			@Result(name = "success", location = "/view/card/card/maintain/cardDetail.jsp"),
			@Result(name = "error", location = "/view/login.jsp") })
	public String showCardDetail() {
		log.info("Starting to search for card detail data");
		boolean flag = false;
		try {
			this.cardInfoList = this.cardInfoService.getCardDetail(this.updateCardInfoBean);
			if (this.cardInfoList.size() > 0) {
				this.updateCardInfoBean = this.cardInfoList.get(0);
				log.info("Successfully find card detail data");
			} else {
				log.info("Can not find coresponding card detail data from database based on the input criteria.");
				this.updateCardInfoBean = null;
			}
			flag = true;
		} catch (Exception e) {
			log.info("search for card detail data error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;

	}

}
