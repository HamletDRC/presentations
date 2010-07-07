package domain; 

public class UserDTO {
	private String firstName; 
	private String lastName; 
	public UserDTO(String firstName, String lastName) {
		this.firstName = firstName; 
		this.lastName = lastName; 
	}
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
}

