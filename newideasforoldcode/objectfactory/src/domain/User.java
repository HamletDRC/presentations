package domain; 

public class User {
	private String firstName; 
	private String lastName; 

	public User(DataSource ds) {}
	public void setFirstName(String firstName) {
		this.firstName = firstName; 
	}
	public void setLastName(String lastName) {
		this.lastName = lastName; 
	}
	public void save() {
        System.out.println("save called: " + firstName + " " + lastName);
    }
    
	public String getFirstName() { return firstName; } 
	public String getLastName() { return lastName; } 
}

