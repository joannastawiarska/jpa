package com.capgemini.to;


public class CarTo {

    private String type;
    private String make;
    private String color;
    private int productionYear;
    private int power;
    private double engine;
    private double mileage;
	
    public CarTo(/*Long id, */ String type, String make, String color, int productionYear, int power, double engine, double mileage){
		//this.id = id;
		this.type = type;
		this.make = make;
		this.color = color;
		this.productionYear = productionYear;
		this.power = power;
		this.engine = engine;
		this.mileage = mileage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public void setEngine(double engine) {
		this.engine = engine;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
    
}
