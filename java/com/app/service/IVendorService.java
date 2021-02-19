package com.app.service;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorService {

	Vendor authenticateUser(String email, String password);
	
	List<Vendor> fetchAllVendorList();
	
	String deleteVendorDetails(int vendorId);
	
	String registerVendor(Vendor transientVendor);
}
