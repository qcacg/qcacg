package com.qcacg.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "sys_button")
public class ButtonEntity implements Serializable
{
	@Transient
	private static final long serialVersionUID = 4632776596792017054L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "buttonId", unique = true, nullable = false)
	private Long buttonId;
	@Column(name = "buttonName")
	private String buttonName;
	@Column(name = "buttonCode")
	private String buttonCode;
	@Column(name = "buttonDescription")
	private String buttonDescription;
	@Column(name = "buttonUpdate")
	private String buttonUpdate;

	public Long getButtonId()
	{
		return buttonId;
	}

	public void setButtonId(Long buttonId)
	{
		this.buttonId = buttonId;
	}

	public String getButtonName()
	{
		return buttonName;
	}

	public void setButtonName(String buttonName)
	{
		this.buttonName = buttonName;
	}

	public String getButtonCode()
	{
		return buttonCode;
	}

	public void setButtonCode(String buttonCode)
	{
		this.buttonCode = buttonCode;
	}

	public String getButtonDescription()
	{
		return buttonDescription;
	}

	public void setButtonDescription(String buttonDescription)
	{
		this.buttonDescription = buttonDescription;
	}

	public String getButtonUpdate()
	{
		return buttonUpdate;
	}

	public void setButtonUpdate(String buttonUpdate)
	{
		this.buttonUpdate = buttonUpdate;
	}

}
