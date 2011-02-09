package eg02

import groovy.transform.ToString

@ToString
class Person {
    int id
    String firstName
    String lastName
    static findAll() {[
            new Person(id: 1, firstName: 'Chuck', lastName: 'Buck'),
            new Person(id: 2, firstName: 'Mario', lastName: 'Plumber'),
            new Person(id: 3, firstName: 'Joe', lastName: 'Buck')]}
}
