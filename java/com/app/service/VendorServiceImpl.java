package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.pojos.Role;
import com.app.pojos.Vendor;

@Service // to tell SC class os a spring bean containing business logic
@Transactional //to tell spring container to automate transaction manager, by spring supplied hibernate transaction management
public class VendorServiceImpl implements IVendorService {

	@Autowired
	//dependency : DAO layer(vendor dao)
	private IVendorDao vendorDao;
	
	
	@Override
	public Vendor authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println("in vendor service implementation " + email + " " + password);
		return vendorDao.authenticateUser(email, password);
	}


	@Override
	public List<Vendor> fetchAllVendorList() {
		// TODO Auto-generated method stub
		return vendorDao.fetchAllVendorList();
	}


	@Override
	public String deleteVendorDetails(int vendorId) {
		
		Vendor vendor = vendorDao.getVendorDetail(vendorId);
		if(vendor != null) {
			return vendorDao.deleteVendorDetails(vendor);
		}else {
			return "Vendor details deletion failed";
		}
	}


	@Override
	public String registerVendor(Vendor transientVendor) {
		
		transientVendor.setUserRole(Role.VENDOR);
		
		return vendorDao.registerVendor(transientVendor);
	}

}
