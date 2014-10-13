package com.fr.station.common.bean.customer;

import java.math.BigDecimal;

import com.fr.station.common.bean.system.CommonBean;
import com.fr.station.common.bean.system.StandardBean;

public class TransferAccountsBean extends CommonBean implements StandardBean {

	// ------- Constants (static final) ----------------------------------------

	// ------- Static Variables (static) ---------------------------------------
	private static final long serialVersionUID = 1L;

	// ------- Instance Variables (private) ------------------------------------

	/**
	 * 主卡号
	 */
	private String mainCardNo;

	/**
	 * 客户编号
	 */

	private String guestNo;

	/**
	 * 单位名称
	 */

	private String mainCardGuestName;

	/**
	 * 单位证件号
	 */
	private String mainCardIDNum;

	/**
	 * 主卡客户状态
	 */

	private String mainCardGuestStatus;

	/**
	 * 主卡状态
	 */

	private String mainCardStatus;

	/**
	 * 主卡备付金余额
	 */

	private BigDecimal mainCardProvisionAccount;

	/**
	 * 主卡积分余额
	 */
	private BigDecimal mainCardPoint;

	/**
	 * 副卡号
	 */

	private String viceCardNo;

	/**
	 * 副卡司机姓名
	 */

	private String viceCardGuestName;

	/**
	 * 副卡司机证件号
	 */

	private String viceCardIDNum;

	/**
	 * 副卡部门编号
	 */

	private String viceCardDepNo;

	/**
	 * 副卡部门名称
	 */

	private String viceCardDepName;

	/**
	 * 副卡状态
	 */

	private String viceCardStatus;

	/**
	 * 副卡类型
	 */

	private String viceCardType;

	/**
	 * 副卡备付账户余额
	 */

	private BigDecimal viceCardProvisionAccount;

	/**
	 * 副卡卡内余额
	 */

	private BigDecimal viceCardBalance;

	/**
	 * 副卡积分
	 */
	private BigDecimal viceCardPoint;

	/**
	 * 副卡有效日期
	 */
	private String viceCardEffectiveDate;

	/**
	 * 分配积分
	 */
	private Integer allocatePoint;

	/**
	 * 分配金额
	 */

	private BigDecimal allocateAmount;

	/**
	 * 分配类型
	 */
	private String allocateType;

	/**
	 * 汇总金额
	 */

	private BigDecimal gatherAmount;

	/**
	 * 交易类型
	 */
	private String tradeType;

	/**
	 * 支付方式
	 */
	private String payType;

	// ------- Constructors ----------------------------------------------------

	public TransferAccountsBean() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	public String getMainCardNo() {
		return this.mainCardNo;
	}

	public void setMainCardNo(String mainCardNo) {
		this.mainCardNo = mainCardNo;
	}

	public String getGuestNo() {
		return this.guestNo;
	}

	public void setGuestNo(String guestNo) {
		this.guestNo = guestNo;
	}

	public String getMainCardGuestName() {
		return this.mainCardGuestName;
	}

	public void setMainCardGuestName(String mainCardGuestName) {
		this.mainCardGuestName = mainCardGuestName;
	}

	public String getMainCardIDNum() {
		return this.mainCardIDNum;
	}

	public void setMainCardIDNum(String mainCardIDNum) {
		this.mainCardIDNum = mainCardIDNum;
	}

	public String getMainCardGuestStatus() {
		return this.mainCardGuestStatus;
	}

	public void setMainCardGuestStatus(String mainCardGuestStatus) {
		this.mainCardGuestStatus = mainCardGuestStatus;
	}

	public String getMainCardStatus() {
		return this.mainCardStatus;
	}

	public void setMainCardStatus(String mainCardStatus) {
		this.mainCardStatus = mainCardStatus;
	}

	public BigDecimal getMainCardProvisionAccount() {
		return this.mainCardProvisionAccount;
	}

	public void setMainCardProvisionAccount(BigDecimal mainCardProvisionAccount) {
		this.mainCardProvisionAccount = mainCardProvisionAccount;
	}

	public String getViceCardNo() {
		return this.viceCardNo;
	}

	public void setViceCardNo(String viceCardNo) {
		this.viceCardNo = viceCardNo;
	}

	public String getViceCardGuestName() {
		return this.viceCardGuestName;
	}

	public void setViceCardGuestName(String viceCardGuestName) {
		this.viceCardGuestName = viceCardGuestName;
	}

