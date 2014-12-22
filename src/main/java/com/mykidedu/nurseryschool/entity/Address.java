package com.mykidedu.nurseryschool.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Address")
@Embeddable
public class Address {
	private String country;
	private String province;
	private String city;
	private String street;
	private long zipCode;

	@XmlElement(name="country",required=false)
	@Column(name = "COUNTRY", length=64)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@XmlElement(name="province",required=false)
	@Column(name = "PROVINCE", length=16)
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@XmlElement(name="city",required=false)
	@Column(name = "CITY", length=16)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@XmlElement(name="street",required=false)
	@Column(name = "STREET", length=256)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	@XmlElement(name="zipCode",required=false)
	@Column(name = "ZIPCODE")
	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
}
