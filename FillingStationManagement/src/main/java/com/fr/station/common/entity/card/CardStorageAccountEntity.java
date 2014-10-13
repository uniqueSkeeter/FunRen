package com.fr.station.common.entity.card;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.entity.base.BaseEntity;

@Entity
@Table(name = "FK_T_StorageTZ")
public class CardStorageAccountEntity extends BaseEntity {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	/**
	 * 日期
	 */
	@Column(name = "`workdate`")
	private Date workDate;

	@Column(name = "`cardtype`")
	private String cardType;

	/**
	 * 库存数量
	 */
	@Column(name = "`cardsum`")
	private int cardSum;

	/**
	 * 入库数量
	 */
	@Column(name = "`Insum`")
	private int inSum;

	/**
	 * 出库数量
	 */
	@Column(name = "`Outsum`")
	private int outSum;

	/**
	 * 调整数量
	 */
	@Column(name = "`chsum`")
	private int chSum;

	@Column(name = "`note`")
	private String note;

	/**
	 * 班结号
	 */
	@Column(name = "`ACCNO`")
	private String classNo;

	/**
	 * 结账日期
	 */
	@Column(name = "`ACCDATE`")
	private Date classDate;

	/**
	 * 网点编号
	 */
	@Column(name = "`STATIONNO`")
	private int stationNo;

	@Column(name = "`USERID`")
	private int userId;

	@Column(name = "`bz`")
	private int bz;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getWorkDate() {
		return this.workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public int getCardSum() {
		return this.cardSum;
	}

	public void setCardSum(int cardSum) {
		this.cardSum = cardSum;
	}

	public int getInSum() {
		return this.inSum;
	}

	public void setInSum(int inSum) {
		this.inSum = inSum;
	}

	public int getOutSum() {
		return this.outSum;
	}

	public void setOutSum(int outSum) {
		this.outSum = outSum;
	}

	public int getChSum() {
		return this.chSum;
	}

	public void setChSum(int chSum) {
		this.chSum = chSum;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getClassNo() {
		return this.classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public Date getClassDate() {
		return this.classDate;
	}

	public void setClassDate(Date classDate) {
		this.classDate = classDate;
	}

	public int getStationNo() {
		return this.stationNo;
	}

	public void setStationNo(int stationNo) {
		this.stationNo = stationNo;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBz() {
		return this.bz;
	}

	public void setBz(int bz) {
		this.bz = bz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + this.bz;
		result = prime * result + this.cardSum;
		result = prime * result + ((this.cardType == null) ? 0 : this.cardType.hashCode());
		result = prime * result + this.chSum;
		result = prime * result + ((this.classDate == null) ? 0 : this.classDate.hashCode());
		result = prime * result + ((this.classNo == null) ? 0 : this.classNo.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + this.inSum;
		result = prime * result + ((this.note == null) ? 0 : this.note.hashCode());
		result = prime * result + this.outSum;
		result = prime * result + this.stationNo;
		result = prime * result + this.userId;
		result = prime * result + ((this.workDate == null) ? 0 : this.workDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		CardStorageAccountEntity other = (CardStorageAccountEntity) obj;
		if (this.bz != other.bz) {
			return false;
		}
		if (this.cardSum != other.cardSum) {
			return false;
		}
		if (this.cardType == null) {
			if (other.cardType != null) {
				return false;
			}
		} else if (!this.cardType.equals(other.cardType)) {
			return false;
		}
		if (this.chSum != other.chSum) {
			return false;
		}
		if (this.classDate == null) {
			if (other.classDate != null) {
				return false;
			}
		} else if (!this.classDate.equals(other.classDate)) {
			return false;
		}
		if (this.classNo == null) {
			if (other.classNo != null) {
				return false;
			}
		} else if (!this.classNo.equals(other.classNo)) {
			return false;
		}
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		if (this.inSum != other.inSum) {
			return false;
		}
		if (this.note == null) {
			if (other.note != null) {
				return false;
			}
		} else if (!this.note.equals(other.note)) {
			return false;
		}
		if (this.outSum != other.outSum) {
			return false;
		}
		if (this.stationNo != other.stationNo) {
			return false;
		}
		if (this.userId != other.userId) {
			return false;
		}
		if (this.workDate == null) {
			if (other.workDate != null) {
				return false;
			}
		} else if (!this.workDate.equals(other.workDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CardStorageAccountEntity [id=" + this.id + ", workDate=" + this.workDate + ", cardType=" + this.cardType + ", cardSum="
				+ this.cardSum + ", inSum=" + this.inSum + ", outSum=" + this.outSum + ", chSum=" + this.chSum + ", note=" + this.note + ", classNo="
				+ this.classNo + ", classDate=" + this.classDate + ", stationNo=" + this.stationNo + ", userId=" + this.userId + ", bz=" + this.bz + "]";
	}

}
