package cn.appsys.pojo;

import java.util.Date;

public class BackendUser {
	private Integer id;				//主键id
	private String userCode;		//用户编码
	private String userName;		//用户名称
	private Integer userType;		//用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）
	private Integer createdBy;		//创建者（来源于backend_user用户表的用户id）
	private Date creationDate;		//创建时间
	private Integer modifyBy;		//更新者（来源于backend_user用户表的用户id）
	private Date modifyDate;		//最新更新时间
	private String userPassword;	//用户密码
	private String userTypeName;	//角色名
	
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
