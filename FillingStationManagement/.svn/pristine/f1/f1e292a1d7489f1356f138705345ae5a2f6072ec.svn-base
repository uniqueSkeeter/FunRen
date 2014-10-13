package com.fr.station.common.bean.customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fr.station.common.bean.system.StandardBean;

public class CustomerDeleteBean implements StandardBean {

	// ------- Constants (static final) ----------------------------------------
	private static final long serialVersionUID = 1L;

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	private Integer id;

	// 卡信息

	/**
	 * 卡号(cardNo) FKT_CardTZ(卡帳信息表)||卡号(cardNo) FKT_Card(卡信息表)
	 */
	private String cardNo;

	/**
	 * 卡状态(cardStatus) FKT_Card(卡信息表)
	 */
	private String cardStatus;

	/**
	 * 是否主卡标识(cardFlag) FKT_Card(卡信息表)
	 */
	private Boolean mainCardFlag;

	/**
	 * 卡片类型(cardType) FKT_Card(卡信息表)
	 */
	private String cardType;

	/**
	 * 押金(deposit) FKT_Card(卡信息表)
	 */
	private BigDecimal deposit;

	/**
	 * 备注(bz) FKT_Card(卡信息表)
	 */
	private String cardRemark;

	// 客户信息
	/**
	 * 客户名称/单位名称(guestName) FKT_Guest(客户信息表) || 客户名称(guestName) FKT_Card(卡信息表)
	 */
	private String guestName;

	/**
	 * 客户名称/单位名称(guestName) FKT_Guest(客户信息表)
	 */
	private String companyName;

	/**
	 * 联系人证件类型(idCardType) FKT_Guest(客户信息表) || 证件类型(guestType) FKT_Card(卡信息表)
	 */
	private String identityType;

	/**
	 * 联系人证件号(idCardNum) FKT_Guest(客户信息表) || 证件号码(guestNum) FKT_Card(卡信息表)
	 */
	private String identityNum;

	/**
	 * 客户编号(guestNo) FKT_Guest(客户信息表) || 客户编号(guestNo) FKT_Card(卡信息表)
	 */
	private String guestNo;

	/**
	 * 客户状态(stats) FKT_Guest(客户信息表)
	 */
	private String guestStatus;

	/**
	 * 备注(beizhu) FKT_Guest(客户信息表)
	 */
	private String guestRemark;

	// 卡账户信息
	/**
	 * 卡内余额(cardBal) FKT_CardTZ(卡账信息表)
	 */
	private BigDecimal cardAccount;

	/**
	 * 预分配金额(pre) FKT_CardTZ(卡账信息表)
	 */
	private BigDecimal preAccount;

	/**
	 * 卡积分(score) FKT_CardTZ(卡账信息表)
	 */
	private BigDecimal cardScore;

	// 客户账户信息
	/**
	 * 客户账户余额(bal) FKT_GuestAcc(客户账户信息表)
	 */
	private BigDecimal spareAccount;

	/**
	 * 已分配金额(inuse) FKT_GuestAcc(客户账户信息表)
	 */
	private BigDecimal inuseAccount;

	/**
	 * 积分余额(score) FKT_GuestAcc(客户账户信息表)
	 */
	private BigDecimal guestScore;

	/**
	 * 卡余额总和
	 */
	private BigDecimal accountSum;

	/**
	 * 卡备用金总和
	 */
	private BigDecimal preSum;

	/**
	 * 积分总和
	 */
	private BigDecimal scoreSum;

	/**
	 * datagrid控制
	 */
	private int pageNumber;

	/**
	 * datagrid控制
	 */
	private int pageSize;

	/**
	 * datagrid控制
	 */
	private int totalData;

	private final List<CustomerDeleteBean> customerDeleteList = new ArrayList<CustomerDeleteBean>();

