package com.capgemini.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity extends AbstractEntity {
	
    @Column(nullable = false, length = 20)
    private String street;
    @Column(nullable = false, length = 10)
    private String postCode;
    @Column(nullable = false, length = 20)
    private String city;
    @Column(nullable = false, length = 25)
    private String region;
    
    public AddressEntity() {
    }
    
	public AddressEntity(String street, String postCode, String city, String region) {
		super();
		this.street = street;
		this.postCode = postCode;
		this.city = city;
		this.region = region;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
}
