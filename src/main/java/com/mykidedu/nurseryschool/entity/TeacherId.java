package com.mykidedu.nurseryschool.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class TeacherId implements Serializable {

	private static final long serialVersionUID = 7338973140234139520L;

	private User user;
	private Classes classRoom;

	@ManyToOne
	// (cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "CLASSID", referencedColumnName = "ID")
	public Classes getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(Classes classRoom) {
		this.classRoom = classRoom;
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
		if (!(obj instanceof TeacherId)) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		TeacherId other = (TeacherId) obj;

		return new EqualsBuilder()
				.append(this.user.getId(), other.user.getId())
				.append(this.classRoom.getId(), other.classRoom.getId())
				.isEquals();
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder(17, 37).append(user.getId())
				.append(classRoom.getId()).toHashCode();
	}

}
