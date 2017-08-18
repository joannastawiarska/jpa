package com.capgemini.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AGENCY")
public class AgencyEntity extends AbstractEntity {

    @Column(nullable = false, length = 20)
    private String phoneNumber;
    @Column(nullable = false, length = 45)
    private String email;
    @OneToOne
    private AddressEntity address;
    
	protected AgencyEntity(){	
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

}
