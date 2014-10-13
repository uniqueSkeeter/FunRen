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

import com.fr.station.common.bean.customer.TransferAccountsBean;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.customer.service.TransferAccountsService;
import com.fr.station.component.system.action.AbstractAction;

@Namespace("/transferAccounts")
@ParentPackage("custom-default")
public class TransferAccountsAction extends AbstractAction {

	// ------- Constants (static final) ----------------------------------------
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(TransferAccountsAction.class);

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------
	@Autowired
	protected TransferAccountsService transferAccountsService;

	protected TransferAccountsBean transferAccountsBean;

	private List<TransferAccountsBean> transferAccountsBeanList = new ArrayList<TransferAccountsBean>();

	private String jsonData;

	// ------- Constructors ----------------------------------------------------
	public TransferAccountsAction() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------
	/**
	 * 
	 * 从页面获得查询条件，查询主卡下所有副卡信息
	 * 
	 * @param
	 * @return transferAccounts.jsp
	 * @throws
	 */

	@Action(value = "showViceCardsRecords", results = { @Result(name = "success", type = "json"), })
	public String showViceCardsRecords() {
		log.info("Starting to load show vice cards records information from DB");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		List<TransferAccountsBean> transferAccountsBeanList = null;
		try {
			transferAccountsBeanList = this.transferAccountsService.findViceCardsRecordsByCriteria(this.transferAccountsBean);
			if (!transferAccountsBeanList.isEmpty()) {
				map.put(TOTAL, transferAccountsBeanList.get(0).getTotalData());
				map.put(ROWS, transferAccountsBeanList);
				this.jsonData = JSONObject.fromObject(map).toString();
				log.info("Successfully load show vice cards records data from DB");
			} else {
				log.info("Cannot find vice cards records data from DB");
				map.clear();
			}
			flag = true;
		} catch (net.sf.json.JSONException e) {
			log.info("Convert to Json object occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Loading show vice cards records data from DB occured error, please references the detail log\n " + "["
					+ e + "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * 
	 * 根据条件查询特定副卡对应的主副卡账户信息
	 * 
	 * @param
	 * @return allocateAccounts.jsp
	 */
	@Action(value = "showAccountsInfo", results = { @Result(name = "success", location = "/view/card/customer/allocateAccounts.jsp"), })
	public String showAccountsInfo() {
		log.info("Starting to find accounts info data");
		boolean flag = false;
		try {
			this.transferAccountsBeanList = this.transferAccountsService.findAccountsInfoByCriteria(this
					.getTransferAccountsBean());
			if (this.transferAccountsBeanList.size() > 0) {
				this.transferAccountsBean = this.transferAccountsBeanList.get(0);
				log.info("Successfully find accounts info data");
			}
			flag = true;
		} catch (Exception e) {
			log.info("transfer accounts data occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * 
	 * 在表FK_TT_CARDPRE中保存账户分配记录，同时更新FK_T_GUESTACC 和 FK_T_CardTZ
	 * 
	 * @param
	 * @return allocateAccounts.jsp
	 * @throws
	 */
	@Action(value = "saveAllocateRecords", results = { @Result(name = "success", type = "json"), })
	public String saveAllocateRecords() {
		log.info("Starting to save allocate records infomation into DB");
		boolean flag = true;
		try {
			this.transferAccountsService.saveAllocateRecords(this.transferAccountsBean);
			log.info("Successfully save allocate records");
		} catch (Exception e) {
			log.info("save allocate records to DB occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * 
	 * 根据条件查询特定副卡对应的主副卡账户信息
	 * 
	 * @param
	 * @return gatherAccounts.jsp
	 */
	@Action(value = "showAccountsInfoForGather", results = { @Result(name = "success", location = "/view/card/customer/gatherAccounts.jsp"), })
	public String showAccountsInfoForGather() {
		log.info("Starting to find accounts info data from DB");
		boolean flag = false;
		try {
			this.transferAccountsBeanList = this.transferAccountsService.findAccountsInfoByCriteria(this
					.getTransferAccountsBean());
			if (this.transferAccountsBeanList.size() > 0) {
				this.transferAccountsBean = this.transferAccountsBeanList.get(0);
				log.info("Successfully find accounts info data from DB");
			}
			flag = true;
		} catch (Exception e) {
			log.info("transfer accounts data occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * 
	 * 在表FK_T_CREDIT中保存账户汇总记录，同时更新FK_T_GUESTACC 和 FK_T_CardTZ
	 * 
	 * @param
	 * @return gatherAccounts.jsp
	 * @throws
	 */
	@Action(value = "saveGatherRecords", results = { @Result(name = "success", type = "json"), })
	public String saveGatherRecords() {
		log.info("Starting to save gather records infomation into DB");
		boolean flag = true;
		try {
			this.transferAccountsService.saveGatherRecords(this.transferAccountsBean);
			log.info("Successfully save gather records into DB");
		} catch (Exception e) {
			log.info("save gather records infomation into DB occured error, please references the detail log\n " + "[" + e
					+ "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * 
	 * 在表FK_T_CREDIT中保存圈存记录，同时更新 FK_T_CardTZ
	 * 
	 * @param
	 * @return gatherAccounts.jsp
	 * @throws
	 */
	@Action(value = "saveCreditForLoadRecords", results = { @Result(name = "success", type = "json"), })
	public String saveCreditForLoadRecords() {
		log.info("Starting to save credit for load records infomation into DB");
		boolean flag = true;
		try {
			this.transferAccountsService.saveCreditForLoadRecords(this.transferAccountsBean);
			log.info("Successfully save credit for load records into DB");
		} catch (Exception e) {
			log.info("save credit for load records infomation into DB occured error, please references the detail log\n " + "["
					+ e + "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}

	public TransferAccountsBean getTransferAccountsBean() {
		return this.transferAccountsBean;
	}

	public void setTransferAccountsBean(TransferAccountsBean transferAccountsBean) {
		this.transferAccountsBean = transferAccountsBean;
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
