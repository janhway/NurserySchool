package com.mykidedu.nurseryschool.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class Parent implements Serializable {

	private static final long serialVersionUID = 2008853282348896271L;

	private ParentId parentId;
	private ParentSubRole subRole;

	@Id
	public ParentId getParentId() {
		return parentId;
	}

	public void setParentId(ParentId parentId) {
		this.parentId = parentId;
	}
	
	@Column(name = "SUBROLE", nullable = false)
	public ParentSubRole getSubRole() {
		return subRole;
	}

	public void setSubRole(ParentSubRole subRole) {
		this.subRole = subRole;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Parent)) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		Parent other = (Parent) obj;

		return (this.parentId.equals(other.parentId));
	}

	@Override
	public int hashCode() {
		return this.parentId.hashCode();
	}
}