package com.qcacg.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sys_user")
public class UserEntity implements Serializable
{
	@Transient
	private static final long serialVersionUID = 7561221437381062290L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	private Long userId;
	@Column(name = "userName")
	@NotEmpty(message="user.userName.notnull")
	private String userName;
	@Column(name = "telephone")
	@NotEmpty(message="user.telephone.notnull")
	private String telephone;
	@Column(name = "credentialsSalt")
	private String credentialsSalt;
	@Column(name = "userStatus")
	private String userStatus;
	@Column(name = "passWord")
	@Size(min=6,max=16,message="user.passWord.length.error")
	private String passWord;
	@Column(name = "email")
	private String email;
	@Column(name = "IP")
	private String IP;

	@Column(name = "createDate")
	private String createDate;
	@Column(name = "lastLoginDate")
	private Date lastLoginDate;
	@Column(name = "invitePeople")
	private String invitePeople;
	@Column(name = "userHead")
	private String userHead;
	@Column(name = "information")
	private String information;

	// @Transient表示注销改字段

	public String getUserHead()
	{
		return userHead;
	}

	public void setUserHead(String userHead)
	{
		this.userHead = userHead;
	}

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getCredentialsSalt()
	{
		return credentialsSalt;
	}

	public void setCredentialsSalt(String credentialsSalt)
	{
		this.credentialsSalt = credentialsSalt;
	}

	public String getUserStatus()
	{
		return userStatus;
	}

	public void setUserStatus(String userStatus)
	{
		this.userStatus = userStatus;
	}

	public String getPassWord()
	{
		return passWord;
	}

	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getIP()
	{
		return IP;
	}

	public void setIP(String IP)
	{
		this.IP = IP;
	}



	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}


	public String getInvitePeople() {
		return invitePeople;
	}

	public void setInvitePeople(String invitePeople) {
		this.invitePeople = invitePeople;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

}
