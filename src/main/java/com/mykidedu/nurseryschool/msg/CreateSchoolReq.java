package com.mykidedu.nurseryschool.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mykidedu.nurseryschool.entity.Address;

@SuppressWarnings("all")
@XmlRootElement(name = "CreateSchoolReq")
public class CreateSchoolReq {
	private String name;
	private Address address;
	private String description;


	@XmlElement(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="address",required = false)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@XmlElement(name="description", required=false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
