package com.example.demandcarwash.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demandcarwash.entity.CustCarDetails;
import com.example.demandcarwash.entity.CustomerDetails;
import com.example.demandcarwash.exception.ProgramException;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private MongoTemplate mongoTemplate;
	Query query = new Query();

	@Override
	public boolean findUser(CustomerDetails user) throws ProgramException {

		String uName = user.getUserName();
		String pwd = user.getPassword();
		try {
			
			query = query.addCriteria(Criteria.where("userName").is(uName).andOperator(Criteria.where("password").is(pwd)));

			boolean dataExists = mongoTemplate.exists(query, "custdetails");
			if (dataExists) {
				return true;
			}
		} catch (Exception e) {
			throw new ProgramException("reposit error");
		}
		return false;

	}

	@Override
	public boolean addDetails(CustCarDetails details) throws ProgramException {
		
		try {
			CustCarDetails dataExists = mongoTemplate.insert(details, "custCarDetails");
	
			if(dataExists!=null) {
				return true;
			}
		}catch(Exception e) {
			throw new ProgramException("error occurred");
		}
		return false;
	}
	@Override
	public CustomerDetails addUser(CustomerDetails customer) throws ProgramException {

		String uName = customer.getUserName();
		String pwd = customer.getPassword();
		CustomerDetails addedUser;
		try {

			query = query.addCriteria(Criteria.where("userName").is(uName));
			boolean dataExists = mongoTemplate.exists(query, "customerDetails");

			if (!dataExists) {
				addedUser = mongoTemplate.insert(customer, "customerDetails");
			} else {
				throw new ProgramException("User Already Exists");
			}
		} catch (Exception e) {
			throw new ProgramException("reposit error");
		}
		return addedUser;
	}

}



