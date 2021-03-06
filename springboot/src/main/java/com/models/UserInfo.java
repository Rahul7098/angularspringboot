package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo 
{
	 private int rollno;
	 private String name;
	 private String email;
	 private String password;

	 @Id
	 public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
