package zeePizza;

public class customerPojo {
	
	private String firstName;
	private String lastName;
	private String address;
	private int locationID;
	private String phone;
	private String password;
	private String email;
	
	
	//default constuctor 
	public customerPojo()
	{
		firstName = "";
		lastName = "";
		address = "";
		locationID = 0;	
		phone = "";
		password = "";
		email = "";
        
		
	}
	public customerPojo(String firstName, String lastName, String address, int locationID, String phone, String password, String email)
	{
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setLocationID(locationID);
		setPhone(phone);
		setPassword(password);
		setEmail(email);
		
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
