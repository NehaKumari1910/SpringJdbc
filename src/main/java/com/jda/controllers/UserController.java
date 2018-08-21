package com.jda.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jda.model.UserModel;
import com.jda.services.IUserService;
import com.jda.utility.MailService;

@Controller
public class UserController{

	@Autowired
	private IUserService userService;

	


	
	@RequestMapping("/")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

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
//			mailService.sendSimpleMessage();
			ModelAndView mv=new ModelAndView("home");
			 mv.addObject("name",dbUser.getName());
		return mv;
		}
		return null;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(){
			return new ModelAndView("login");
	}
	

	@RequestMapping("/forgotpasswordform")
	public ModelAndView forgotPasswordForm() {
		return new ModelAndView("forgotpswd");
	}
	
	@RequestMapping(value="/forgotpassword",method=RequestMethod.POST)
	public ModelAndView forgotPassword(@ModelAttribute("user") UserModel userModel,HttpServletRequest request) {
		//System.out.println(userModel.getEmail());
		String url=request.getRequestURL().toString();
		userService.forgotPassword(userModel.getEmail(),url);
		return new ModelAndView("forgotpswd");
	}
	
	@RequestMapping(value="/resetpasswordform",method=RequestMethod.GET)
	public ModelAndView resetPasswordForm(@RequestParam("uuid") String uuid) {
		return new ModelAndView("resetpswd");
	}

	@RequestMapping(value="/resetpassword",method=RequestMethod.POST)
	public ModelAndView resetPasswordForm(@ModelAttribute("User") UserModel userModel,HttpServletRequest request) {
		String header=request.getHeader("Referer");
		if(userService.update(header,userModel))
		{
			return new ModelAndView("login");
		}
		else
		{
			return new ModelAndView("resetpswd");
		}
	}
		
	}
	

