package leangroovy.eliminatewaste


class UserService {

    def dummyData = [
            user1: ['John', 'Doe', 123456],
            user2: ['Jane', 'Doe', 654321],
            user3: ['John', 'Smith', 789987],
    ]

    def get(username) {

        def data = dummyData.get (username)
        new User(firstName: data[0], lastName: data[1], id: data[2])
    }
}

class User {
    def firstName
    def lastName
    def id
}