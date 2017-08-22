package com.capgemini.domain;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WORKER")
public class WorkerEntity extends AbstractEntity {

	@Column(nullable = false, length = 15)
    private String name;
	@Column(nullable = false, length = 25)
    private String surname;
	@Column
    private Date dateBirth;
    @ManyToOne
    private WorkerPositionEntity position;
	@OneToOne
    private AddressEntity address;
    @ManyToOne
    private AgencyEntity agency;
    @ManyToMany(mappedBy="worker", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CarEntity> car;
    
    public WorkerEntity(){
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

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public WorkerPositionEntity getPosition() {
		return position;
	}

	public void setPosition(WorkerPositionEntity position) {
		this.position = position;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public AgencyEntity getAgency() {
		return agency;
	}

	public void setAgency(AgencyEntity agency) {
		this.agency = agency;
	}

	public Set<CarEntity> getCar() {
		return car;
	}

	public void setCar(Set<CarEntity> car) {
		this.car = car;
	}

}
