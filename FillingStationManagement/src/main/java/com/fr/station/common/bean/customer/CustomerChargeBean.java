package com.fr.station.common.bean.customer;

import java.math.BigDecimal;

import com.fr.station.common.bean.system.StandardBean;

public class CustomerChargeBean implements StandardBean {

	// ------- Constants (static final) ----------------------------------------
	private static final long serialVersionUID = 1L;

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------
	private Integer id;

	/**
	 * 主卡号(cardNo) FKT_Guest(客户信息表)
	 */
	private String mainCardNo;

	/**
	 * 客户编号(guestNo) FKT_Card(卡信息表) || 客户编号(guestNo) FKT_Guest(客户信息表)||客户编号(guestNo) FKT_GuestAcc(客户账户信息表)
	 */
	private String guestNo;

	/**
	 * 卡号(cardNo) FKT_CardTZ(卡帳信息表)||卡号(cardNo) FKT_Card(卡信息表)
	 */
	private String cardNo;

	/**
	 * 持卡人(guestName) FKT_Card(卡信息表)
	 * 
	 */
	private String guestName;

	/**
	 * 卡状态(cardStatus) FKT_Card(卡信息表)
	 */
	private String cardStatus;

	/**
	 * 卡片类型(cardType) FKT_Card(卡信息表)
	 */
	private String cardType;

	/**
	 * 主卡标识(cardFlag) FKT_Card(卡信息表)
	 */
	private boolean mainCardFlag;

	/**
	 * 证件类型(guestType) FKT_Card(卡信息表)
	 */
	private String guestType;

	/**
	 * 证件号(guestNum) FKT_Card(卡信息表)
	 */
	private String guestNum;

	/**
	 * 钱包账户/卡内余额(cardBal) FKT_CardTZ(卡账信息表)
	 */
	private BigDecimal cardAccount;

	/**
	 * 卡备用金余额(pre) FKT_CardTZ(卡账信息表)
	 */
	private BigDecimal cardPre;

	/**
	 * 单位名称(guestName) FKT_Guest(客户信息表)
	 */
	private String companyName;

	/**
	 * 客户状态(status) FKT_Guest(客户信息表)
	 */
	private String guestStatus;

	/**
	 * 单位类型(guestType) FKT_Guest(客户信息表)
	 */
	private String companyType;

	/**
	 * 账户余额(bal) FKT_GuestAcc(客户账户信息表)
	 */
	private BigDecimal spareAccount;

	/**
	 * 卡账户余额(cardacc) FKT_GuestAcc(客户账户信息表)
	 */
	private BigDecimal cardAccountLeft;

	/**
	 * 金额 交易金额(amn) FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	private BigDecimal chargeAmount;

	/**
	 * 支付类型(zffs) FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	private String payType;

	/**
	 * 交易类型(jylx) FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	private String tradeType;

	/**
	 * 交易序号(incno) FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	private String bankSerialNum;

	/**
	 * 充值总和(creditacc) FKT_GuestAcc(客户账户信息表)
	 */
	private BigDecimal rechargeAmount;

	// ------- Constructors ----------------------------------------------------
	public CustomerChargeBean() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 主卡号(cardNo) FKT_Guest(客户信息表)
	 */
	public String getMainCardNo() {
		return this.mainCardNo;
	}

	/**
	 * 主卡号(cardNo) FKT_Guest(客户信息表)
	 */
	public void setMainCardNo(String mainCardNo) {
		this.mainCardNo = mainCardNo;
	}

	/**
	 * 卡号(cardNo) FKT_CardTZ(卡帳信息表)||卡号(cardNo) FKT_Card(卡信息表)
	 */
	public String getCardNo() {
		return this.cardNo;
	}

	/**
	 * 卡号(cardNo) FKT_CardTZ(卡帳信息表)||卡号(cardNo) FKT_Card(卡信息表)
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	/**
	 * 卡片类型(cardType) FKT_Card(卡信息表)
	 */
	public String getCardType() {
		return this.cardType;
	}

	/**
	 * 卡片类型(cardType) FKT_Card(卡信息表)
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * 卡状态(cardStatus) FKT_Card(卡信息表)
	 */
	public String getCardStatus() {
		return this.cardStatus;
	}

	/**
	 * 卡状态(cardStatus) FKT_Card(卡信息表)
	 */
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	/**
	 * 客户编号(guestNo) FKT_Card(卡信息表) || 客户编号(guestNo) FKT_Guest(客户信息表)||客户编号(guestNo) FKT_GuestAcc(客户账户信息表)
	 */
	public String getGuestNo() {
		return this.guestNo;
	}

	/**
	 * 客户编号(guestNo) FKT_Card(卡信息表) || 客户编号(guestNo) FKT_Guest(客户信息表)||客户编号(guestNo) FKT_GuestAcc(客户账户信息表)
	 */
	public void setGuestNo(String guestNo) {
		this.guestNo = guestNo;
	}

	/**
	 * 客户状态(status) FKT_Guest(客户信息表)
	 */
	public String getGuestStatus() {
		return this.guestStatus;
	}

	/**
	 * 客户状态(status) FKT_Guest(客户信息表)
	 */
	public void setGuestStatus(String guestStatus) {
		this.guestStatus = guestStatus;
	}

