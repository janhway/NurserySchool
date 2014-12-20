package com.mykidedu.nurseryschool.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mykidedu.nurseryschool.entity.Role;

@SuppressWarnings("all")
@XmlRootElement(name = "GetUserNode")
public class UserNode {

	private String userName;
	private String password;

	// 不要用entity里面的, fix it later.
	private Role role;
	
	private String firstName;
	private String lastName;
	
	
	@XmlElement(name="firstName", required=false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlElement(name="lastName", required=false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlElement(name="userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@XmlElement(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String passWord) {
		this.password = passWord;
	}

	@XmlElement(name="role")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
