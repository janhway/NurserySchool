package com.mykidedu.nurseryschool.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TEACHERS")
public class Teachers implements Serializable {

	private static final long serialVersionUID = 2008853282348896271L;

	private TeacherId teacherId;
	private String subRole;

	@Id
	public TeacherId getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(TeacherId teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getSubRole() {
		return subRole;
	}

	public void setSubRole(String subRole) {
		this.subRole = subRole;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Teachers)) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		Teachers other = (Teachers) obj;

		return (this.teacherId.equals(other.teacherId));
	}

	@Override
	public int hashCode() {
		return this.teacherId.hashCode();
	}
}
