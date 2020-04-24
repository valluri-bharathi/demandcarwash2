package com.example.demandcarwash.dao;

import com.example.demandcarwash.entity.CustCarDetails;
import com.example.demandcarwash.entity.CustomerDetails;
import com.example.demandcarwash.exception.ProgramException;

public interface CustomerDao {
	
	public boolean findUser(CustomerDetails customer) throws ProgramException;
	public boolean addDetails(CustCarDetails details) throws ProgramException;
	public CustomerDetails addUser(CustomerDetails customer) throws ProgramException;
}