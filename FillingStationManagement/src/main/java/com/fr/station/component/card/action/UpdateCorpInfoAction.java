package com.fr.station.component.card.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.fr.station.common.bean.card.UpdateCardInfoBean;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.card.service.CorpInfoService;
import com.fr.station.component.system.action.AbstractAction;

/**
 * 卡片明细的action，用于处理得到卡片明细的数据
 * 
 * @author yy
 */
@Namespace("/updateCorpInfo")
@ParentPackage("custom-default")
public class UpdateCorpInfoAction extends AbstractAction {

	// ------- Constants (static final) ----------------------------------------

	private static final long serialVersionUID = 1L;

	protected static Logger log = Logger.getLogger(UpdateCorpInfoAction.class);

	// ------- Static Variables (static) ---------------------------------------

	@Autowired
	protected CorpInfoService corpInfoService;

	public UpdateCorpInfoAction() {
		super();
	}

	protected UpdateCardInfoBean updateCardInfoBean = new UpdateCardInfoBean();

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
	 * 查询客户信息
	 */
	@Action(value = "showGuestInfo", results = {
			@Result(name = "success", location = "/view/card/card/maintain/updateCorpCard.jsp"),
			@Result(name = "error", location = "/view/login.jsp") })
	public String showGuestInfo() {
		log.info("Starting to search for guest information data");
		try {
			this.updateCardInfoBean = this.corpInfoService.getCorpInfo(this.updateCardInfoBean);
			if (this.updateCardInfoBean != null) {
				log.info("Successfully find guest data");
			} else {
				log.info("Can not find coresponding guest data from database based on the input criteria");
			}
		} catch (Exception e) {
			log.info("find guest info occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 更改客户信息
	 */
	@Action(value = "saveGuestInfo", results = { @Result(name = "success", type = "json"), })
	public String saveGuestInfo() {
		log.info("Starting to save guestinfo infomation into DB");
		boolean flag = false;
		try {
			this.corpInfoService.saveCorpInfo(this.updateCardInfoBean);
			flag = true;
		} catch (Exception e) {
			log.info("save guestinfo data into DB occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully save guestinfo data into DB");
			return SUCCESS;
		}
		return ERROR;
	}
}
