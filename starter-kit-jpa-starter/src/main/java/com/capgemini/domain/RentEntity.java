package com.capgemini.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "RENT", indexes = {
		@Index(name = "indeks_client", columnList = "client_id"),
		@Index(name = "indeks_car", columnList = "car_id")})
public class RentEntity extends AbstractEntity {
	
    @ManyToOne
    private ClientEntity client;
    @ManyToOne
    private CarEntity car;
    @ManyToOne
    private AgencyEntity agencyFrom;
    @ManyToOne
    private AgencyEntity agencyTo;
	@Column(nullable = false)
    private Date dateRent;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
    private Date dateReturn;
	@Column(nullable = false)
    private float cost;
	
	//o.myDate BETWEEN :startDate AND :endDate

	public RentEntity(){	
	}

	public RentEntity(Date dateRent, Date dateReturn, float cost) {
		this.dateRent = dateRent;
		this.dateReturn = dateReturn;
		this.cost = cost;
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
