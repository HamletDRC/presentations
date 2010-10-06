package leangroovy.eliminatewaste


class SimpleUnitTests extends GroovyTestCase {

    public void testSimpleMath() {
        [4: { 2 + 2},
                6: { 2 + 2 + 2},
                8: { 2 + 2 + 2 + 2},
        ].each { expected, actual ->
            assert expected == actual()
        }
    }

    public void testUserService() {
        def userService = new UserService()

        [
                user1: ['John', 'Doe', 123456],
                user2: ['Jane', 'Doe', 654321],
                user3: ['John', 'Smith', 789987],

        ].each { username, userData ->
            def user = userService.get(username)
            assert user.firstName == userData[0]
            assert user.lastName == userData[1]
            assert user.id == userData[2]
        }
    }
}
