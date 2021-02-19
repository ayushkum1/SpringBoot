 package com.app.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Role;
import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IVendorService vendorService;
	
	public UserController() {
		System.out.println("in User Controller constructor " + " " + vendorService);
	}
	
	@PostConstruct
	public void anyInit() {
		System.out.println("in init of " + getClass().getName() + " " + vendorService);
	}
	
	//add a request handling method for providing the login form
	@GetMapping("/login")
	//key : /user/login : method = get
	//value:com.app.controller.showLoginForm
	public String showLoginFrom() {
		System.out.println("in show login form");
		
		return "/user/login";//actual view name for the page : /WEB-INF/views/user/login.jsp
//		return "user/login123";//actual view name for the page : /WEB-INF/views/user/login123.jsp
	}
	
	//add a request handling method for processing the form
	@PostMapping("/login")
	//key : /user/login : method = post
	//value:com.app.controller.processLoginForm
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model modelMap, HttpSession session) {
		
		System.out.println("in processLoginForm() with email " + email + " password " + password);
		try {
			System.out.println("in try");
			Vendor user = vendorService.authenticateUser(email, password);
	
			//if valid login, save user details under a session scope
			session.setAttribute("user_details", user);
//			System.out.println(session.getAttribute("user_details"));
			session.setAttribute("message", user.getUserRole() + ", " + user.getName() + " has logged in successfully");
			
			if(user.getUserRole().equals(Role.ADMIN)) {
				return "redirect:/admin/list";
			}
			
			if(user.getUserRole().equals(Role.VENDOR)) {
				return "redirect:/vendor/details ";
			}
			
		}catch (RuntimeException e) {
			System.out.println("error in authentication " + e);
			//add error message in 
			e.printStackTrace();
			modelMap.addAttribute("message", "Invalid Login pls retry again!!!");
			
			return "/user/login"; //redirect to login page if exception occured
		}
		
		return "/vendor/details";
	}
	
	//add request handling method for users logout
	@GetMapping("/logout")
	public String userLogout(HttpSession session, Model modelMap, HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("in User Logout");
		
		//get user details from session scope and add it to model map
		modelMap.addAttribute("details", session.getAttribute("user_details"));
		//invalidate session
		session.invalidate();
		
		//set refresh header to navigate client to home page(index.jsp) after sometime(10sec)
		response.setHeader("refresh", "5;url="+request.getContextPath());
		
		return "/user/logout";
	}
}
