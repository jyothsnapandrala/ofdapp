package com.project.onlinefooddelivery.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onlinefooddelivery.entity.Address;
import com.project.onlinefooddelivery.entity.Customer;
import com.project.onlinefooddelivery.exception.AddressNotFoundException;
import com.project.onlinefooddelivery.repo.AddressRepo;
import com.project.onlinefooddelivery.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired

	 CustomerRepo customerRepo;

	@Autowired
	AddressRepo  addressRepo;
	
	public Customer createCustomer(Customer customer) {
		Address address=customer.getAddress();
		int addressId=address.getAddressId();
		if(addressId>0)
		{
			Optional<Address> addressContainer = addressRepo.findById(addressId);
			if(addressContainer.isPresent())
			{
				customer.setAddress(addressContainer.get());
			}
			else {
				throw new AddressNotFoundException("Address is not found");
			}
		}
		
		return  customerRepo.save(customer);
		}

	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteAllCustomer() {
		// TODO Auto-generated method stub
		try {

			 customerRepo.deleteAll();

			 }catch(Exception e) {
		return false;
			 }
		return true;
	}

	public String deleteById(int id) {
		// TODO Auto-generated method stub
		 Optional<Customer> custContainer =  customerRepo.findById(id);
		 if(custContainer.isPresent()) {

			 Customer oldObj = custContainer.get();

			 customerRepo.delete(oldObj);

			 return "Deleted Successfully!!!";

			 }else {

			 return "The specified id is not present in the DB :"+id;

			}

			
		
	}

	public Customer updateCustomer(int id, Customer obj) {
		 Optional<Customer> custContainer=customerRepo.findById(id);

		   if(custContainer.isPresent()) {
			   
			   Customer oldObj=custContainer.get();
				oldObj.setEmail(obj.getEmail());
				System.out.println("Succesfully updated!!!!");
				return customerRepo.saveAndFlush(oldObj);
			}
			else {
				System.out.println("Succesfully Inserted");
				return customerRepo.save(obj);
			}

		   //return custContainer.get();

		   //}else {

		  // return null; 

		   //}
	}
}