	public String getViceCardDepNo() {
		return this.viceCardDepNo;
	}

	public void setViceCardDepNo(String viceCardDepNo) {
		this.viceCardDepNo = viceCardDepNo;
	}

	public String getViceCardDepName() {
		return this.viceCardDepName;
	}

	public void setViceCardDepName(String viceCardDepName) {
		this.viceCardDepName = viceCardDepName;
	}

	public String getViceCardStatus() {
		return this.viceCardStatus;
	}

	public void setViceCardStatus(String viceCardStatus) {
		this.viceCardStatus = viceCardStatus;
	}

	public BigDecimal getViceCardProvisionAccount() {
		return this.viceCardProvisionAccount;
	}

	public void setViceCardProvisionAccount(BigDecimal viceCardProvisionAccount) {
		this.viceCardProvisionAccount = viceCardProvisionAccount;
	}

	public BigDecimal getAllocateAmount() {
		return this.allocateAmount;
	}

	public void setAllocateAmount(BigDecimal allocateAmount) {
		this.allocateAmount = allocateAmount;
	}

	public BigDecimal getGatherAmount() {
		return this.gatherAmount;
	}

	public void setGatherAmount(BigDecimal gatherAmount) {
		this.gatherAmount = gatherAmount;
	}

	public String getTradeType() {
		return this.tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getPayType() {
		return this.payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getViceCardIDNum() {
		return this.viceCardIDNum;
	}

	public void setViceCardIDNum(String viceCardIDNum) {
		this.viceCardIDNum = viceCardIDNum;
	}

	public String getViceCardType() {
		return this.viceCardType;
	}

	public void setViceCardType(String viceCardType) {
		this.viceCardType = viceCardType;
	}

	public BigDecimal getViceCardBalance() {
		return this.viceCardBalance;
	}

	public void setViceCardBalance(BigDecimal viceCardBalance) {
		this.viceCardBalance = viceCardBalance;
	}

	public BigDecimal getViceCardPoint() {
		return this.viceCardPoint;
	}

	public void setViceCardPoint(BigDecimal viceCardPoint) {
		this.viceCardPoint = viceCardPoint;
	}

	public String getViceCardEffectiveDate() {
		return this.viceCardEffectiveDate;
	}

	public void setViceCardEffectiveDate(String viceCardEffectiveDate) {
		this.viceCardEffectiveDate = viceCardEffectiveDate;
	}

	public Integer getAllocatePoint() {
		return this.allocatePoint;
	}

	public void setAllocatePoint(Integer allocatePoint) {
		this.allocatePoint = allocatePoint;
	}

	public BigDecimal getMainCardPoint() {
		return this.mainCardPoint;
	}

	public void setMainCardPoint(BigDecimal mainCardPoint) {
		this.mainCardPoint = mainCardPoint;
	}

	public String getAllocateType() {
		return this.allocateType;
	}

	public void setAllocateType(String allocateType) {
		this.allocateType = allocateType;
	}

	@Override
	public String toString() {
		return "TransferAccountsBean [mainCardNo=" + this.mainCardNo + ", guestNo=" + this.guestNo + ", mainCardGuestName="
				+ this.mainCardGuestName + ", mainCardIDNum=" + this.mainCardIDNum + ", mainCardGuestStatus="
				+ this.mainCardGuestStatus + ", mainCardStatus=" + this.mainCardStatus + ", mainCardProvisionAccount="
				+ this.mainCardProvisionAccount + ", mainCardPoint=" + this.mainCardPoint + ", viceCardNo=" + this.viceCardNo
				+ ", viceCardGuestName=" + this.viceCardGuestName + ", viceCardIDNum=" + this.viceCardIDNum
				+ ", viceCardDepNo=" + this.viceCardDepNo + ", viceCardDepName=" + this.viceCardDepName + ", viceCardStatus="
				+ this.viceCardStatus + ", viceCardType=" + this.viceCardType + ", viceCardProvisionAccount="
				+ this.viceCardProvisionAccount + ", viceCardBalance=" + this.viceCardBalance + ", viceCardPoint="
				+ this.viceCardPoint + ", viceCardEffectiveDate=" + this.viceCardEffectiveDate + ", allocatePoint="
				+ this.allocatePoint + ", allocateAmount=" + this.allocateAmount + ", allocateType=" + this.allocateType
				+ ", gatherAmount=" + this.gatherAmount + ", tradeType=" + this.tradeType + ", payType=" + this.payType + "]";
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
