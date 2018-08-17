package com.jda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jda.model.UserModel;
import com.jda.services.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/registration")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView("registration");
		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView getRegisterUserModel(@ModelAttribute("user") UserModel user) {
		if (userService.registerUser(user))
			return new ModelAndView("login");
		return null;
	}

	@RequestMapping("/login")
	public ModelAndView getUserModel(@ModelAttribute("User") UserModel user) {
		UserModel dbUser=userService.loginUser(user);
		if(dbUser!=null){
			System.out.println("djfhdjf");
			ModelAndView mv=new ModelAndView("home");
			 mv.addObject("name",dbUser.getName());
		return mv;
		}
		return null;
	}

	@RequestMapping("/forgot")
	public ModelAndView forgotPassword() {
		return new ModelAndView("forgotpswd");
	}

}
