package jmr.ms.kot11iglesias.service;

import java.util.ArrayList;
import java.util.List;

import jmr.ms.kot11iglesias.domain.Customer;

public class CustomerService
{
	private List<Customer> customers;
	
	public CustomerService()
	{
		customers = new ArrayList<>();
	}
	
	public Customer add(Customer customer)
	{
		customer.setId(customers.size() + 1L);
		customers.add(customer);
		return customer;
	}
	
	public Customer findById(Long id)
	{
		return customers
				.stream()
				.filter(c -> c.getId() == id)
				.findFirst()
				.orElse(null);
	}
	
	public List<Customer> findAll()
	{
		return new ArrayList<>(customers);
	}
}
