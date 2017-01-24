package com.waa.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Customer {
//	@NotEmpty(message = "{label.username}")
//	@Size(min = 6, max = 50,message="{label.size}")
	public String username;

//	@NotEmpty(message = "{label.address}")
	public String address;
	
//	@DateTimeFormat(pattern = "dd-mm-yyyy")
//	@Past(message = "{label.dateOfBirth}")
//	@NotNull(message = "Date of Birth may not be null")
	public Date dateOfBirth;
	
//	@NotEmpty(message = "{label.password}")
//	@Size(min = 6, max = 50)
//	@Pattern(regexp = "[a-zA-Z]*")
	public String password;

//	@NotNull(message = "{label.sex}")
	public String sex;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
