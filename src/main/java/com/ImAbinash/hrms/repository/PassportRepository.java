package com.ImAbinash.hrms.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ImAbinash.hrms.model.Passport;

@Repository
@Transactional
public class PassportRepository {

	@PersistenceContext
	EntityManager em;

	public String savePassport(Passport passport) {
		try {
			Passport passportResp = em.merge(passport);
			return "success";
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return null;
	}
	
	public Passport findById(int id) {
		Passport passport = em.find(Passport.class, id);
		return passport;
	}


	public Passport updatePassportById(Passport passport) {
		 Query passportNamedQuery = em.createNamedQuery("update_passport_by_id");
		 passportNamedQuery.setParameter("pNo", passport.getPassportNumber());
		 passportNamedQuery.setParameter("pImage", passport.getPassportImage());
		 passportNamedQuery.setParameter("pUdate", passport.getUpdatedDate());
		 passportNamedQuery.setParameter("id", passport.getId());
		 
		 int result = passportNamedQuery.executeUpdate();
		 
		 if(result==1) {
			 return findById(passport.getId());
		 }
		 return null;
		
	}
	
	
	
}
