package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendor")
public class VendorController {

	public VendorController() {
		System.out.println("in constructor of " +getClass().getName());
	}
	
	//add a request handling method to forward the client to vendor details
	@GetMapping("/details")
	public String showVendorDetails() {
		System.out.println("in show vendor details");
		return "/vendor/details";
	}
}
