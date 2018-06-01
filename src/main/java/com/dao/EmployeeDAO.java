package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.EmployeeDetailsEntity;
import com.model.EmployeeDetails;

@Repository
public class EmployeeDAO {

	@Autowired
	PasswordEncoder encoder;
	
	@PersistenceContext
	EntityManager em;

	@Transactional
	public void saveEmploeeDetails(EmployeeDetails empDetalis)
	{
		EmployeeDetailsEntity detailsEntity = new EmployeeDetailsEntity();
		detailsEntity.setEnabled(0);
		detailsEntity.setEmp_id(empDetalis.getEmp_id());
		detailsEntity.setFirst_name(empDetalis.getFirst_name());
		detailsEntity.setLast_name(empDetalis.getLast_name());
		detailsEntity.setIbm_mail_id(empDetalis.getIbm_mail_id());
		detailsEntity.setPh_number(empDetalis.getPh_number());
		detailsEntity.setPassword(encoder.encode(empDetalis.getPassword()));
		
		em.persist(detailsEntity);
	}
	

}
