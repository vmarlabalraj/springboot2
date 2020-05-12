package com.javainterviewpoint.security;

import java.util.HashMap;
import java.util.Map;

public class AdminUserData {
	
	private String userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String roleId;
	private String roleName;
	private String roleDesc;
	private String userToken;
	private String password;
	private String oldPassword;
	private String newPassword;
	private String deleteInd;
	private String cobrowseCode;
	private Map<String, String> rolesMap = new HashMap<String, String>();
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDeleteInd() {
		return deleteInd;
	}
	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}
	public Map<String, String> getRolesMap() {
		return rolesMap;
	}
	public void setRolesMap(Map<String, String> rolesMap) {
		this.rolesMap = rolesMap;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getCobrowseCode() {
		return cobrowseCode;
	}
	public void setCobrowseCode(String cobrowseCode) {
		this.cobrowseCode = cobrowseCode;
	}
}
