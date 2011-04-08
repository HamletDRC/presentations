package javaexample; 

import org.junit.Test;
import org.junit.Assert;
import javaexample.UserService; 
import domain.*;

public class UserServiceTest {	

	@Test
	public void testCreate() {
		MockUser mockUser = new MockUser(); 
		UserService service = new TestingUserService(mockUser); 
		service.create(new UserDTO("Michael", "Jackson")); 
		Assert.assertTrue(mockUser.saveWasCalled); 
		Assert.assertEquals("Michael", mockUser.getFirstName()); 
		Assert.assertEquals("Jackson", mockUser.getLastName()); 
	}
	
	private static class TestingUserService extends UserService {
		private User user; 
		
		TestingUserService(User user) {
			this.user = user; 	
		}
		@Override
		public User makeUser() {
			return user; 
		}
	}
	
	private static class MockUser extends User {
		private boolean saveWasCalled = false; 
		
		MockUser() { 
			super(null); 
		}
		
		@Override	
		public void save() {
			saveWasCalled = true; 
		}
	}
}
