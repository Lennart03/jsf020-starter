package com.realdolmen.course.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FinancialResults {
	
	private Map<String, Integer> results; 
	
	@PostConstruct
	public void init(){
		results = new HashMap<>();
		results.put("Infrastructure", 500);
		results.put("Sales", -1200);
		results.put("Education", 1500);
		results.put("Marketing", 320);
		results.put("Java", 600);
		results.put(".NET", -250);
	}

	public Map<String, Integer> getResults() {
		return results;
	}

	public void setResults(Map<String, Integer> results) {
		this.results = results;
	}
	
	public void addResult(String departure, Integer result){
		System.out.println("Result added");
		results.put(departure, result);
	}
	

}
