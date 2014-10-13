package com.fr.station.common.entity.card;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fr.station.common.entity.base.BaseEntity;

@Entity
@Table(name = "FK_T_INOUTNOTE")
public class CardStorageDetailEntity extends BaseEntity {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inoutId")
	private FkTCardInOutEntity cardInOutEntity;

	/**
	 * 起始号
	 */
	@Column(name = "`No1`")
	private String startNo;

	/**
	 * 结束号
	 */
	@Column(name = "`No2`")
	private String endNo;

	/**
	 * 数量
	 */
	@Column(name = "`cardSum`")
	private Long cardAcount;

	/**
	 * 说明
	 */
	@Column(name = "`note`")
	private String note;

	/**
	 * 记录备注
	 */
	@Column(name = "`bz`")
	private String bz;

	public String getStartNo() {
		return this.startNo;
	}

	public void setStartNo(String startNo) {
		this.startNo = startNo;
	}

	public String getEndNo() {
		return this.endNo;
	}

	public void setEndNo(String endNo) {
		this.endNo = endNo;
	}

	public Long getCardAcount() {
		return this.cardAcount;
	}

	public void setCardAcount(Long cardAcount) {
		this.cardAcount = cardAcount;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public FkTCardInOutEntity getCardInOutEntity() {
		return this.cardInOutEntity;
	}

	public void setCardInOutEntity(FkTCardInOutEntity cardInOutEntity) {
		this.cardInOutEntity = cardInOutEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.bz == null) ? 0 : this.bz.hashCode());
		result = prime * result + ((this.cardAcount == null) ? 0 : this.cardAcount.hashCode());
		result = prime * result + ((this.cardInOutEntity == null) ? 0 : this.cardInOutEntity.hashCode());
		result = prime * result + ((this.endNo == null) ? 0 : this.endNo.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.note == null) ? 0 : this.note.hashCode());
		result = prime * result + ((this.startNo == null) ? 0 : this.startNo.hashCode());
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
		final CardStorageDetailEntity other = (CardStorageDetailEntity) obj;
		if (this.bz == null) {
			if (other.bz != null) {
				return false;
			}
		} else if (!this.bz.equals(other.bz)) {
			return false;
		}
		if (this.cardAcount == null) {
			if (other.cardAcount != null) {
				return false;
			}
		} else if (!this.cardAcount.equals(other.cardAcount)) {
			return false;
		}
		if (this.cardInOutEntity == null) {
			if (other.cardInOutEntity != null) {
				return false;
			}
		} else if (!this.cardInOutEntity.equals(other.cardInOutEntity)) {
			return false;
		}
		if (this.endNo == null) {
			if (other.endNo != null) {
				return false;
			}
		} else if (!this.endNo.equals(other.endNo)) {
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
		if (this.startNo == null) {
			if (other.startNo != null) {
				return false;
			}
		} else if (!this.startNo.equals(other.startNo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CardStorageDetailEntity [id=" + this.id + ", cardInOutEntity=" + this.cardInOutEntity + ", startNo="
				+ this.startNo + ", endNo=" + this.endNo + ", cardAcount=" + this.cardAcount + ", note=" + this.note + ", bz="
				+ this.bz + "]";
	}

}
