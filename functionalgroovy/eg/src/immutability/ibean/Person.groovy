package immutability.ibean

class Person {

    private final def firstName
    private final def lastName

    Person() { }

    Person(firstName, lastName) {
        this.firstName = firstName
        this.lastName = lastName
    }
    
    def setFirstName(firstName) {
        new Person(firstName, lastName)
    }

    def setLastName(lastName) {
        new Person(firstName, lastName)
    }
}
