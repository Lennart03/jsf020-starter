package com.realdolmen.course.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class UserList implements Serializable {

	private List<User> users;
	
	public UserList() {
	}
	
	@PostConstruct
	public void init(){
		users = new ArrayList<>();
		User user = new User();
		user.setFirstName("Lennart");
		user.setLastName("Van Damme");
		user.setEmail("lennart.vandamme@gmail.com");
		user.setDateOfBirth(new Date(1994, 10, 3));
		user.setGender("Male");
		user.setServiceLevel("Nub");
		users.add(user);
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}

	public List<User> getUsers() {
		return users;
	}
	
	public UserList getUserList() {
		return this;
	}
	
	public User getUser(int index) {
		return users.get(index);
	}
	
	public int indexOf(User user) {
		System.out.println(users.indexOf(user));
		return users.indexOf(user);
	}
	
	
	
}
