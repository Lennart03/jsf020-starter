package com.realdolmen.course.web.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class HelloBean {
	
	private String message = "Hello from JSF!";

	public String getMessage() {
		return message;
	}
}
