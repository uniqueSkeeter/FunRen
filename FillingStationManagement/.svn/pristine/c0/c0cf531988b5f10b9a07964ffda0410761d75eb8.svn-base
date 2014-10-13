/*
 * 调价文件信息 Revised history Copyright(c) 2010 FR Co.,Ltd
 */

package com.fr.station.common.entity.card;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;

@Entity
@Table(name = "FK_T_GUESTDEP")
public class FKTGuestDep implements StandardBean {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Id
	@Column(name = "`ID`")
	@GeneratedValue
	private Integer id;

	// @ManyToOne
	// @JoinColumn(name = "guestId")
	// private FkTGuestEntity guestEntity;

	@Column(name = "`guestNo`")
	private String guestNo;

	@Column(name = "`DEPNO`")
	private String deptNo;

	@Column(name = "`depName`")
	private String deptName;

	@Column(name = "`depmaster`")
	private String contactName;

	@Column(name = "`deptel`")
	private String contactPhone;

	@Column(name = "`create_date`")
	private Date createDate;

	@Column(name = "`update_date`")
	private Date updateDate;

	@Column(name = "`limitStation`")
	private String stationLimit;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getGuestNo() {
		return this.guestNo;
	}

	public void setGuestNo(String guestNo) {
		this.guestNo = guestNo;
	}

	public String getStationLimit() {
		return this.stationLimit;
	}

	public void setStationLimit(String stationLimit) {
		this.stationLimit = stationLimit;
	}

	@Override
	public String toString() {
		return "FKTGuestDep [id=" + this.id + ", guestNo=" + this.guestNo + ", deptNo=" + this.deptNo + ", deptName="
				+ this.deptName + ", contactName=" + this.contactName + ", contactPhone=" + this.contactPhone + ", createDate="
				+ this.createDate + ", updateDate=" + this.updateDate + ", stationLimit=" + this.stationLimit + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.contactName == null) ? 0 : this.contactName.hashCode());
		result = prime * result + ((this.contactPhone == null) ? 0 : this.contactPhone.hashCode());
		result = prime * result + ((this.createDate == null) ? 0 : this.createDate.hashCode());
		result = prime * result + ((this.deptName == null) ? 0 : this.deptName.hashCode());
		result = prime * result + ((this.deptNo == null) ? 0 : this.deptNo.hashCode());
		result = prime * result + ((this.guestNo == null) ? 0 : this.guestNo.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.stationLimit == null) ? 0 : this.stationLimit.hashCode());
		result = prime * result + ((this.updateDate == null) ? 0 : this.updateDate.hashCode());
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
		FKTGuestDep other = (FKTGuestDep) obj;
		if (this.contactName == null) {
			if (other.contactName != null) {
				return false;
			}
		} else if (!this.contactName.equals(other.contactName)) {
			return false;
		}
		if (this.contactPhone == null) {
			if (other.contactPhone != null) {
				return false;
			}
		} else if (!this.contactPhone.equals(other.contactPhone)) {
			return false;
		}
		if (this.createDate == null) {
			if (other.createDate != null) {
				return false;
			}
		} else if (!this.createDate.equals(other.createDate)) {
			return false;
		}
		if (this.deptName == null) {
			if (other.deptName != null) {
				return false;
			}
		} else if (!this.deptName.equals(other.deptName)) {
			return false;
		}
		if (this.deptNo == null) {
			if (other.deptNo != null) {
				return false;
			}
		} else if (!this.deptNo.equals(other.deptNo)) {
			return false;
		}
		if (this.guestNo == null) {
			if (other.guestNo != null) {
				return false;
			}
		} else if (!this.guestNo.equals(other.guestNo)) {
			return false;
		}
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		if (this.stationLimit == null) {
			if (other.stationLimit != null) {
				return false;
			}
		} else if (!this.stationLimit.equals(other.stationLimit)) {
			return false;
		}
		if (this.updateDate == null) {
			if (other.updateDate != null) {
				return false;
			}
		} else if (!this.updateDate.equals(other.updateDate)) {
			return false;
		}
		return true;
	}

}
