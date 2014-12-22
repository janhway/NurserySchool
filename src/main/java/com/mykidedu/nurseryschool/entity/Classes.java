package com.mykidedu.nurseryschool.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "CLASSES")
public class Classes implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	// private School school;
	private Grade grade;
	private List<Student> studentList; 
	//teacher list.  add it later. 

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

	// @ManyToOne
	// @JoinColumn(name = "SCHOOLID", referencedColumnName = "ID")
	// public School getSchool() {
	// return school;
	// }
	//
	// public void setSchool(School school) {
	// this.school = school;
	// }

	@ManyToOne
	@JoinColumn(name = "GRADEID", referencedColumnName = "ID")
	public Grade getGrades() {
		return grade;
	}

	public void setGrades(Grade grade) {
		this.grade = grade;
	}
	
	@OneToMany(mappedBy = "classes", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Classes)) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		Classes other = (Classes) obj;

		// Using business key equality
		return new EqualsBuilder().append(this.grade, other.grade)
				.append(this.name, other.name).isEquals();
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder(17, 47).append(grade.getName()).append(name)
				.toHashCode();
	}


}
