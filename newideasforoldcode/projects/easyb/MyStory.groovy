
scenario "testing a simple user service", {

	scenario "testing service with 0 users", {
		
		given "a zero user service",  {
			service = new UserService()
		}
		
		scenario "cannot remove a user", {
			 then "removing users triggers exception", {
				 ensureThrows(IllegalStateException) {
					 service.removeUser(0)
				 }
			 }
		}

		scenario "can add a user", {			
			given "a user", {
				user = ["August", "Schells"]
			}
			
			scenario "adding a user once", {
				when "he is added", {
					service.addUser(*user)		
				}
				then "user count is 1", {
					service.userCount.shouldBe 1	
				}
			}
			
			scenario "adding the same user twice", {
				when "he is added again", {
					service.addUser(*user)		
				}
				then "count is 2", {
					service.userCount.shouldBe 2	
				}
			}
		}
	}
	
	scenario "testing a service with 10 users", {

		given "a 10 user service",  {
			service = new UserService()
			(1..10).each {
				service.addUser("fname$it", "lname$it")	
			}
		}

		scenario "can remove a user", {
			when "user is removed", {
				service.removeUser(0)	
			}
			then "count is decremented", {
				service.userCount.shouldBe 9	
			}
		}

		scenario "can remove all users", {
			when "user is removed", {
				service.removeAllUsers()	
			}
			then "count remove all users", {
				service.userCount.shouldBe 0	
			}
		}
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
