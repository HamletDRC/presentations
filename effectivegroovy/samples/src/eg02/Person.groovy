package eg02

class Person {
    int id
    String firstName
    String lastName
    static findAll() {[new Person(id: 1), new Person(id: 2), new Person(id: 3)]}
}
