package com.project.onlinefooddelivery.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="Login_Tb")
public class Login {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	
	private int userId;
	@NotNull(message="userName should be mandatory")
	private String userName;
	
	@NotNull(message="password is mandatory")
	@Length(min=8,message="you must enter atleast 8 characters!!!!")
	@Pattern(regexp="^[a-zA-Z!@#$%^&*()_+0-9]{8,20}",message="password should contain atleast one upper case, atleast one lower case and atleat one special character")
	private String password;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	

}