	/**
	 * 客户姓名/单位名称(guestName) FKT_Guest(客户信息表) || 客户姓名/单位名称(guestName) FKT_Card(卡信息表)||客户名称/单位名称(guestName)
	 * FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	public String getGuestName() {
		return this.guestName;
	}

	/**
	 * 客户姓名/单位名称(guestName) FKT_Guest(客户信息表) || 客户姓名/单位名称(guestName) FKT_Card(卡信息表)||客户名称/单位名称(guestName)
	 * FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	/**
	 * 证件号(guestNum) FKT_Card(卡信息表)
	 */
	public String getGuestNum() {
		return this.guestNum;
	}

	/**
	 * 证件号(guestNum) FKT_Card(卡信息表)
	 */
	public void setGuestNum(String guestNum) {
		this.guestNum = guestNum;
	}

	/**
	 * 证件类型(guestType) FKT_Card(卡信息表)
	 */
	public String getGuestType() {
		return this.guestType;
	}

	/**
	 * 证件类型(guestType) FKT_Card(卡信息表)
	 */
	public void setGuestType(String guestType) {
		this.guestType = guestType;
	}

	/**
	 * 钱包账户/卡内余额(cardBal) FKT_CardTZ(卡账信息表)
	 */
	public BigDecimal getCardAccount() {
		return this.cardAccount;
	}

	/**
	 * 钱包账户/卡内余额(cardBal) FKT_CardTZ(卡账信息表)
	 */
	public void setCardAccount(BigDecimal cardAccount) {
		this.cardAccount = cardAccount;
	}

	/**
	 * 备用金余额(bal) FKT_GuestAcc(客户账户信息表)
	 */
	public BigDecimal getSpareAccount() {
		return this.spareAccount;
	}

	/**
	 * 备用金余额(bal) FKT_GuestAcc(客户账户信息表)
	 */
	public void setSpareAccount(BigDecimal spareAccount) {
		this.spareAccount = spareAccount;
	}

	/**
	 * 卡账户余额(cardacc) FKT_GuestAcc(客户账户信息表)
	 */
	public BigDecimal getCardAccountLeft() {
		return this.cardAccountLeft;
	}

	/**
	 * 卡账户余额(cardacc) FKT_GuestAcc(客户账户信息表)
	 */
	public void setCardAccountLeft(BigDecimal cardAccountLeft) {
		this.cardAccountLeft = cardAccountLeft;
	}

	/**
	 * 金额 交易金额(amn) FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	public BigDecimal getChargeAmount() {
		return this.chargeAmount;
	}

	/**
	 * 金额 交易金额(amn) FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	/**
	 * 支付类型(zffs) FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	public String getPayType() {
		return this.payType;
	}

	/**
	 * 支付类型(zffs) FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}

	/**
	 * 交易类型(jylx) FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	public String getTradeType() {
		return this.tradeType;
	}

	/**
	 * 交易类型(jylx) FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	/**
	 * 交易序号(incno) FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	public String getBankSerialNum() {
		return this.bankSerialNum;
	}

	/**
	 * 交易序号(incno) FK_TT_GUESTCREDIT(客户交易明细表)
	 */
	public void setBankSerialNum(String bankSerialNum) {
		this.bankSerialNum = bankSerialNum;
	}

	/**
	 * 充值总和(creditacc) FKT_GuestAcc(客户账户信息表)
	 */
	public BigDecimal getRechargeAmount() {
		return this.rechargeAmount;
	}

	/**
	 * 充值总和(creditacc) FKT_GuestAcc(客户账户信息表)
	 */
	public void setRechargeAmount(BigDecimal rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	/**
	 * 主卡标识(cardFlag) FKT_Card(卡信息表)
	 */
	public boolean isMainCardFlag() {
		return this.mainCardFlag;
	}

	/**
	 * 主卡标识(cardFlag) FKT_Card(卡信息表)
	 */
	public void setMainCardFlag(boolean mainCardFlag) {
		this.mainCardFlag = mainCardFlag;
	}

	/**
	 * 卡备用金余额(pre) FKT_CardTZ(卡账信息表)
	 */
	public BigDecimal getCardPre() {
		return this.cardPre;
	}

	/**
	 * 卡备用金余额(pre) FKT_CardTZ(卡账信息表)
	 */
	public void setCardPre(BigDecimal cardPre) {
		this.cardPre = cardPre;
	}

	/**
	 * 单位名称(guestName) FKT_Guest(客户信息表)
	 */
	public String getCompanyName() {
		return this.companyName;
	}

	/**
	 * 单位名称(guestName) FKT_Guest(客户信息表)
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 单位类型(guestType) FKT_Guest(客户信息表)
	 */
	public String getCompanyType() {
		return this.companyType;
	}

	/**
	 * 单位类型(guestType) FKT_Guest(客户信息表)
	 */
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	@Override
	public String toString() {
		return "CustomerChargeBean [id=" + this.id + ", mainCardNo=" + this.mainCardNo + ", guestNo=" + this.guestNo
				+ ", cardNo=" + this.cardNo + ", guestName=" + this.guestName + ", cardStatus=" + this.cardStatus
				+ ", cardType=" + this.cardType + ", mainCardFlag=" + this.mainCardFlag + ", guestType=" + this.guestType
				+ ", guestNum=" + this.guestNum + ", cardAccount=" + this.cardAccount + ", cardPre=" + this.cardPre
				+ ", companyName=" + this.companyName + ", guestStatus=" + this.guestStatus + ", companyType="
				+ this.companyType + ", spareAccount=" + this.spareAccount + ", cardAccountLeft=" + this.cardAccountLeft
				+ ", chargeAmount=" + this.chargeAmount + ", payType=" + this.payType + ", tradeType=" + this.tradeType
				+ ", bankSerialNum=" + this.bankSerialNum + ", rechargeAmount=" + this.rechargeAmount + "]";
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
