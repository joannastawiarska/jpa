package com.capgemini.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class ClientEntity extends AbstractEntity {

	@Column(nullable = false, length = 100)
    private String name;
	@Column(nullable = false, length = 100)
    private String surname;
	@Column(nullable = false, length = 20)
    private String phoneNumber;
	@Column(nullable = false, length = 22)
    private String cardNumber;
    @Column(nullable = false, length = 45)
    private String email;
	@Column(nullable = false)
    private Date dateBirth;
    @OneToOne
    private AddressEntity address;
	
	protected ClientEntity(){	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	
	
	
}
