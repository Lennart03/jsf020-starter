package com.realdolmen.course.web.controller;

import java.text.DecimalFormat;

public class AccountNumber {

	private Long number;
	private int checknumber;

	public AccountNumber() {
		super();
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public int getChecknumber() {
		return checknumber;
	}

	public void setChecknumber(int checknumber) {
		this.checknumber = checknumber;
	}

	@Override
	public String toString() {
		DecimalFormat formatter = new DecimalFormat("###-#######");
		String first = formatter.format(number);
		return first + "-" + checknumber;
	}

}
