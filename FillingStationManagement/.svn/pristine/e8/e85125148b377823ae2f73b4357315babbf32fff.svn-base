/*
 * 交费明细 <--> 单位充值 Revised history Copyright(c) 2010 FR Co.,Ltd
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
 * 交费明细
 * 
 * @version 1.0
 * @authorguyj
 */
/**
 * TODO - High level description about type's responsibility.
 * 
 * @trace TODO
 * @author WJF
 */
@Entity
@Table(name = "FK_TT_GUESTCREDIT")
public class FkTtGuestcreditEntity implements StandardBean {

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
	 * 单位名称
	 */
	@Column(name = "`GUESTNAME`")
	private String guestname;

	/**
	 * 单位编号
	 */
	@Column(name = "`GUESTNO`")
	private String guestno;

	/**
	 * 交易序号
	 */
	@Column(name = "`INCNO`")
	private String incno;

	/**
	 * 交易前金额
	 */
	@Column(name = "`PRE`")
	private BigDecimal pre;

	/**
	 * 交易后金额
	 */
	@Column(name = "`BAL`")
	private BigDecimal bal;

	/**
	 * 金额
	 */
	@Column(name = "`AMN`")
	private BigDecimal amn;

	/**
	 * 交易类型
	 */
	@Column(name = "`inctype`")
	private String jylx;

	/**
	 * 支付类型
	 */
	@Column(name = "`ZFFS`")
	private String zffs;

	/**
	 * 发票号
	 */
	@Column(name = "`TAX`")
	private String tax;

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
	 * 备用
	 */
	@Column(name = "`BZ`")
	private String bz;

	/**
	 * 网点号
	 */
	@Column(name = "`STATIONNO`")
	private String stationno;

	/**
	 * 创建时间 （日期）
	 */
	@Column(name = "`CREATE_DATE`")
	private Timestamp createDate;

	/**
	 * 班结日期
	 */
	@Column(name = "`accDate`")
	private Timestamp accDate;

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
	 * 单位名称的取得
	 * 
	 * @return String 单位名称
	 */
	public String getGuestname() {
		return this.guestname;
	}

