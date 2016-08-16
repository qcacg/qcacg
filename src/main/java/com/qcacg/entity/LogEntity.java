package com.qcacg.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "sys_log")
public class LogEntity implements Serializable
{
	@Transient
	private static final long serialVersionUID = -7219312610626941290L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "logId", unique = true, nullable = false)
	private Long logId;
	@Column(name = "userName")
	private String userName;
	@Column(name = "resourcesName")
	private String resourcesName;
	@Column(name = "methods")
	private String methods;
	@Column(name = "logActionTime")
	private String logActionTime;
	@Column(name = "ip")
	private String ip;
	@Column(name = "description")
	private String description;
	@Column(name = "resourcesUrl")
	private String resourcesUrl;
	@OrderBy("desc")
	@Column(name = "logUpdate")
	private String logUpdate;

	public Long getLogId()
	{
		return logId;
	}

	public void setLogId(Long logId)
	{
		this.logId = logId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getResourcesName()
	{
		return resourcesName;
	}

	public void setResourcesName(String resourcesName)
	{
		this.resourcesName = resourcesName;
	}

	public String getMethods()
	{
		return methods;
	}

	public void setMethods(String methods)
	{
		this.methods = methods;
	}

	public String getLogActionTime()
	{
		return logActionTime;
	}

	public void setLogActionTime(String logActionTime)
	{
		this.logActionTime = logActionTime;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getLogUpdate()
	{
		return logUpdate;
	}

	public void setLogUpdate(String logUpdate)
	{
		this.logUpdate = logUpdate;
	}

	public String getResourcesUrl()
	{
		return resourcesUrl;
	}

	public void setResourcesUrl(String resourcesUrl)
	{
		this.resourcesUrl = resourcesUrl;
	}

}
