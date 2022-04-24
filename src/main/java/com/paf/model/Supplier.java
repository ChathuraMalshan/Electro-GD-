package com.paf.model;

public class Supplier {

	private String AccNumber;
	private Float Units;
	private Float UnitPrice;
	private String StartDate;
	private String EndDate;

	public Supplier() {

	}

	public Supplier(String AccNumber, Float Units, Float UnitPrice, String StartDate, String EndDate) {
		super();
		this.AccNumber = AccNumber;
		this.Units = Units;
		this.UnitPrice = UnitPrice;
		this.StartDate = StartDate;
		this.EndDate = EndDate;

	}

	public String getAccNumber() {
		return AccNumber;
	}

	public void setAccNumber(String AccNumber) {
		this.AccNumber = AccNumber;
	}

	public Float getUnits() {
		return Units;
	}

	public void setUnits(Float Units) {
		this.Units = Units;
	}

	public Float getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(Float UnitPrice) {
		this.UnitPrice = UnitPrice;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String StartDate) {
		this.StartDate = StartDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String EndDate) {
		this.EndDate = EndDate;
	}

}
