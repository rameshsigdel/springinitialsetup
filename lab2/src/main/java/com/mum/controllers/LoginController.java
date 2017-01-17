package com.mum.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mum.model.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author rames
 */
@Controller
public class LoginController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model) {

		return "login";
	}

	@RequestMapping(value = "/LoginServlet", method = RequestMethod.POST)
	public String loginAuthenticate(Model model, @ModelAttribute("") UserLogin userlogin) {
		String result = null;
		try {
			
			if ("admin".equals(userlogin.userName) && "test123".equals(userlogin.password)) {
				model.addAttribute("name", userlogin.userName);
				model.addAttribute("password", userlogin.password);
				result = "welcome";
			} else {
				model.addAttribute("failure", "Enter Username/Password correct");
				result = "login";

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
