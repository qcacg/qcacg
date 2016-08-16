package com.qcacg.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "sys_resources")
public class ResourcesEntity implements Serializable
{
	@Transient
	private static final long serialVersionUID = 2350687073322773458L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resourcesId", unique = true, nullable = false)
	private Long resourcesId;
	@Column(name = "resourcesName")
	private String resourcesName;
	@Column(name = "parentResourcesId")
	private Long parentResourcesId;
	@Column(name = "resourcesType")
	private String resourcesType;
	@Column(name = "resourcesUrl")
	private String resourcesUrl;
	@Column(name = "resourcesLevel")
	private String resourcesLevel;
	@Column(name = "resourcesView")
	private String resourcesView;
	@Column(name = "resourcesDescription")
	private String resourcesDescription;
	@Column(name = "resourcesUpdate")
	private Date resourcesUpdate;
	@Column(name = "resourcesOrder")
	private String resourcesOrder;
	@Column(name = "resourcesSort")
	private String resourcesSort;

	@Transient
	private List<ResourcesEntity> childrenResources = new ArrayList<ResourcesEntity>();

	public List<ResourcesEntity> getChildrenResources()
	{
		return childrenResources;
	}

	public void setChildrenResources(List<ResourcesEntity> childrenResources)
	{
		this.childrenResources = childrenResources;
	}

	public Long getResourcesId()
	{
		return resourcesId;
	}

	public void setResourcesId(Long resourcesId)
	{
		this.resourcesId = resourcesId;
	}

	public String getResourcesName()
	{
		return resourcesName;
	}

	public void setResourcesName(String resourcesName)
	{
		this.resourcesName = resourcesName;
	}

	public Long getParentResourcesId()
	{
		return parentResourcesId;
	}

	public void setParentResourcesId(Long parentResourcesId)
	{
		this.parentResourcesId = parentResourcesId;
	}

	public String getResourcesType()
	{
		return resourcesType;
	}

	public void setResourcesType(String resourcesType)
	{
		this.resourcesType = resourcesType;
	}

	public String getResourcesUrl()
	{
		return resourcesUrl;
	}

	public void setResourcesUrl(String resourcesUrl)
	{
		this.resourcesUrl = resourcesUrl;
	}

	public String getResourcesLevel()
	{
		return resourcesLevel;
	}

	public void setResourcesLevel(String resourcesLevel)
	{
		this.resourcesLevel = resourcesLevel;
	}

	public String getResourcesView()
	{
		return resourcesView;
	}

	public void setResourcesView(String resourcesView)
	{
		this.resourcesView = resourcesView;
	}

	public String getResourcesDescription()
	{
		return resourcesDescription;
	}

	public void setResourcesDescription(String resourcesDescription)
	{
		this.resourcesDescription = resourcesDescription;
	}

	public Date getResourcesUpdate()
	{
		return resourcesUpdate;
	}

	public void setResourcesUpdate(Date resourcesUpdate)
	{
		this.resourcesUpdate = resourcesUpdate;
	}

	public String getResourcesOrder()
	{
		return resourcesOrder;
	}

	public void setResourcesOrder(String resourcesOrder)
	{
		this.resourcesOrder = resourcesOrder;
	}

	public String getResourcesSort()
	{
		return resourcesSort;
	}

	public void setResourcesSort(String resourcesSort)
	{
		this.resourcesSort = resourcesSort;
	}

}
