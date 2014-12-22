package com.mykidedu.nurseryschool.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class ParentId implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;
	private Student student;

	@ManyToOne
	@JoinColumn(name = "STUDENTID", referencedColumnName = "ID")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	@JoinColumn(name = "USERID", referencedColumnName = "ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ParentId)) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		ParentId other = (ParentId) obj;

		return new EqualsBuilder().append(this.user, other.user)
				.append(this.student, other.student).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(user).append(student)
				.toHashCode();
	}

}
