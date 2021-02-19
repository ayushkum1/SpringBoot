package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.PaymentMode;
import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IVendorService vendorService;
	
	public AdminController() {
		System.out.println("in constructor of " + getClass().getName());
	}
	
	@GetMapping("/list")
	public String showVendorList(Model map){
		System.out.println("in show vendor list");
		
		map.addAttribute("vendor_list", vendorService.fetchAllVendorList());
		
		return "/admin/list";
	}
	
	@GetMapping("/delete")
	public String deleteVendor(@RequestParam int vid, RedirectAttributes flashMap) {
		System.out.println("in delete vendor details");
		
		//invoke service method
		//flashmap
		flashMap.addFlashAttribute("message", vendorService.deleteVendorDetails(vid));
		
		return "redirect:/admin/list";
	}
	
	//add request handling method to show registration form
	@GetMapping("/register")
	//Step 1 : 2 way data binding/ form data binding - add empty pojo instance(using default constructor in model map
	public String showRegisterForm(Model modelMap) {
		
		System.out.println("in showRegisterForm()");
		modelMap.addAttribute("vendor_details", new Vendor()); //empty pojo
		modelMap.addAttribute("payment_modes", PaymentMode.values());
		System.out.println(modelMap);
		return "/admin/register";
	}
	
	//add request method handler for processing the registration form
	@PostMapping("/register")
	public String processRegistrationForm(@ModelAttribute(name = "vendor_details") Vendor v, BindingResult result, RedirectAttributes flashMap) {
		System.out.println("in processRegistrationForm() of " + v);
		System.out.println("Payment Details " + v.getDetails());
		System.out.println("binding result " + result);
		
		flashMap.addFlashAttribute("message", vendorService.registerVendor(v));
		
		return "redirect:/admin/list";
	}
	
	//add request handling method to logout admin
	@GetMapping("/logout")
	public String logoutAdmin(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		
		
		session.invalidate();
		
		return "/";
	}
	
}
