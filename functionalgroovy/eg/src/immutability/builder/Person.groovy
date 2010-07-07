package immutability.builder


class Person {
    private final def firstName
    private final def lastName

    Person(firstName, lastName) {
        this.firstName = firstName
        this.lastName = lastName
    }
}

class PersonBuilder {
    def firstName
    def lastName

    def build() {
        new Person(firstName, lastName)
    }

    def setFirstName(firstName) {
      this.firstName = firstName
      this
    }

    def setLastName(lastName) {
      this.lastName = lastName
      this
    }    
}
