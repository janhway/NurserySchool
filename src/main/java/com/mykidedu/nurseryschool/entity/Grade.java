package com.mykidedu.nurseryschool.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "GRADES")
public class Grade implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private School school;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "SCHOOLID", referencedColumnName = "ID")
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Grade)) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		Grade other = (Grade) obj;

		// Using business key equality
		return new EqualsBuilder()
				.append(this.school.getName(), other.school.getName())
				.append(this.name, other.name).isEquals();
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder(17, 47).append(school.getName())
				.append(name).toHashCode();
	}
}
