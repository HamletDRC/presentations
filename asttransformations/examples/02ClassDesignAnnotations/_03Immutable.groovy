@groovy.transform.Immutable
class Person {
    String firstName, lastName
}

new Person(firstName: 'Dierk', lastName: 'Koenig')
def p = new Person('Hamlet', "D'Arcy")
assert p.firstName == 'Hamlet'
