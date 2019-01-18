package jmr.ms.kot11iglesias.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import jmr.ms.kot11iglesias.domain.Customer;
import jmr.ms.kot11iglesias.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTests
{
	@Autowired
	private MockMvc mvc;

	@MockBean
	private CustomerService service;
	
	Customer[] customers = {new Customer(1L, "Anna"), new Customer(2L, "Bernard")};

	@Test
	public void getByIdTest() throws Exception
	{
		// given
		given(service.findById(1L)).willReturn(new Customer(1L, "aAbc"));

		// when
		mvc.perform(get("/customers/1"))
			.andExpect(jsonPath("$.id").value(1))
			.andExpect(jsonPath("$.name").value("aAbc"));
	}
	
	@Test
	public void getAllTest() throws Exception
	{
		// given
		given(service.findAll()).willReturn(Stream.of(customers).collect(Collectors.toList()));

		// when		
		mvc.perform(get("/customers"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].id").value(1))
			.andExpect(jsonPath("$[1].name").value("Bernard"));
	}
}
