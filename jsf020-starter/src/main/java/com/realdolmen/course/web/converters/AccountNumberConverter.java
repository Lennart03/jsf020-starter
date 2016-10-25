package com.realdolmen.course.web.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.realdolmen.course.web.controller.AccountNumber;


@FacesConverter(forClass = AccountNumber.class)
public class AccountNumberConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 == null || arg2.trim().equals("")) {
			return null;
		}
		AccountNumber accountNumber = new AccountNumber();
		String[] splited = arg2.split("-");
		if(splited.length == 3) {
			accountNumber.setNumber(Long.parseLong(splited[0].concat(splited[1])));
			accountNumber.setChecknumber(Integer.parseInt(splited[2]));
		} else {
			FacesMessage errMsg = new FacesMessage("Bad account number son!");
			throw new ConverterException(errMsg);
		}
		return accountNumber;

	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return arg2.toString();
	}

}
