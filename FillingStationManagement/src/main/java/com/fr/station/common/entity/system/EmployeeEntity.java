/*
 * 员工信息表 Revised history Copyright(c) 2010 FR Co.,Ltd
 */
package com.fr.station.common.entity.system;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;

/**
 * 员工信息表
 * 
 * @version 1.0 _wsq
 */
@Entity
@Table(name = "EMPLOYEE_INFO")
public class EmployeeEntity implements StandardBean {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 员工id
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@OneToOne(mappedBy = "emplEntity")
	private OperatorEntity operEntity;

	@OneToOne(mappedBy = "emplEntity")
	private RoleInfoEntity roleEntity;

	@ManyToOne
	@JoinColumn(name = "stationId")
	private StationEntity stationId;

	/**
	 * 员工名称
	 */
	@Column(name = "`NAME`")
	private String name;

	@Column(name = "USERNO")
	private String userNum;

	/**
	 * 员工密码
	 */
	@Column(name = "`PASSWORD`")
	private String passWord;

	/**
	 * 岗位类型
	 */
	@Column(name = "post_type")
	private String postType;

	/**
	 * 身份证号
	 */
	@Column(name = "ID_NUMBER")
	private String idNumber;

	/**
	 * 文化程度
	 */
	@Column(name = "EDUCATION")
	private String education;

	/**
	 * 政治面貌
	 */
	@Column(name = "LANDSCAPE")
	private String politicalStatus;

	/**
	 * 所在班次
	 */
	@Column(name = "CLASS_ID")
	private int shiftId;

	/**
	 * 银行类型
	 */
	@Column(name = "BANKTYPE")
	private String bankType;

	/**
	 * 银行账号
	 */
	@Column(name = "BANKNO")
	private String bankNum;

	/**
	 * 联系地址
	 */
	@Column(name = "CONTACT_ADDR")
	private String contactAddr;

	/**
	 * 联系电话
	 */
	@Column(name = "CONTACT_TEL")
	private String contactTel;

	/**
	 * 邮政编码
	 */
	@Column(name = "POST_CODE")
	private String zipCode;

	/**
	 * 岗位状态
	 */
	@Column(name = "POST_STATS")
	private String postStats;

	/**
	 * 登录状态
	 */
	@Column(name = "STATS")
	private String stats;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * 更新时间
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OperatorEntity getOperEntity() {
		return operEntity;
	}

	public void setOperEntity(OperatorEntity operEntity) {
		this.operEntity = operEntity;
	}

	public RoleInfoEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleInfoEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public int getShiftId() {
		return shiftId;
	}

	public void setShiftId(int shiftId) {
		this.shiftId = shiftId;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}

	public String getContactAddr() {
		return contactAddr;
	}

	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPostStats() {
		return postStats;
	}

	public void setPostStats(String postStats) {
		this.postStats = postStats;
	}

	public String getStats() {
		return stats;
	}

	public void setStats(String stats) {
		this.stats = stats;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public StationEntity getStationId() {
		return this.stationId;
	}

	public void setStationId(StationEntity stationId) {
		this.stationId = stationId;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", operEntity=" + operEntity + ", roleEntity=" + roleEntity + ", stationId="
				+ stationId + ", name=" + name + ", userNum=" + userNum + ", passWord=" + passWord + ", postType=" + postType
				+ ", idNumber=" + idNumber + ", education=" + education + ", politicalStatus=" + politicalStatus + ", shiftId="
				+ shiftId + ", bankType=" + bankType + ", bankNum=" + bankNum + ", contactAddr=" + contactAddr
				+ ", contactTel=" + contactTel + ", zipCode=" + zipCode + ", postStats=" + postStats + ", stats=" + stats
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankNum == null) ? 0 : bankNum.hashCode());
		result = prime * result + ((bankType == null) ? 0 : bankType.hashCode());
		result = prime * result + ((contactAddr == null) ? 0 : contactAddr.hashCode());
		result = prime * result + ((contactTel == null) ? 0 : contactTel.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idNumber == null) ? 0 : idNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((operEntity == null) ? 0 : operEntity.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((politicalStatus == null) ? 0 : politicalStatus.hashCode());
		result = prime * result + ((postStats == null) ? 0 : postStats.hashCode());
		result = prime * result + ((postType == null) ? 0 : postType.hashCode());
		result = prime * result + ((roleEntity == null) ? 0 : roleEntity.hashCode());
		result = prime * result + shiftId;
		result = prime * result + ((stationId == null) ? 0 : stationId.hashCode());
		result = prime * result + ((stats == null) ? 0 : stats.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result + ((userNum == null) ? 0 : userNum.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		EmployeeEntity other = (EmployeeEntity) obj;
		if (bankNum == null) {
			if (other.bankNum != null)
				return false;
		} else if (!bankNum.equals(other.bankNum))
			return false;
		if (bankType == null) {
			if (other.bankType != null)
				return false;
		} else if (!bankType.equals(other.bankType))
			return false;
		if (contactAddr == null) {
			if (other.contactAddr != null)
				return false;
		} else if (!contactAddr.equals(other.contactAddr))
			return false;
		if (contactTel == null) {
			if (other.contactTel != null)
				return false;
		} else if (!contactTel.equals(other.contactTel))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idNumber == null) {
			if (other.idNumber != null)
				return false;
		} else if (!idNumber.equals(other.idNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (operEntity == null) {
			if (other.operEntity != null)
				return false;
		} else if (!operEntity.equals(other.operEntity))
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (politicalStatus == null) {
			if (other.politicalStatus != null)
				return false;
		} else if (!politicalStatus.equals(other.politicalStatus))
			return false;
		if (postStats == null) {
			if (other.postStats != null)
				return false;
		} else if (!postStats.equals(other.postStats))
			return false;
		if (postType == null) {
			if (other.postType != null)
				return false;
		} else if (!postType.equals(other.postType))
			return false;
		if (roleEntity == null) {
			if (other.roleEntity != null)
				return false;
		} else if (!roleEntity.equals(other.roleEntity))
			return false;
		if (shiftId != other.shiftId)
			return false;
		if (stationId == null) {
			if (other.stationId != null)
				return false;
		} else if (!stationId.equals(other.stationId))
			return false;
		if (stats == null) {
			if (other.stats != null)
				return false;
		} else if (!stats.equals(other.stats))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		if (userNum == null) {
			if (other.userNum != null)
				return false;
		} else if (!userNum.equals(other.userNum))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

}
