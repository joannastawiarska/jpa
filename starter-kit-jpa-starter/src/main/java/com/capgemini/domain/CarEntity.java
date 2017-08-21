package com.capgemini.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CAR")
public class CarEntity extends AbstractEntity {
	
	@Column(nullable = false, length = 20)
    private String type;
	@Column(nullable = false, length = 20)
    private String make;
	@Column(nullable = false, length = 20)
    private String color;
	@Column(nullable = false, length = 4)
    private int productionYear;


	@Column(nullable = false, length = 15)
    private int power;
	@Column(nullable = false, precision = 3, scale = 1)
    private double engine;
	@Column(nullable = false, precision = 8, scale = 1)
    private double mileage;
	
	//@ManyToMany
	//@JoinTable(name = "carer",joinColumns = { @JoinColumn(name = "WORKER_ID", nullable = false, updatable = false)},
	//              inverseJoinColumns = {@JoinColumn(name = "CAR_ID", nullable = false, updatable = false)})
	//private Set<WorkerEntity> worker;
	
	
	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<RentEntity> rents;
	
   @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinTable(name = "CARER",
            joinColumns = {@JoinColumn(name = "WORKER_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "CAR_ID", nullable = false, updatable = false)}
    )
    private Set<WorkerEntity> worker = new HashSet<>();
	
	public CarEntity(){	
	}
	
	public CarEntity(/*Long id,*/ String type, String make, String color, int productionYear, int power, double engine, double mileage){
		//this.id = id;
		this.type = type;
		this.make = make;
		this.color = color;
		this.productionYear = productionYear;
		this.power = power;
		this.engine = engine;
		this.mileage = mileage;
	}

	public Set<RentEntity> getRents() {
		return rents;
	}

	public void setRents(Set<RentEntity> rents) {
		this.rents = rents;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<WorkerEntity> getWorker() {
		return worker;
	}

	public void setWorker(Set<WorkerEntity> workers) {
		this.worker = workers;
	}

	public void setEngine(double engine) {
		this.engine = engine;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public double getEngine() {
		return engine;
	}

	public void setEngine(int engine) {
		this.engine = engine;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	@Override
	public String toString() {
		return "CarEntity [type=" + type + ", make=" + make + ", color=" + color + ", productionYear=" + productionYear
				+ ", power=" + power + ", engine=" + engine + ", mileage=" + mileage + ", worker=" + worker + "]";
	}
	
	
}
