/*
 * 交易信息 <--> 卡充值信息 Revised history Copyright(c) 2010 FR Co.,Ltd
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
 * 卡充值信息
 *
 * @version 1.0
 * @authorguyj
 */
@Entity
@Table(name = "FK_T_CREDIT")
public class FkTCreditEntity implements StandardBean {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@Column(name = "`ID`")
	@GeneratedValue
	private Integer id;

	/**
	 * 持卡人
	 */
	@Column(name = "`GUESTNAME`")
	private String guestname;

	/**
	 * 交易序号
	 */
	@Column(name = "`INCNO`")
	private String incno;

	/**
	 * 卡号
	 */
	@Column(name = "`CARDNO`")
	private String cardno;

	/**
	 * 交易金额
	 */
	@Column(name = "`CARDINC`")
	private BigDecimal cardinc;

	/**
	 * 交易前金额
	 */
	@Column(name = "`CARDBEG`")
	private BigDecimal cardbeg;

	/**
	 * 交易后余额
	 */
	@Column(name = "`CARDBAL`")
	private BigDecimal cardbal;

	/**
	 * 交易类型
	 */
	@Column(name = "`INCTYPE`")
	private String inctype;

	/**
	 * 班结号
	 */
	@Column(name = "`accNo`")
	private String accNo;

	/**
	 * 日结号
	 */
	@Column(name = "`RJID`")
	private Integer rjid;

	/**
	 * 支付类型
	 */
	@Column(name = "`RECTYPE`")
	private String rectype;

	/**
	 * 备用
	 */
	@Column(name = "`BZ`")
	private String bz;

	/**
	 * 网点
	 */
	@Column(name = "`STATIONNO`")
	private String stationno;

	/**
	 * 转账类型 0 - 现金 1 - 积分
	 */
	@Column(name = "`transferType`")
	private String transferType;

	/**
	 * 创建时间 （日期）
	 */
	@Column(name = "`CREATE_DATE`")
	private Timestamp createDate;

	/**
	 * 操作员编号
	 */
	@Column(name = "`USERID`")
	private Integer userid;

	/**
	 * ID的取得
	 *
	 * @return Integer ID
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * 持卡人的取得
	 *
	 * @return String 持卡人
	 */
	public String getGuestname() {
		return this.guestname;
	}

	/**
	 * 交易序号的取得
	 *
	 * @return String 交易序号
	 */
	public String getIncno() {
		return this.incno;
	}

	/**
	 * 卡号的取得
	 *
	 * @return String 卡号
	 */
	public String getCardno() {
		return this.cardno;
	}

	/**
	 * 交易金额的取得
	 *
	 * @return BigDecimal 交易金额
	 */
	public BigDecimal getCardinc() {
		return this.cardinc;
	}

	/**
	 * 交易前金额的取得
	 *
	 * @return BigDecimal 交易前金额
	 */
	public BigDecimal getCardbeg() {
		return this.cardbeg;
	}

	/**
	 * 交易后余额的取得
	 *
	 * @return BigDecimal 交易后余额
	 */
	public BigDecimal getCardbal() {
		return this.cardbal;
	}

