package jmr.ms.kot11iglesias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jmr.ms.kot11iglesias.domain.Customer;
import jmr.ms.kot11iglesias.service.CustomerService;

@SpringBootApplication
public class Kot11IglesiasApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(Kot11IglesiasApplication.class, args);
	}
	
	@Bean
	CustomerService getCustomerService()
	{
		CustomerService cs = new CustomerService();
		cs.add(new Customer("Kotlin"));
		cs.add(new Customer("Spring"));
		cs.add(new Customer("Vertex"));
		cs.add(new Customer("Openshift"));
		return cs;
	}

}
