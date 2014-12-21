package com.mykidedu.nurseryschool.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("all")
@XmlRootElement(name = "CreateSchoolMasterReq")
public class CreateSchoolMasterReq {

	private CreateUserReq crtUserReq;	
	private int schoolId;

	@XmlElement(name = "schoolId")
	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	@XmlElement(name = "userInfo")
	public CreateUserReq getCrtUserReq() {
		return crtUserReq;
	}

	public void setCrtUserReq(CreateUserReq crtUserReq) {
		this.crtUserReq = crtUserReq;
	}
}
