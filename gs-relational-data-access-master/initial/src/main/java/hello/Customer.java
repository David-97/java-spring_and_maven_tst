package hello;

public class Customer {
	private long id;
	private String Firstname, Lastname;
	
	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public Customer(long id, String Firstname, String Lastname)
	{
		this.setId(id);
		this.setFirstname(Firstname);
		this.setLastname(Lastname);
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
