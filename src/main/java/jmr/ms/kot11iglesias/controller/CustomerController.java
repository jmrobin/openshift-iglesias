package jmr.ms.kot11iglesias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jmr.ms.kot11iglesias.domain.Customer;
import jmr.ms.kot11iglesias.service.CustomerService;

@RestController
public class CustomerController
{
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getAll()
	{
		return customerService.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getById(@PathVariable Long id)
	{
		return customerService.findById(id);
	}
}
