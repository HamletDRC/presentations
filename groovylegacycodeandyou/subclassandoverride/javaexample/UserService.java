package javaexample; 

import domain.UserDTO; 
import domain.User; 
import domain.DataSource; 

public class UserService {

	private DataSource datasource;
	
	public void create(UserDTO input) {
		User user = makeUser(); 
		user.setFirstName(input.getFirstName()); 
		user.setLastName(input.getLastName()); 
		user.save(); 
	}
	
	protected User makeUser() {
		return new User(datasource); 	
	}
}

