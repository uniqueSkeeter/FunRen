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
@Table(name = "FK_T_Maintain")
public class FKTMaintain implements StandardBean {

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

	@Column(name = "`cardno`")
	private String cardNo;

	@Column(name = "`note`")
	private String note;

	@Column(name = "`note2`")
	private String note2;

	@Column(name = "`stationno`")
	private String stationNo;

	@Column(name = "`BZ`")
	private String BZ;

	@Column(name = "`workdate`")
	private Date createDate;

	@Column(name = "`userid`")
	private int operateId;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote2() {
		return this.note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}

	public String getStationNo() {
		return this.stationNo;
	}

	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}

	public String getBZ() {
		return this.BZ;
	}

	public void setBZ(String bZ) {
		this.BZ = bZ;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getOperateId() {
		return this.operateId;
	}

	public void setOperateId(int operateId) {
		this.operateId = operateId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.BZ == null) ? 0 : this.BZ.hashCode());
		result = prime * result + ((this.cardNo == null) ? 0 : this.cardNo.hashCode());
		result = prime * result + ((this.createDate == null) ? 0 : this.createDate.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.note == null) ? 0 : this.note.hashCode());
		result = prime * result + ((this.note2 == null) ? 0 : this.note2.hashCode());
		result = prime * result + this.operateId;
		result = prime * result + ((this.stationNo == null) ? 0 : this.stationNo.hashCode());
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
		FKTMaintain other = (FKTMaintain) obj;
		if (this.BZ == null) {
			if (other.BZ != null) {
				return false;
			}
		} else if (!this.BZ.equals(other.BZ)) {
			return false;
		}
		if (this.cardNo == null) {
			if (other.cardNo != null) {
				return false;
			}
		} else if (!this.cardNo.equals(other.cardNo)) {
			return false;
		}
		if (this.createDate == null) {
			if (other.createDate != null) {
				return false;
			}
		} else if (!this.createDate.equals(other.createDate)) {
			return false;
		}
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		if (this.note == null) {
			if (other.note != null) {
				return false;
			}
		} else if (!this.note.equals(other.note)) {
			return false;
		}
		if (this.note2 == null) {
			if (other.note2 != null) {
				return false;
			}
		} else if (!this.note2.equals(other.note2)) {
			return false;
		}
		if (this.operateId != other.operateId) {
			return false;
		}
		if (this.stationNo == null) {
			if (other.stationNo != null) {
				return false;
			}
		} else if (!this.stationNo.equals(other.stationNo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "FKTMaintain [id=" + this.id + ", cardNo=" + this.cardNo + ", note=" + this.note + ", note2=" + this.note2
				+ ", stationNo=" + this.stationNo + ", BZ=" + this.BZ + ", createDate=" + this.createDate + ", operateId="
				+ this.operateId + "]";
	}

}
