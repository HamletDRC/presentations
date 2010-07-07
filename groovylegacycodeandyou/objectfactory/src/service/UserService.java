package service;

import domain.UserDTO; 
import domain.User;
import domain.DataSource;
import factory.ObjectFactory;

public class UserService {

	private ObjectFactory factory;

    public UserService(ObjectFactory factory) {
        this.factory = factory;
    }

    public void create(UserDTO input) {
		User user = factory.make(User.class); 
		user.setFirstName(input.getFirstName());
		user.setLastName(input.getLastName());
		user.save();
	}
}