	// ------- Constructors ----------------------------------------------------
	public CustomerDeleteBean() {
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
	 * 是否主卡标识(cardFlag) FKT_Card(卡信息表)
	 */
	public Boolean getMainCardFlag() {
		return this.mainCardFlag;
	}

	/**
	 * 是否主卡标识(cardFlag) FKT_Card(卡信息表)
	 */
	public void setMainCardFlag(Boolean mainCardFlag) {
		this.mainCardFlag = mainCardFlag;
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
	 * 押金(deposit) FKT_Card(卡信息表)
	 */
	public BigDecimal getDeposit() {
		return this.deposit;
	}

	/**
	 * 押金(deposit) FKT_Card(卡信息表)
	 */
	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	/**
	 * 备注(bz) FKT_Card(卡信息表)
	 */
	public String getCardRemark() {
		return this.cardRemark;
	}

	/**
	 * 备注(bz) FKT_Card(卡信息表)
	 */
	public void setCardRemark(String cardRemark) {
		this.cardRemark = cardRemark;
	}

	/**
	 * 客户名称/单位名称(guestName) FKT_Guest(客户信息表) || 客户名称(guestName) FKT_Card(卡信息表)
	 */
	public String getGuestName() {
		return this.guestName;
	}

	/**
	 * 客户名称/单位名称(guestName) FKT_Guest(客户信息表) || 客户名称(guestName) FKT_Card(卡信息表)
	 */
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	/**
	 * 联系人证件类型(idCardType) FKT_Guest(客户信息表) || 证件类型(guestType) FKT_Card(卡信息表)
	 */
	public String getIdentityType() {
		return this.identityType;
	}

	/**
	 * 联系人证件类型(idCardType) FKT_Guest(客户信息表) || 证件类型(guestType) FKT_Card(卡信息表)
	 */
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	/**
	 * 联系人证件号(idCardNum) FKT_Guest(客户信息表) || 证件号码(guestNum) FKT_Card(卡信息表)
	 */
	public String getIdentityNum() {
		return this.identityNum;
	}

	/**
	 * 联系人证件号(idCardNum) FKT_Guest(客户信息表) || 证件号码(guestNum) FKT_Card(卡信息表)
	 */
	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}

	/**
	 * 客户编号(guestNo) FKT_Guest(客户信息表) || 客户编号(guestNo) FKT_Card(卡信息表)
	 */
	public String getGuestNo() {
		return this.guestNo;
	}

	/**
	 * 客户编号(guestNo) FKT_Guest(客户信息表) || 客户编号(guestNo) FKT_Card(卡信息表)
	 */
	public void setGuestNo(String guestNo) {
		this.guestNo = guestNo;
	}

	/**
	 * 客户状态(stats) FKT_Guest(客户信息表)
	 */
	public String getGuestStatus() {
		return this.guestStatus;
	}

	/**
	 * 客户状态(stats) FKT_Guest(客户信息表)
	 */
	public void setGuestStatus(String guestStatus) {
		this.guestStatus = guestStatus;
	}

	/**
	 * 备注(beizhu) FKT_Guest(客户信息表)
	 */
	public String getGuestRemark() {
		return this.guestRemark;
	}

	/**
	 * 备注(beizhu) FKT_Guest(客户信息表)
	 */
	public void setGuestRemark(String guestRemark) {
		this.guestRemark = guestRemark;
	}

	/**
	 * 卡内余额(cardBal) FKT_CardTZ(卡账信息表)
	 */
	public BigDecimal getCardAccount() {
		return this.cardAccount;
	}

	/**
	 * 卡内余额(cardBal) FKT_CardTZ(卡账信息表)
	 */
	public void setCardAccount(BigDecimal cardAccount) {
		this.cardAccount = cardAccount;
	}

	/**
	 * 预分配金额(pre) FKT_CardTZ(卡账信息表)
	 */
	public BigDecimal getPreAccount() {
		return this.preAccount;
	}

	/**
	 * 预分配金额(pre) FKT_CardTZ(卡账信息表)
	 */
	public void setPreAccount(BigDecimal preAccount) {
		this.preAccount = preAccount;
	}

	/**
	 * 卡积分(score) FKT_CardTZ(卡账信息表)
	 */
	public BigDecimal getCardScore() {
		return this.cardScore;
	}

	/**
	 * 卡积分(score) FKT_CardTZ(卡账信息表)
	 */
	public void setCardScore(BigDecimal cardScore) {
		this.cardScore = cardScore;
	}

	/**
	 * 客户账户余额(bal) FKT_GuestAcc(客户账户信息表)
	 */
	public BigDecimal getSpareAccount() {
		return this.spareAccount;
	}

	/**
	 * 客户账户余额(bal) FKT_GuestAcc(客户账户信息表)
	 */
	public void setSpareAccount(BigDecimal spareAccount) {
		this.spareAccount = spareAccount;
	}

	/**
	 * 已分配金额(inuse) FKT_GuestAcc(客户账户信息表)
	 */
	public BigDecimal getInuseAccount() {
		return this.inuseAccount;
	}

	/**
	 * 已分配金额(inuse) FKT_GuestAcc(客户账户信息表)
	 */
	public void setInuseAccount(BigDecimal inuseAccount) {
		this.inuseAccount = inuseAccount;
	}

	/**
	 * 积分余额(score) FKT_GuestAcc(客户账户信息表)
	 */
	public BigDecimal getGuestScore() {
		return this.guestScore;
	}

	/**
	 * 积分余额(score) FKT_GuestAcc(客户账户信息表)
	 */
	public void setGuestScore(BigDecimal guestScore) {
		this.guestScore = guestScore;
	}

	/**
	 * datagrid控制
	 */
	public int getPageNumber() {
		return this.pageNumber;
	}

	/**
	 * datagrid控制
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * datagrid控制
	 */
	public int getPageSize() {
		return this.pageSize;
	}

	/**
	 * datagrid控制
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * datagrid控制
	 */
	public int getTotalData() {
		return this.totalData;
	}

	/**
	 * datagrid控制
	 */
	public void setTotalData(int totalData) {
		this.totalData = totalData;
	}

	/**
	 * 客户名称/单位名称(guestName) FKT_Guest(客户信息表)
	 */
	public String getCompanyName() {
		return this.companyName;
	}

	/**
	 * 客户名称/单位名称(guestName) FKT_Guest(客户信息表)
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 卡余额总和
	 */
	public BigDecimal getAccountSum() {
		return this.accountSum;
	}

	/**
	 * 卡余额总和
	 */
	public void setAccountSum(BigDecimal accountSum) {
		this.accountSum = accountSum;
	}

	/**
	 * 卡备用金总和
	 */
	public BigDecimal getPreSum() {
		return this.preSum;
	}

	/**
	 * 卡备用金总和
	 */
	public void setPreSum(BigDecimal preSum) {
		this.preSum = preSum;
	}

	/**
	 * 积分总和
	 */
	public BigDecimal getScoreSum() {
		return this.scoreSum;
	}

	/**
	 * 积分总和
	 */
	public void setScoreSum(BigDecimal scoreSum) {
		this.scoreSum = scoreSum;
	}

	public List<CustomerDeleteBean> getCustomerDeleteList() {
		return this.customerDeleteList;
	}

	public void addCustomerDelete(CustomerDeleteBean subCustomerDeleteBean) {
		this.customerDeleteList.add(subCustomerDeleteBean);
	}

	@Override
	public String toString() {
		return "CustomerDeleteBean [id=" + this.id + ", cardNo=" + this.cardNo + ", cardStatus=" + this.cardStatus
				+ ", mainCardFlag=" + this.mainCardFlag + ", cardType=" + this.cardType + ", deposit=" + this.deposit
				+ ", cardRemark=" + this.cardRemark + ", guestName=" + this.guestName + ", companyName=" + this.companyName
				+ ", identityType=" + this.identityType + ", identityNum=" + this.identityNum + ", guestNo=" + this.guestNo
				+ ", guestStatus=" + this.guestStatus + ", guestRemark=" + this.guestRemark + ", cardAccount="
				+ this.cardAccount + ", preAccount=" + this.preAccount + ", cardScore=" + this.cardScore + ", spareAccount="
				+ this.spareAccount + ", inuseAccount=" + this.inuseAccount + ", guestScore=" + this.guestScore
				+ ", accountSum=" + this.accountSum + ", preSum=" + this.preSum + ", scoreSum=" + this.scoreSum
				+ ", pageNumber=" + this.pageNumber + ", pageSize=" + this.pageSize + ", totalData=" + this.totalData
				+ ", customerDeleteList=" + this.customerDeleteList + "]";
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
