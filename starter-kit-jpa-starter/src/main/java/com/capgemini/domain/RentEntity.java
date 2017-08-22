package com.capgemini.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RENT", indexes = {
		@Index(name = "indeks_client", columnList = "client_id"),
		@Index(name = "indeks_car", columnList = "car_id")})
public class RentEntity extends AbstractEntity {
	
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientEntity client;
    @ManyToOne(fetch = FetchType.LAZY)
    private CarEntity car;
    @ManyToOne(fetch = FetchType.LAZY)
    private AgencyEntity agencyFrom;
    @ManyToOne(fetch = FetchType.LAZY)
    private AgencyEntity agencyTo;
	@Column(nullable = false)
    private Date dateRent;
	@Column(nullable = false)
    private Date dateReturn;
	@Column(nullable = false)
    private float cost;

	public RentEntity(){	
	}
	
	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public CarEntity getCar() {
		return car;
	}

	public void setCar(CarEntity car) {
		this.car = car;
	}

	public AgencyEntity getAgencyFrom() {
		return agencyFrom;
	}

	public void setAgencyFrom(AgencyEntity agencyFrom) {
		this.agencyFrom = agencyFrom;
	}

	public AgencyEntity getAgencyTo() {
		return agencyTo;
	}

	public void setAgencyTo(AgencyEntity agencyTo) {
		this.agencyTo = agencyTo;
	}

	public Date getDateRent() {
		return dateRent;
	}

	public void setDateRent(Date dateRent) {
		this.dateRent = dateRent;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}	
	
}
