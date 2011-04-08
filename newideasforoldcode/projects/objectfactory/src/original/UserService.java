package original;

import domain.UserDTO;
import domain.User;
import domain.DataSource;

public class UserService {

	private DataSource datasource;

	public void create(UserDTO input) {
		User user = new User(datasource);
		user.setFirstName(input.getFirstName());
		user.setLastName(input.getLastName());
		user.save();
	}
}



