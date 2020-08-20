package com.spring.boot.springRESTWithValidator.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class User {
	
	@NotEmpty(message = "Username can not be empty")
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 charachters long ")
	private String username;
	
	@Min(value = 1, message = "age can not be less than one")
	@Max(value = 140, message = "Unrealistic age value")
	private int age;
	
	
	public User(String username, int age) {
		this.username = username;
		this.age = age;
	}
	
	public User() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
	
}
