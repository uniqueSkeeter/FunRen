/*
 * 对客户账户预分配给各个卡的备付账户明细表， Revised history Copyright(c) 2010 FR Co.,Ltd
 */

package com.fr.station.common.entity.card;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;

/**
 * 预分配明细表
 *
 * @version 1.0
 * @authorguyj
 */
@Entity
@Table(name = "FK_TT_CARDPRE")
public class PreAllocatedDetailEntity implements StandardBean {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 预分配ID
	 */
	@Id
	@Column(name = "`ID`")
	@GeneratedValue
	private Integer id;

	/**
	 * 主卡号
	 */
	@Column(name = "`CARDNO`")
	private String cardno;

	/**
	 * 客户ID
	 */
	@Column(name = "`GUESTNO`")
	private String guestno;

	/**
	 * 预分配金额
	 */
	@Column(name = "`PRE`")
	private BigDecimal pre;

	/**
	 * 单据号
	 */
	@Column(name = "`BILLSNO`")
	private String billsNo;

	/**
	 * 网点
	 */
	@Column(name = "`STATIONNO`")
	private String stationno;

	/**
	 * 网点
	 */
	@Column(name = "`BILLSTYPE`")
	private String billType;

	/**
	 * 班结号
	 */
	@Column(name = "`AccNo`")
	private String bjid;

	/**
	 * 日结号
	 */
	@Column(name = "`RJID`")
	private Integer rjid;

	/**
	 * 创建时间
	 */
	@Column(name = "`CREATE_DATE`")
	private Timestamp createDate;

	/**
	 * 操作员编号
	 */
	@Column(name = "`USERID`")
	private Integer userid;

	/**
	 * 预分配ID的取得
	 *
	 * @return Integer 预分配ID
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * 主卡号的取得
	 *
	 * @return String 主卡号
	 */
	public String getCardno() {
		return this.cardno;
	}

	/**
	 * 客户ID的取得
	 *
	 * @return String 客户ID
	 */
	public String getGuestno() {
		return this.guestno;
	}

	/**
	 * 预分配金额的取得
	 *
	 * @return BigDecimal 预分配金额
	 */
	public BigDecimal getPre() {
		return this.pre;
	}

	/**
	 * 单据号的取得
	 *
	 * @return String 单据号
	 */
	public String getBillsNo() {
		return this.billsNo;
	}

	/**
	 * 网点的取得
	 *
	 * @return String 网点
	 */
	public String getStationno() {
		return this.stationno;
	}

	/**
	 * 班结号的取得
	 *
	 * @return Integer 班结号
	 */
	public String getBjid() {
		return this.bjid;
	}

	/**
	 * 日结号的取得
	 *
	 * @return Integer 日结号
	 */
	public Integer getRjid() {
		return this.rjid;
	}

	/**
	 * 创建时间的取得
	 *
	 * @return Timestamp 创建时间
	 */
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	/**
	 * 操作员编号的取得
	 *
	 * @return Integer 操作员编号
	 */
	public Integer getUserid() {
		return this.userid;
	}

	/**
	 * 预分配ID的设定
	 *
	 * @param newInteger 预分配ID
	 */
	public void setId(Integer newId) {
		this.id = newId;
	}

	/**
	 * 主卡号的设定
	 *
	 * @param newString 主卡号
	 */
	public void setCardno(String newCardno) {
		this.cardno = newCardno;
	}

	/**
	 * 客户ID的设定
	 *
	 * @param newString 客户ID
	 */
	public void setGuestno(String newGuestno) {
		this.guestno = newGuestno;
	}

	/**
	 * 预分配金额的设定
	 *
	 * @param newBigDecimal 预分配金额
	 */
	public void setPre(BigDecimal newPre) {
		this.pre = newPre;
	}

	public String getBillType() {
		return this.billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	/**
	 * 单据号的设定
	 *
	 * @param newString 单据号
	 */
	public void setBillsNo(String newBillsNo) {
		this.billsNo = newBillsNo;
	}

	/**
	 * 网点的设定
	 *
	 * @param newString 网点
	 */
	public void setStationno(String newStationno) {
		this.stationno = newStationno;
	}

	/**
	 * 班结号的设定
	 *
	 * @param newInteger 班结号
	 */
	public void setBjid(String newBjid) {
		this.bjid = newBjid;
	}

	/**
	 * 日结号的设定
	 *
	 * @param newInteger 日结号
	 */
	public void setRjid(Integer newRjid) {
		this.rjid = newRjid;
	}

	/**
	 * 创建时间的设定
	 *
	 * @param newTimestamp 创建时间
	 */
	public void setCreateDate(Timestamp newCreateDate) {
		this.createDate = newCreateDate;
	}

	/**
	 * 操作员编号的设定
	 *
	 * @param newInteger 操作员编号
	 */
	public void setUserid(Integer newUserid) {
		this.userid = newUserid;
	}
}
