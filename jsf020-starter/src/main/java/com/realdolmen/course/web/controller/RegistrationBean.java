package com.realdolmen.course.web.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@ManagedBean
@SessionScoped
public class RegistrationBean implements Serializable {
	
	
	@NotBlank
	@Size(min=2, max=50)
	private String firstName;
	
	@NotBlank
	@Size(min=2, max=50)
	private String lastName;
	
	@NotNull
	@Past
	private Date dateOfBirth;

	@NotBlank
	private String gender;
	@Email
	private String email;
	
	@NotBlank
	private String serviceLevel;
	private boolean editable = true;

	@ManagedProperty(value = "#{userList}")
	private UserList userList;
	
	private AccountNumber accountNumber;

	public RegistrationBean() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setUserList(UserList userList) {
		this.userList = userList;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}
	
	

	public AccountNumber getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(AccountNumber accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String register() {
		System.out.println("Someone has registered.");
		User user = new User();
		user.setFirstName(this.firstName);
		user.setLastName(this.lastName);
		user.setEmail(this.email);
		user.setDateOfBirth(this.dateOfBirth);
		user.setGender(this.gender);
		user.setServiceLevel(this.serviceLevel);
		userList.addUser(user);
		editSwitch();
		return "toConfirm";
	}

	public String confirm() {
		System.out.println("Write the values to de Database.");
		System.out.println(this.accountNumber);
		editSwitch();
		this.dateOfBirth = null;
		this.email = "";
		this.firstName = "";
		this.lastName= "";
		this.gender = "";
		this.serviceLevel = "";
		return "toThanks";
	}

	public String editInput() {
		editSwitch();
		return "edit";
	}

	public boolean getEditable() {
		return this.editable;
	}

	public void editSwitch() {
		editable = !editable;
		System.out.println("Editable: " + editable);
	}

	public RegistrationBean getRegistrationBean() {
		return this;
	}

}
