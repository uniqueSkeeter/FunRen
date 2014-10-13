package com.fr.station.common.entity.report;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;

@Entity
@Table(name = "T_ZD_OIL")
public class OilManageEntity implements StandardBean {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	
	@Column(name = "OILNAME")
	private String oilName;
	
	@Column(name = "OILCODE")
    private String oilCode;
	
	@Column(name = "OILPRICE")
    private BigDecimal oilPrice;
	
	@Column(name = "OLDPRICE")
    private BigDecimal oldPrice;
	
	@Column(name = "OILTYPE")
    private String oilType;
	
	@Column(name = "OILDEN")
    private String oilDen;
	
	@Column(name = "OILDW")
	private String oilDw;
	
	@Column(name = "OILGG")
    private String oilGg;
	
	@Column(name = "LSDW")
    private String lsDw;
	
	@Column(name = "FLKH")
    private String flkh;
	
	@Column(name = "BZGG")
    private Integer bzgg;
	
	@Column(name = "OILSHDM")
	private String oilShdm;

	@Column(name = "OILZYDM")
    private String oilZydm;
	
	@Column(name = "BZ")
	private String bz;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOilName() {
		return oilName;
	}

	public void setOilName(String oilName) {
		this.oilName = oilName;
	}

	public String getOilCode() {
		return oilCode;
	}

	public void setOilCode(String oilCode) {
		this.oilCode = oilCode;
	}

	public BigDecimal getOilPrice() {
		return oilPrice;
	}

	public void setOilPrice(BigDecimal oilPrice) {
		this.oilPrice = oilPrice;
	}

	public BigDecimal getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getOilType() {
		return oilType;
	}

	public void setOilType(String oilType) {
		this.oilType = oilType;
	}

	public String getOilDen() {
		return oilDen;
	}

	public void setOilDen(String oilDen) {
		this.oilDen = oilDen;
	}

	public String getOilDw() {
		return oilDw;
	}

	public void setOilDw(String oilDw) {
		this.oilDw = oilDw;
	}

	public String getOilGg() {
		return oilGg;
	}

	public void setOilGg(String oilGg) {
		this.oilGg = oilGg;
	}

	public String getLsDw() {
		return lsDw;
	}

	public void setLsDw(String lsDw) {
		this.lsDw = lsDw;
	}

	public String getFlkh() {
		return flkh;
	}

	public void setFlkh(String flkh) {
		this.flkh = flkh;
	}

	public Integer getBzgg() {
		return bzgg;
	}

	public void setBzgg(Integer bzgg) {
		this.bzgg = bzgg;
	}

	public String getOilShdm() {
		return oilShdm;
	}

	public void setOilShdm(String oilShdm) {
		this.oilShdm = oilShdm;
	}

	public String getOilZydm() {
		return oilZydm;
	}

	public void setOilZydm(String oilZydm) {
		this.oilZydm = oilZydm;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bz == null) ? 0 : bz.hashCode());
		result = prime * result + bzgg;
		result = prime * result + ((flkh == null) ? 0 : flkh.hashCode());
		result = prime * result + id;
		result = prime * result + ((oilCode == null) ? 0 : oilCode.hashCode());
		result = prime * result + ((lsDw == null) ? 0 : lsDw.hashCode());
		result = prime * result + ((oilDen == null) ? 0 : oilDen.hashCode());
		result = prime * result + ((oilDw == null) ? 0 : oilDw.hashCode());
		result = prime * result + ((oilGg == null) ? 0 : oilGg.hashCode());
		result = prime * result + ((oilName == null) ? 0 : oilName.hashCode());
		result = prime * result
				+ ((oilPrice == null) ? 0 : oilPrice.hashCode());
		result = prime * result + ((oilShdm == null) ? 0 : oilShdm.hashCode());
		result = prime * result + ((oilType == null) ? 0 : oilType.hashCode());
		result = prime * result + ((oilZydm == null) ? 0 : oilZydm.hashCode());
		result = prime * result
				+ ((oldPrice == null) ? 0 : oldPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OilManageEntity other = (OilManageEntity) obj;
		if (bz == null) {
			if (other.bz != null)
				return false;
		} else if (!bz.equals(other.bz))
			return false;
		if (bzgg != other.bzgg)
			return false;
		if (flkh == null) {
			if (other.flkh != null)
				return false;
		} else if (!flkh.equals(other.flkh))
			return false;
		if (id != other.id)
			return false;
		if (oilCode == null) {
			if (other.oilCode != null)
				return false;
		} else if (!oilCode.equals(other.oilCode))
			return false;
		if (lsDw == null) {
			if (other.lsDw != null)
				return false;
		} else if (!lsDw.equals(other.lsDw))
			return false;
		if (oilDen == null) {
			if (other.oilDen != null)
				return false;
		} else if (!oilDen.equals(other.oilDen))
			return false;
		if (oilDw == null) {
			if (other.oilDw != null)
				return false;
		} else if (!oilDw.equals(other.oilDw))
			return false;
		if (oilGg == null) {
			if (other.oilGg != null)
				return false;
		} else if (!oilGg.equals(other.oilGg))
			return false;
		if (oilName == null) {
			if (other.oilName != null)
				return false;
		} else if (!oilName.equals(other.oilName))
			return false;
		if (oilPrice == null) {
			if (other.oilPrice != null)
				return false;
		} else if (!oilPrice.equals(other.oilPrice))
			return false;
		if (oilShdm == null) {
			if (other.oilShdm != null)
				return false;
		} else if (!oilShdm.equals(other.oilShdm))
			return false;
		if (oilType == null) {
			if (other.oilType != null)
				return false;
		} else if (!oilType.equals(other.oilType))
			return false;
		if (oilZydm == null) {
			if (other.oilZydm != null)
				return false;
		} else if (!oilZydm.equals(other.oilZydm))
			return false;
		if (oldPrice == null) {
			if (other.oldPrice != null)
				return false;
		} else if (!oldPrice.equals(other.oldPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OilManageEntity [id=" + id + ", oilName=" + oilName
				+ ", oilCode=" + oilCode + ", oilPrice=" + oilPrice
				+ ", oldPrice=" + oldPrice + ", oilType=" + oilType
				+ ", oilDen=" + oilDen + ", oilDw=" + oilDw + ", oilGg="
				+ oilGg + ", lsDw=" + lsDw + ", flkh=" + flkh + ", bzgg="
				+ bzgg + ", oilShdm=" + oilShdm + ", oilZydm=" + oilZydm
				+ ", bz=" + bz + "]";
	}
	
}
