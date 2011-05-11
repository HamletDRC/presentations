@groovy.transform.Immutable
class Person {
    String firstName, lastName
    final List myList
    final Date birthday
}

new Person(firstName: 'Dierk', lastName: 'Koenig')
def p = new Person('Hamlet', "D'Arcy")
assert p.firstName == 'Hamlet'