package com.example.demandcarwash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demandcarwash.dao.CustomerDao;
import com.example.demandcarwash.entity.CustCarDetails;
import com.example.demandcarwash.entity.CustomerDetails;
import com.example.demandcarwash.exception.ProgramException;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	
	private CustomerDao custDao;

	public void setLoginDao(CustomerDao custDao) {
		this.custDao = custDao;
	}

	@Override
	public boolean login(CustomerDetails custDetails) throws ProgramException {

		boolean result = custDao.findUser(custDetails);
		if (!result) {
			throw new ProgramException("error");
		}
		return true;

	}

	@Override
	public boolean addDetails(CustCarDetails details) throws ProgramException {
		
		boolean result =  custDao.addDetails(details);
		
		return result;
	}
	@Override
	public CustomerDetails register(CustomerDetails customer) throws ProgramException {
		
		CustomerDetails addUser = custDao.addUser(customer);
		return addUser;
	}

}



