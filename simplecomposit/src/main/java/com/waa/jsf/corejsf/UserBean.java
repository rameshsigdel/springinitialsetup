package com.waa.jsf.corejsf;

import java.io.Serializable;
import javax.inject.Named;
// or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
// or import javax.faces.bean.SessionScoped;

@Named("user") // or @ManagedBean(name="user")
@SessionScoped
public class UserBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;

	public UserBean() {
		this("", "");
	}
	public UserBean(String name, String password) {
	      this.name = name;
	      this.password = password;
	   }
	public String getName() {
		return name;
	}

	public void setName(String newValue) {
		name = newValue;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String newValue) {
		password = newValue;
	}
	
	public String login(){
		return "welcome" + "?faces-redirect=true";
	}
	
	public String logout(){
		name ="";
		password="";
		return "index";
	}
}
