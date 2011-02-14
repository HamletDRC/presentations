package domain


import groovy.transform.ToString

class Person {
    int id
    String firstName
    String lastName

    Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    static findAll() {[
            new Person(id: 1, firstName: 'Chuck', lastName: 'Buck'),
            new Person(id: 2, firstName: 'Mario', lastName: 'Plumber'),
            new Person(id: 3, firstName: 'Joe', lastName: 'Buck')]}
}
