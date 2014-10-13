/*
 * 油枪付油记录信息表
 * Revised history
 * Copyright(c) 2010 FR Co.,Ltd
 */
package com.fr.station.common.entity.report;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;

/**
 * 油枪付油记录信息表
 * 
 * @version 1.0 _wsq
 */
@Entity
@Table(name = "OPERATELOG")
public class OilGunConsumeEntity implements StandardBean {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "GUNPORT")
	private Integer oilGunNum;

	/**
	 * 日结时间
	 */
	@Column(name = "RJRQ")
	private String dayTime;

	/**
	 * 网点号
	 */
	@Column(name = "StationNO")
	private String StationNun;

	/**
	 * 班结号
	 */
	@Column(name = "AccNo")
	private String shiftNum;

	/**
	 * 结班时间
	 */
	@Column(name = "AccDate")
	private Timestamp shiftDate;

	/**
	 * 上班时间
	 */
	@Column(name = "JBRQ")
	private Timestamp workTime;

	/**
	 * 油罐号
	 */
	@Column(name = "TankNo")
	private String tinNum;

	/**
	 * 油品代码
	 */
	@Column(name = "OilCode")
	private String oilCode;

	@Column(name = "OilName")
	private String oilName;

	@Column(name = "OilPrice")
	private BigDecimal oilPrice;

	/**
	 * 油品单位
	 */
	@Column(name = "OilDw")
	private Timestamp oilDw;

	/**
	 * 规格
	 */
	@Column(name = "GG")
	private String gg;

	/**
	 * 初始油量
	 */
	@Column(name = "CSSL")
	private BigDecimal initQuantity;

	@Column(name = "CSJE")
	private BigDecimal initMoney;

	/**
	 * 当前付油油量
	 */
	@Column(name = "CKSL")
	private BigDecimal initOilAccount;

	@Column(name = "CKJE")
	private BigDecimal initOilMoney;

	/**
	 * 现金金额
	 */
	@Column(name = "AMN2")
	private BigDecimal cashMoney;

	@Column(name = "VOL2")
	private BigDecimal cashAmount;

	/**
	 * 调整
	 */
	@Column(name = "TZSL")
	private BigDecimal adjustAmount;

	@Column(name = "TZJE")
	private BigDecimal adjustMoney;

	/**
	 * 银行卡
	 */
	@Column(name = "BLSL")
	private BigDecimal bankConsum;

	@Column(name = "BLJE")
	private BigDecimal bankMoney;

	/**
	 * IC 卡
	 */
	@Column(name = "IC_SL")
	private BigDecimal icCard;

	@Column(name = "IC_JE")
	private BigDecimal icConsum;

	/**
	 * 回灌
	 */
	@Column(name = "TANK_SL")
	private BigDecimal tinBack;

	@Column(name = "TANK_JE")
	private BigDecimal tinBackMoney;

	/**
	 * 结存
	 */
	@Column(name = "JCSL")
	private BigDecimal balanceAmount;

	@Column(name = "JCJE")
	private BigDecimal balanceMoney;

	/**
	 * 班组号
	 */
	@Column(name = "EMP")
	private String classNum;

	/**
	 * 审核
	 */
	@Column(name = "SHH")
	private String shh;

	/**
	 * 最后一次加油时间
	 */
	@Column(name = "gzrq")
	private Timestamp lastTradeTime;

	/**
	 * 操作员姓名
	 */
	@Column(name = "CZYXM")
	private String operName;

	@Column(name = "BZ")
	private String bz;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDayTime() {
		return dayTime;
	}

	public void setDayTime(String dayTime) {
		this.dayTime = dayTime;
	}

	public String getStationNun() {
		return StationNun;
	}

	public void setStationNun(String stationNun) {
		StationNun = stationNun;
	}

	public String getShiftNum() {
		return shiftNum;
	}

	public void setShiftNum(String shiftNum) {
		this.shiftNum = shiftNum;
	}

	public Timestamp getShiftDate() {
		return shiftDate;
	}

	public void setShiftDate(Timestamp shiftDate) {
		this.shiftDate = shiftDate;
	}

	public Timestamp getWorkTime() {
		return workTime;
	}

	public void setWorkTime(Timestamp workTime) {
		this.workTime = workTime;
	}

	public String getTinNum() {
		return tinNum;
	}

	public void setTinNum(String tinNum) {
		this.tinNum = tinNum;
	}

	public String getOilCode() {
		return oilCode;
	}

	public void setOilCode(String oilCode) {
		this.oilCode = oilCode;
	}

	public String getOilName() {
		return oilName;
	}

	public void setOilName(String oilName) {
		this.oilName = oilName;
	}

	public BigDecimal getOilPrice() {
		return oilPrice;
	}

	public void setOilPrice(BigDecimal oilPrice) {
		this.oilPrice = oilPrice;
	}

	public Timestamp getOilDw() {
		return oilDw;
	}

	public void setOilDw(Timestamp oilDw) {
		this.oilDw = oilDw;
	}

	public String getGg() {
		return gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public BigDecimal getInitQuantity() {
		return initQuantity;
	}

	public void setInitQuantity(BigDecimal initQuantity) {
		this.initQuantity = initQuantity;
	}

	public BigDecimal getInitMoney() {
		return initMoney;
	}

	public void setInitMoney(BigDecimal initMoney) {
		this.initMoney = initMoney;
	}

	public BigDecimal getInitOilAccount() {
		return initOilAccount;
	}

	public void setInitOilAccount(BigDecimal initOilAccount) {
		this.initOilAccount = initOilAccount;
	}

	public BigDecimal getInitOilMoney() {
		return initOilMoney;
	}

	public void setInitOilMoney(BigDecimal initOilMoney) {
		this.initOilMoney = initOilMoney;
	}

	public BigDecimal getCashMoney() {
		return cashMoney;
	}

	public void setCashMoney(BigDecimal cashMoney) {
		this.cashMoney = cashMoney;
	}

	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public BigDecimal getAdjustAmount() {
		return adjustAmount;
	}

	public void setAdjustAmount(BigDecimal adjustAmount) {
		this.adjustAmount = adjustAmount;
	}

	public BigDecimal getAdjustMoney() {
		return adjustMoney;
	}

	public void setAdjustMoney(BigDecimal adjustMoney) {
		this.adjustMoney = adjustMoney;
	}

	public BigDecimal getBankConsum() {
		return bankConsum;
	}

	public void setBankConsum(BigDecimal bankConsum) {
		this.bankConsum = bankConsum;
	}

	public BigDecimal getBankMoney() {
		return bankMoney;
	}

	public void setBankMoney(BigDecimal bankMoney) {
		this.bankMoney = bankMoney;
	}

	public BigDecimal getIcCard() {
		return icCard;
	}

	public void setIcCard(BigDecimal icCard) {
		this.icCard = icCard;
	}

	public BigDecimal getIcConsum() {
		return icConsum;
	}

	public void setIcConsum(BigDecimal icConsum) {
		this.icConsum = icConsum;
	}

	public BigDecimal getTinBack() {
		return tinBack;
	}

	public void setTinBack(BigDecimal tinBack) {
		this.tinBack = tinBack;
	}

	public BigDecimal getTinBackMoney() {
		return tinBackMoney;
	}

	public void setTinBackMoney(BigDecimal tinBackMoney) {
		this.tinBackMoney = tinBackMoney;
	}

	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public BigDecimal getBalanceMoney() {
		return balanceMoney;
	}

	public void setBalanceMoney(BigDecimal balanceMoney) {
		this.balanceMoney = balanceMoney;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getShh() {
		return shh;
	}

	public void setShh(String shh) {
		this.shh = shh;
	}

	public Timestamp getLastTradeTime() {
		return lastTradeTime;
	}

	public void setLastTradeTime(Timestamp lastTradeTime) {
		this.lastTradeTime = lastTradeTime;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Integer getOilGunNum() {
		return oilGunNum;
	}

	public void setOilGunNum(Integer oilGunNum) {
		this.oilGunNum = oilGunNum;
	}

	@Override
	public String toString() {
		return "OilGunConsumeEntity [id=" + id + ", dayTime=" + dayTime
				+ ", StationNun=" + StationNun + ", shiftNum=" + shiftNum
				+ ", shiftDate=" + shiftDate + ", workTime=" + workTime
				+ ", tinNum=" + tinNum + ", oilCode=" + oilCode + ", oilName="
				+ oilName + ", oilPrice=" + oilPrice + ", oilDw=" + oilDw
				+ ", gg=" + gg + ", initQuantity=" + initQuantity
				+ ", initMoney=" + initMoney + ", initOilAccount="
				+ initOilAccount + ", initOilMoney=" + initOilMoney
				+ ", cashMoney=" + cashMoney + ", cashAmount=" + cashAmount
				+ ", adjustAmount=" + adjustAmount + ", adjustMoney="
				+ adjustMoney + ", bankConsum=" + bankConsum + ", bankMoney="
				+ bankMoney + ", icCard=" + icCard + ", icConsum=" + icConsum
				+ ", tinBack=" + tinBack + ", tinBackMoney=" + tinBackMoney
				+ ", balanceAmount=" + balanceAmount + ", balanceMoney="
				+ balanceMoney + ", classNum=" + classNum + ", shh=" + shh
				+ ", lastTradeTime=" + lastTradeTime + ", operName=" + operName
				+ ", bz=" + bz + "]";
	}

}
