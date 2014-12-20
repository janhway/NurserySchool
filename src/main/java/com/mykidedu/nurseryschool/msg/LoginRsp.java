package com.mykidedu.nurseryschool.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@SuppressWarnings("all")
@XmlRootElement(name = "LoginRsp")
public class LoginRsp {
	private long userId;
	private String encodedToken;

	@XmlElement(name="userId")
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@XmlElement(name="token")
	public String getEncodedToken() {
		return encodedToken;
	}

	public void setEncodedToken(String encodedToken) {
		this.encodedToken = encodedToken;
	}
}
