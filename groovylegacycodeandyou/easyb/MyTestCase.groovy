
public class SimpleServiceTest extends GroovyTestCase {

	def emptyService
	def populatedService
	def user
	
	@Override
	protected void setUp() {
		emptyService = new UserService()
		populatedService = new UserService()
		(1..10).each {
			populatedService.addUser("fname$it", "lname$it")	
		}
		user = ["August", "Schells"]
	}
	
	public void testUserService_0Users_CannotRemove() {
		shouldFail(IllegalStateException) {
			emptyService.removeUser(1)	
		}
	}

	public void testUserService_0Users_AddOneUser() {
		emptyService.addUser(*user)		
		assertEquals(1, emptyService.userCount)	
	}

	public void testUserService_0Users_AddOneUserTwice() {
		emptyService.addUser(*user)		
		emptyService.addUser(*user)		
		assertEquals(2, emptyService.userCount)	
	}
	
	public void testUserService_10Users_CanRemoveUser() {
		populatedService.removeUser(0)	
		assertEquals(9, populatedService.userCount)	
	}
	
	public void testUserService_10Users_CanRemoveAllUsers() {
		populatedService.removeAllUsers()	
		assertEquals(0, populatedService.userCount)	
	}
	
}

public class UserService {
	
	private Map users  = [:]
	
	def addUser(firstname, lastname) {
		users.put(users.size(), [firstname, lastname])	
	}
	def getUserCount() {
		users.size()	
	}
	def removeAllUsers() { 
		users.clear()
	}
	def removeUser(id) {
		if (!users.containsKey(id)) {
			throw new IllegalStateException()
		}
		users.remove(id)
	}
}
