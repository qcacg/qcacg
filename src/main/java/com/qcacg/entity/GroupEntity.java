package com.qcacg.entity;

import java.io.Serializable;

public class GroupEntity implements Serializable
{
	private static final long serialVersionUID = -8437581071217901497L;
	private Long roleId;
	private Long userId;
	private Long resourcesId;

	public Long getRoleId()
	{
		return roleId;
	}

	public void setRoleId(Long roleId)
	{
		this.roleId = roleId;
	}

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public Long getResourcesId()
	{
		return resourcesId;
	}

	public void setResourcesId(Long resourcesId)
	{
		this.resourcesId = resourcesId;
	}

}
