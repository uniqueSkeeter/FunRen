/*
 * 站长、操作员等角色 Revised history Copyright(c) 2010 FR Co.,Ltd
 */
package com.fr.station.common.entity.system;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;

/**
 * 角色
 *
 * @version 1.0 _wsq
 */
@Entity
@Table(name = "ROLE")
public class RoleInfoEntity implements StandardBean {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 角色
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@OneToMany(mappedBy = "roleEntity")
	private Set<OperatorEntity> operEntity;

	@OneToOne
	@JoinColumn(name = "USERID")
	private EmployeeEntity emplEntity;

	@OneToMany(mappedBy = "roleId")
	private Set<RoleFunctionInfoEntity> functionId;

	/**
	 * 角色名称
	 */
	@Column(name = "NAME")
	private String name;

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

	public Set<OperatorEntity> getOperEntity() {
		return this.operEntity;
	}

	public void setOperEntity(Set<OperatorEntity> operEntity) {
		this.operEntity = operEntity;
	}

	public EmployeeEntity getEmplEntity() {
		return this.emplEntity;
	}

	public void setEmplEntity(EmployeeEntity emplEntity) {
		this.emplEntity = emplEntity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Set<RoleFunctionInfoEntity> getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(Set<RoleFunctionInfoEntity> functionId) {
		this.functionId = functionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.createDate == null) ? 0 : this.createDate.hashCode());
		result = prime * result + ((this.emplEntity == null) ? 0 : this.emplEntity.hashCode());
		result = prime * result + this.id;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.operEntity == null) ? 0 : this.operEntity.hashCode());
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
		RoleInfoEntity other = (RoleInfoEntity) obj;
		if (this.createDate == null) {
			if (other.createDate != null) {
				return false;
			}
		} else if (!this.createDate.equals(other.createDate)) {
			return false;
		}
		if (this.emplEntity == null) {
			if (other.emplEntity != null) {
				return false;
			}
		} else if (!this.emplEntity.equals(other.emplEntity)) {
			return false;
		}
		if (this.id != other.id) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.operEntity == null) {
			if (other.operEntity != null) {
				return false;
			}
		} else if (!this.operEntity.equals(other.operEntity)) {
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

	@Override
	public String toString() {
		return "RoleInfoEntity [id=" + this.id + ", operEntity=" + this.operEntity + ", emplEntity=" + this.emplEntity
				+ ", name=" + this.name + ", createDate=" + this.createDate + ", updateDate=" + this.updateDate + "]";
	}

}
