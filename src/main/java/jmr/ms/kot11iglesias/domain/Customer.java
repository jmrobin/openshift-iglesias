package jmr.ms.kot11iglesias.domain;

public class Customer
{
	private Long id;
	private String name;
	
	public Customer(Long id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}
	
	public Customer(String name)
	{
		this(null, name);
	}
	
	public Customer()
	{
		this(null);
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
