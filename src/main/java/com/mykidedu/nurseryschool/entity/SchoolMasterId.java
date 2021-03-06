package com.mykidedu.nurseryschool.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class SchoolMasterId implements Serializable {

	private static final long serialVersionUID = 7338973140234139520L;

	private User user;
	private School school;

	@ManyToOne
	// (cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "SCHOOLID", referencedColumnName = "ID")
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@ManyToOne
	// (cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "USERID", referencedColumnName = "ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SchoolMasterId)) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		SchoolMasterId other = (SchoolMasterId) obj;

		return new EqualsBuilder()
				.append(this.user.getId(), other.user.getId())
				.append(this.school.getId(), other.school.getId()).isEquals();
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder(17, 31).append(user.getId())
				.append(school.getId()).toHashCode();
	}
}
