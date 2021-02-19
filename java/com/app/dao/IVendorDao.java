package com.app.dao;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorDao {
	
	Vendor authenticateUser(String email, String password);
	
	List<Vendor> fetchAllVendorList();
	
	//add method to get vendor details by id
	Vendor getVendorDetail(int vendorId);
	
	//method to delete vendor details
	String deleteVendorDetails(Vendor persistentVendor);
	
	//register vendor
	String registerVendor(Vendor transientVendor);
}
