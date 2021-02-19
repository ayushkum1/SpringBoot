package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Role;
import com.app.pojos.Vendor;

@Repository //to tell spring container about dao layer bean and enables exception translation mechanism(catches db related exceptions and re throw 
//them as spring related unchecked exceptions)
public class VendorDaoImpl implements IVendorDao {

	@Autowired //by type
	private EntityManager mgr;
	
	@Override
	public Vendor authenticateUser(String email, String password) {
		System.out.println("in vendor dao impl");
		String jpql = "select v from Vendor v where v.email=:email and v.password=:password";
//		System.out.println("in VendorDaoImpl " + sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("email", email).setParameter("password", password).getSingleResult());
		return mgr.createQuery(jpql, Vendor.class).setParameter("email", email)
				.setParameter("password", password).getSingleResult();
	}

	@Override
	public List<Vendor> fetchAllVendorList() {
		
		String jpql = "select v from Vendor v where v.userRole=:role";
		
		return mgr.createQuery(jpql, Vendor.class).setParameter("role", Role.VENDOR).getResultList();
	}

	@Override
	public Vendor getVendorDetail(int vendorId) {
		return mgr.find(Vendor.class, vendorId);
	}

	@Override
	public String deleteVendorDetails(Vendor persistentVendor) {
	
		//since there exists one-to-one uni directional asociation between vendor and location, can not delete a parent record without deleting a child record
//		mgr.remove(mgr.find(Location.class, persistentVendor.getId()));
		
		mgr.remove(persistentVendor);
		
		return "Vendor deleted : " + persistentVendor.getName();
	}

	@Override
	public String registerVendor(Vendor transientVendor) {
		mgr.persist(transientVendor);
		return "Vendor registered successfully with id " + transientVendor.getId();
	}

}