	/**
	 * 单位编号的取得
	 * 
	 * @return String 单位编号
	 */
	public String getGuestno() {
		return this.guestno;
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
	 * 交易前金额的取得
	 * 
	 * @return BigDecimal 交易前金额
	 */
	public BigDecimal getPre() {
		return this.pre;
	}

	/**
	 * 交易后金额的取得
	 * 
	 * @return BigDecimal 交易后金额
	 */
	public BigDecimal getBal() {
		return this.bal;
	}

	/**
	 * 金额的取得
	 * 
	 * @return BigDecimal 金额
	 */
	public BigDecimal getAmn() {
		return this.amn;
	}

	/**
	 * 交易类型 的取得
	 * 
	 * @return String 交易类型
	 */
	public String getJylx() {
		return this.jylx;
	}

	/**
	 * 支付类型的取得
	 * 
	 * @return String 支付类型
	 */
	public String getZffs() {
		return this.zffs;
	}

	/**
	 * 发票号的取得
	 * 
	 * @return String 发票号
	 */
	public String getTax() {
		return this.tax;
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
	 * 备用的取得
	 * 
	 * @return String 备用
	 */
	public String getBz() {
		return this.bz;
	}

	/**
	 * 网点号的取得
	 * 
	 * @return String 网点号
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
	 * 单位名称的设定
	 * 
	 * @param newString 单位名称
	 */
	public void setGuestname(String newGuestname) {
		this.guestname = newGuestname;
	}

	/**
	 * 单位编号的设定
	 * 
	 * @param newString 单位编号
	 */
	public void setGuestno(String newGuestno) {
		this.guestno = newGuestno;
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
	 * 交易前金额的设定
	 * 
	 * @param newBigDecimal 交易前金额
	 */
	public void setPre(BigDecimal newPre) {
		this.pre = newPre;
	}

	/**
	 * 交易后金额的设定
	 * 
	 * @param newBigDecimal 交易后金额
	 */
	public void setBal(BigDecimal newBal) {
		this.bal = newBal;
	}

	/**
	 * 金额的设定
	 * 
	 * @param newBigDecimal 金额
	 */
	public void setAmn(BigDecimal newAmn) {
		this.amn = newAmn;
	}

	/**
	 * 交易类型 的设定
	 * 
	 * @param newString 交易类型
	 */
	public void setJylx(String newJylx) {
		this.jylx = newJylx;
	}

	/**
	 * 支付类型的设定
	 * 
	 * @param newString 支付类型
	 */
	public void setZffs(String newZffs) {
		this.zffs = newZffs;
	}

	/**
	 * 发票号的设定
	 * 
	 * @param newString 发票号
	 */
	public void setTax(String newTax) {
		this.tax = newTax;
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
	 * 备用的设定
	 * 
	 * @param newString 备用
	 */
	public void setBz(String newBz) {
		this.bz = newBz;
	}

	/**
	 * 网点号的设定
	 * 
	 * @param newString 网点号
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

	public Timestamp getAccDate() {
		return this.accDate;
	}

	public void setAccDate(Timestamp accDate) {
		this.accDate = accDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.accDate == null) ? 0 : this.accDate.hashCode());
		result = prime * result + ((this.amn == null) ? 0 : this.amn.hashCode());
		result = prime * result + ((this.bal == null) ? 0 : this.bal.hashCode());
		result = prime * result + ((this.bjid == null) ? 0 : this.bjid.hashCode());
		result = prime * result + ((this.bz == null) ? 0 : this.bz.hashCode());
		result = prime * result + ((this.createDate == null) ? 0 : this.createDate.hashCode());
		result = prime * result + ((this.guestname == null) ? 0 : this.guestname.hashCode());
		result = prime * result + ((this.guestno == null) ? 0 : this.guestno.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.incno == null) ? 0 : this.incno.hashCode());
		result = prime * result + ((this.jylx == null) ? 0 : this.jylx.hashCode());
		result = prime * result + ((this.pre == null) ? 0 : this.pre.hashCode());
		result = prime * result + ((this.rjid == null) ? 0 : this.rjid.hashCode());
		result = prime * result + ((this.stationno == null) ? 0 : this.stationno.hashCode());
		result = prime * result + ((this.tax == null) ? 0 : this.tax.hashCode());
		result = prime * result + ((this.userid == null) ? 0 : this.userid.hashCode());
		result = prime * result + ((this.zffs == null) ? 0 : this.zffs.hashCode());
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
		FkTtGuestcreditEntity other = (FkTtGuestcreditEntity) obj;
		if (this.accDate == null) {
			if (other.accDate != null) {
				return false;
			}
		} else if (!this.accDate.equals(other.accDate)) {
			return false;
		}
		if (this.amn == null) {
			if (other.amn != null) {
				return false;
			}
		} else if (!this.amn.equals(other.amn)) {
			return false;
		}
		if (this.bal == null) {
			if (other.bal != null) {
				return false;
			}
		} else if (!this.bal.equals(other.bal)) {
			return false;
		}
		if (this.bjid == null) {
			if (other.bjid != null) {
				return false;
			}
		} else if (!this.bjid.equals(other.bjid)) {
			return false;
		}
		if (this.bz == null) {
			if (other.bz != null) {
				return false;
			}
		} else if (!this.bz.equals(other.bz)) {
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
		if (this.guestno == null) {
			if (other.guestno != null) {
				return false;
			}
		} else if (!this.guestno.equals(other.guestno)) {
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
		if (this.jylx == null) {
			if (other.jylx != null) {
				return false;
			}
		} else if (!this.jylx.equals(other.jylx)) {
			return false;
		}
		if (this.pre == null) {
			if (other.pre != null) {
				return false;
			}
		} else if (!this.pre.equals(other.pre)) {
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
		if (this.tax == null) {
			if (other.tax != null) {
				return false;
			}
		} else if (!this.tax.equals(other.tax)) {
			return false;
		}
		if (this.userid == null) {
			if (other.userid != null) {
				return false;
			}
		} else if (!this.userid.equals(other.userid)) {
			return false;
		}
		if (this.zffs == null) {
			if (other.zffs != null) {
				return false;
			}
		} else if (!this.zffs.equals(other.zffs)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "FkTtGuestcreditEntity [id=" + this.id + ", guestname=" + this.guestname + ", guestno=" + this.guestno
				+ ", incno=" + this.incno + ", pre=" + this.pre + ", bal=" + this.bal + ", amn=" + this.amn + ", jylx="
				+ this.jylx + ", zffs=" + this.zffs + ", tax=" + this.tax + ", bjid=" + this.bjid + ", rjid=" + this.rjid
				+ ", bz=" + this.bz + ", stationno=" + this.stationno + ", createDate=" + this.createDate + ", accDate="
				+ this.accDate + ", userid=" + this.userid + "]";
	}

}
