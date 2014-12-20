package com.mykidedu.nurseryschool.msg;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("all")
@XmlRootElement(name = "GetUsersRsp")
public class UserList {

	private List<UserNode> userList;

	public UserList() {

	}

	public UserList(List<UserNode> userList) {
		this.userList = userList;
	}

	@XmlElement(name = "userName")
	public List<UserNode> getUserList() {
		return userList;
	}

	public void setUserList(List<UserNode> userList) {
		this.userList = userList;
	}

}
