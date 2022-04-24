package com.paf.model;

public class Bill {

	private String AccNumber;
	private String Unit;
	private String UnitPrice;
	private String Amount;
	private String Remark;
	private String Date;

	public Bill() {

	}

	public Bill(String AccNumber, String Unit, String UnitPrice, String Amount, String Remark, String Date) {
		super();
		this.AccNumber = AccNumber;
		this.Unit = Unit;
		this.UnitPrice = UnitPrice;
		this.Amount = Amount;
		this.Remark = Remark;
		this.Date = Date;
	}

	public String getAccNumber() {
		return AccNumber;
	}

	public void setAccNumber(String AccNumber) {
		this.AccNumber = AccNumber;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String Unit) {
		this.Unit = Unit;
	}

	public String getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(String UnitPrice) {
		this.UnitPrice = UnitPrice;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String Amount) {
		this.Amount = Amount;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String Remark) {
		this.Remark = Remark;
	}
	public String getDate() {
		return Date;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}

}
