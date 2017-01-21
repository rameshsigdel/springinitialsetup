package com.waa.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.waa.domain.User;
import com.waa.service.UserService;

@Controller
@SessionAttributes("userInfo")
public class LoginCotroller {
	@Autowired
	UserService userService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String getLoginForm(Model model, HttpSession session, HttpServletRequest request) {
		User newUser = checkCookie(request);
		if (newUser != null) {
			model.addAttribute("checked", "checked");
			model.addAttribute("userName", newUser.getUserName());
		}

		return "login";
	}

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String getLoginForm1(Model model, HttpSession session,
	// HttpServletRequest request) {
	// User newUser = checkCookie(request);
	// if (newUser != null) {
	// model.addAttribute("checked", "checked");
	// model.addAttribute("userName", newUser.getUserName());
	// }
	//
	// return "login";
	// }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticate(@ModelAttribute("user") User user, Model model, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {

		if (userService.authenticate(user)) {

			if (request.getParameter("rememberme") != null) {
				
				System.out.println("Inside remember");
				
				Cookie chkUsername = new Cookie("userName", user.getUserName());
				chkUsername.setMaxAge(30 * 24 * 60 * 60);
				response.addCookie(chkUsername);

				Cookie chkPassword = new Cookie("password", user.getPassword());
				chkPassword.setMaxAge(30 * 24 * 60 * 60);
				response.addCookie(chkPassword);

			} else {
				for (Cookie chk : request.getCookies()) {
					if (chk.getName().equalsIgnoreCase("userName")) {
						chk.setMaxAge(0);
						response.addCookie(chk);
					}
				}
			}

			session.setAttribute("userInfo", user);
			return "redirect:/welcome";
		} else {
			model.addAttribute("err_msg", "username and/or passord invlaid.");
			return "login";
		}
	}

	public User checkCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		User user = null;
		String username = "", password = "";

		for (Cookie chk : cookies) {
			if (chk.getName().equalsIgnoreCase("userName")) {
				username = chk.getValue();
			}
			if (chk.getName().equalsIgnoreCase("password")) {
				password = chk.getValue();
			}
			if (!username.isEmpty() && !password.isEmpty()) {
				user = new User();
				user.setUserName(username);
				user.setPassword(password);
			}
		}

		return user;

	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String getWelcomePage() {
		return "welcome";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {

		status.setComplete();
		//session.removeAttribute("userInfo");
		session.invalidate();
		return "redirect:/";
	}

}
