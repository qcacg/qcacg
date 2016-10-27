package com.qcacg.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "sys_server")
public class ServerEntity implements Serializable
{
	@Transient
	private static final long serialVersionUID = -2053588631509322820L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serverId", unique = true, nullable = false)
	private Long serverId;
	@Column(name = "cpuUsage")
	private String cpuUsage;
	@Column(name = "setCpuUsage")
	private String setCpuUsage;
	@Column(name = "jvmUsage")
	private String jvmUsage;
	@Column(name = "setJvmUsage")
	private String setJvmUsage;
	@Column(name = "ramUsage")
	private String ramUsage;
	@Column(name = "setRamUsage")
	private String setRamUsage;
	@Column(name = "email")
	private String email;
	@Column(name = "ServerUpdate")
	private String ServerUpdate;
	@Column(name = "ServerMark")
	private String ServerMark;

	public Long getServerId()
	{
		return serverId;
	}

	public void setServerId(Long serverId)
	{
		this.serverId = serverId;
	}

	public String getCpuUsage()
	{
		return cpuUsage;
	}

	public void setCpuUsage(String cpuUsage)
	{
		this.cpuUsage = cpuUsage;
	}

	public String getSetCpuUsage()
	{
		return setCpuUsage;
	}

	public void setSetCpuUsage(String setCpuUsage)
	{
		this.setCpuUsage = setCpuUsage;
	}

	public String getJvmUsage()
	{
		return jvmUsage;
	}

	public void setJvmUsage(String jvmUsage)
	{
		this.jvmUsage = jvmUsage;
	}

	public String getSetJvmUsage()
	{
		return setJvmUsage;
	}

	public void setSetJvmUsage(String setJvmUsage)
	{
		this.setJvmUsage = setJvmUsage;
	}

	public String getRamUsage()
	{
		return ramUsage;
	}

	public void setRamUsage(String ramUsage)
	{
		this.ramUsage = ramUsage;
	}

	public String getSetRamUsage()
	{
		return setRamUsage;
	}

	public void setSetRamUsage(String setRamUsage)
	{
		this.setRamUsage = setRamUsage;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getServerUpdate()
	{
		return ServerUpdate;
	}

	public void setServerUpdate(String ServerUpdate)
	{
		this.ServerUpdate = ServerUpdate;
	}

	public String getServerMark()
	{
		return ServerMark;
	}

	public void setServerMark(String ServerMark)
	{
		this.ServerMark = ServerMark;
	}

}
