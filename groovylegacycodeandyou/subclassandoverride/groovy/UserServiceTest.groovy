package groovy

import groovy.mock.interceptor.*
import domain.*

class UserServiceTest extends GroovyTestCase {

	public void testCreate() {
		
		def userMock = new MockFor(User)
		userMock.demand.setFirstName { assert it == 'Michael' }
		userMock.demand.setLastName { assert it == 'Jackson' }
		userMock.demand.save { }

		userMock.use {
		    def service = new UserService()
		    service.create(new UserDTO('Michael', 'Jackson'))
		}
	}
}
