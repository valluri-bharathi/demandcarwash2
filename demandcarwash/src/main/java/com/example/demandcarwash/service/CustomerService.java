package com.example.demandcarwash.service;

import com.example.demandcarwash.entity.CustCarDetails;
import com.example.demandcarwash.entity.CustomerDetails;
import com.example.demandcarwash.exception.ProgramException;

public interface CustomerService {

	boolean login(CustomerDetails customer) throws ProgramException;
	boolean addDetails(CustCarDetails details) throws ProgramException;
	CustomerDetails register(CustomerDetails customer) throws ProgramException;


}
