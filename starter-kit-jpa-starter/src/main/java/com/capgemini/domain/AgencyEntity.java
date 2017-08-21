package com.capgemini.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
    @OneToMany(mappedBy="agency")
    private List<WorkerEntity> workers;
    
	public AgencyEntity(){	
	}
    
	public AgencyEntity(String phoneNumber, String email, List<WorkerEntity> workers){
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.workers = workers;
	}
	public List<WorkerEntity> getWorkers() {
		return workers;
	}

	public void setWorkers(List<WorkerEntity> workers) {
		this.workers = workers;
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
