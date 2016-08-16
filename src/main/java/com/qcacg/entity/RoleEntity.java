package com.qcacg.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "sys_role")
public class RoleEntity implements Serializable
{
	@Transient
	private static final long serialVersionUID = -7008567341719097566L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleId", unique = true, nullable = false)
	private Long roleId;
	@Column(name = "roleStatus")
	private String roleStatus;
	@Column(name = "roleName")
	private String roleName;
	@Column(name = "roleDescription")
	private String roleDescription;
	@Column(name = "parentRole")
	private String parentRole;

	public Long getRoleId()
	{
		return roleId;
	}

	public void setRoleId(Long roleId)
	{
		this.roleId = roleId;
	}

	public String getRoleStatus()
	{
		return roleStatus;
	}

	public void setRoleStatus(String roleStatus)
	{
		this.roleStatus = roleStatus;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	public String getRoleDescription()
	{
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription)
	{
		this.roleDescription = roleDescription;
	}

	public String getParentRole()
	{
		return parentRole;
	}

	public void setParentRole(String parentRole)
	{
		this.parentRole = parentRole;
	}

}