	/**
	 * 交易类型 的取得
	 *
	 * @return String 交易类型
	 */
	public String getInctype() {
		return this.inctype;
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
	 * 支付类型的取得
	 *
	 * @return String 支付类型
	 */
	public String getRectype() {
		return this.rectype;
	}

	/**
	 * 备用的取得
	 *
	 * @return String 备用
	 */
	public String getBz() {
		return this.bz;
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
	 * 创建时间 （日期）的取得
	 *
	 * @return Timestamp 创建时间 （日期）
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
	 * ID的设定
	 *
	 * @param newInteger ID
	 */
	public void setId(Integer newId) {
		this.id = newId;
	}

	/**
	 * 持卡人的设定
	 *
	 * @param newString 持卡人
	 */
	public void setGuestname(String newGuestname) {
		this.guestname = newGuestname;
	}

	/**
	 * 交易序号的设定
	 *
	 * @param newString 交易序号
	 */
	public void setIncno(String newIncno) {
		this.incno = newIncno;
	}

	/**
	 * 卡号的设定
	 *
	 * @param newString 卡号
	 */
	public void setCardno(String newCardno) {
		this.cardno = newCardno;
	}

	/**
	 * 交易金额的设定
	 *
	 * @param newBigDecimal 交易金额
	 */
	public void setCardinc(BigDecimal newCardinc) {
		this.cardinc = newCardinc;
	}

	/**
	 * 交易前金额的设定
	 *
	 * @param newBigDecimal 交易前金额
	 */
	public void setCardbeg(BigDecimal newCardbeg) {
		this.cardbeg = newCardbeg;
	}

	/**
	 * 交易后余额的设定
	 *
	 * @param newBigDecimal 交易后余额
	 */
	public void setCardbal(BigDecimal newCardbal) {
		this.cardbal = newCardbal;
	}

	/**
	 * 交易类型 的设定
	 *
	 * @param newString 交易类型
	 */
	public void setInctype(String newInctype) {
		this.inctype = newInctype;
	}

	public String getAccNo() {
		return this.accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
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
	 * 支付类型的设定
	 *
	 * @param newString 支付类型
	 */
	public void setRectype(String newRectype) {
		this.rectype = newRectype;
	}

	/**
	 * 备用的设定
	 *
	 * @param newString 备用
	 */
	public void setBz(String newBz) {
		this.bz = newBz;
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
	 * 创建时间 （日期）的设定
	 *
	 * @param newTimestamp 创建时间 （日期）
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

	public String getTransferType() {
		return this.transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.accNo == null) ? 0 : this.accNo.hashCode());
		result = prime * result + ((this.bz == null) ? 0 : this.bz.hashCode());
		result = prime * result + ((this.cardbal == null) ? 0 : this.cardbal.hashCode());
		result = prime * result + ((this.cardbeg == null) ? 0 : this.cardbeg.hashCode());
		result = prime * result + ((this.cardinc == null) ? 0 : this.cardinc.hashCode());
		result = prime * result + ((this.cardno == null) ? 0 : this.cardno.hashCode());
		result = prime * result + ((this.createDate == null) ? 0 : this.createDate.hashCode());
		result = prime * result + ((this.guestname == null) ? 0 : this.guestname.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.incno == null) ? 0 : this.incno.hashCode());
		result = prime * result + ((this.inctype == null) ? 0 : this.inctype.hashCode());
		result = prime * result + ((this.rectype == null) ? 0 : this.rectype.hashCode());
		result = prime * result + ((this.rjid == null) ? 0 : this.rjid.hashCode());
		result = prime * result + ((this.stationno == null) ? 0 : this.stationno.hashCode());
		result = prime * result + ((this.transferType == null) ? 0 : this.transferType.hashCode());
		result = prime * result + ((this.userid == null) ? 0 : this.userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		FkTCreditEntity other = (FkTCreditEntity) obj;
		if (this.accNo == null) {
			if (other.accNo != null) {
				return false;
			}
		} else if (!this.accNo.equals(other.accNo)) {
			return false;
		}
		if (this.bz == null) {
			if (other.bz != null) {
				return false;
			}
		} else if (!this.bz.equals(other.bz)) {
			return false;
		}
		if (this.cardbal == null) {
			if (other.cardbal != null) {
				return false;
			}
		} else if (!this.cardbal.equals(other.cardbal)) {
			return false;
		}
		if (this.cardbeg == null) {
			if (other.cardbeg != null) {
				return false;
			}
		} else if (!this.cardbeg.equals(other.cardbeg)) {
			return false;
		}
		if (this.cardinc == null) {
			if (other.cardinc != null) {
				return false;
			}
		} else if (!this.cardinc.equals(other.cardinc)) {
			return false;
		}
		if (this.cardno == null) {
			if (other.cardno != null) {
				return false;
			}
		} else if (!this.cardno.equals(other.cardno)) {
			return false;
		}
		if (this.createDate == null) {
			if (other.createDate != null) {
				return false;
			}
		} else if (!this.createDate.equals(other.createDate)) {
			return false;
		}
		if (this.guestname == null) {
			if (other.guestname != null) {
				return false;
			}
		} else if (!this.guestname.equals(other.guestname)) {
			return false;
		}
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		if (this.incno == null) {
			if (other.incno != null) {
				return false;
			}
		} else if (!this.incno.equals(other.incno)) {
			return false;
		}
		if (this.inctype == null) {
			if (other.inctype != null) {
				return false;
			}
		} else if (!this.inctype.equals(other.inctype)) {
			return false;
		}
		if (this.rectype == null) {
			if (other.rectype != null) {
				return false;
			}
		} else if (!this.rectype.equals(other.rectype)) {
			return false;
		}
		if (this.rjid == null) {
			if (other.rjid != null) {
				return false;
			}
		} else if (!this.rjid.equals(other.rjid)) {
			return false;
		}
		if (this.stationno == null) {
			if (other.stationno != null) {
				return false;
			}
		} else if (!this.stationno.equals(other.stationno)) {
			return false;
		}
		if (this.transferType == null) {
			if (other.transferType != null) {
				return false;
			}
		} else if (!this.transferType.equals(other.transferType)) {
			return false;
		}
		if (this.userid == null) {
			if (other.userid != null) {
				return false;
			}
		} else if (!this.userid.equals(other.userid)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "FkTCreditEntity [id=" + this.id + ", guestname=" + this.guestname + ", incno=" + this.incno + ", cardno=" + this.cardno
				+ ", cardinc=" + this.cardinc + ", cardbeg=" + this.cardbeg + ", cardbal=" + this.cardbal + ", inctype=" + this.inctype
				+ ", accNo=" + this.accNo + ", rjid=" + this.rjid + ", rectype=" + this.rectype + ", bz=" + this.bz + ", stationno=" + this.stationno
				+ ", transferType=" + this.transferType + ", createDate=" + this.createDate + ", userid=" + this.userid + "]";
	}

}
