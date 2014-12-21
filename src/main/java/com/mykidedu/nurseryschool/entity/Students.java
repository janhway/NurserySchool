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
@Table(name = "STUDENTS")
public class Students implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String birthday;
	private Classes classes;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "NAME", unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "BIRTHDAY")
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@ManyToOne
	// (cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "CLASSID", referencedColumnName = "ID")
	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classRoom) {
		this.classes = classRoom;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Students)) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		Students other = (Students) obj;

		return new EqualsBuilder().append(this.id, other.id)
				.append(this.name, other.name).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(name).toHashCode();
	}

}
