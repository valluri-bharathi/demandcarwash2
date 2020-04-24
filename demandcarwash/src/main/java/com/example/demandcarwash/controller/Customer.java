package com.example.demandcarwash.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demandcarwash.entity.CustCarDetails;
import com.example.demandcarwash.entity.CustomerDetails;
import com.example.demandcarwash.exception.ProgramException;
import com.example.demandcarwash.service.CustomerService;


@RestController
@RequestMapping(value = "/login")
public class Customer {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
	public String checkUser(@RequestBody CustomerDetails customer) throws ProgramException {
		String uName = customer.getUserName();

		try {
			customerService.login(customer);
		} catch (Exception e) {
			throw new ProgramException("Error Occurred");
		}
		return "Logged In Successfully";
	}

@RequestMapping(value = "/details", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
public String addDetails(@RequestBody CustCarDetails details) throws ProgramException {

	try {
		
		customerService.addDetails(details);
	}
	catch(Exception e) {
		throw new ProgramException("please try again");
	}
	return "Added Successfully";
	
}

@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
public String addUser(@RequestBody CustomerDetails customer) throws ProgramException {

	CustomerDetails newUser;
	try {
		 newUser = customerService.register(customer);
	} catch (Exception e) {
		throw new ProgramException("User Already Exists");
	}
	return newUser +" Registered Successfully";
}

}
