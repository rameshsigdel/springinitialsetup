/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa.service;

/**
 *
 * @author rames
 */
public class UserLogin {
      public String userName;
    public String password;
    
    public UserLogin(){
    userName="admin";
    password="test123";
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
       
}
