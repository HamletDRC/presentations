package leangroovy.createknowledge

import leangroovy.eliminatewaste.UserService

class SpockUserTest {

    def """ does the user service contain
       a known set of users? """() {
  
        setup:
        def service = new UserService()

        expect:
        def user = service.get(username)
        user.firstName == firstname
        user.lastName == lastname
        user.id == userID

        where:
        username  <<  ['user1', 'user2', 'user3']
        firstname <<  ['John', 'Jane', 'John']
        lastname  <<  ['Doe', 'Doe', 'Smith']
        userID    <<  [123456, 654321, 789987]
    }

}
