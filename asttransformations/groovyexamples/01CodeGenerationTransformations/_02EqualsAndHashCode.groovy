@groovy.transform.EqualsAndHashCode
class Person {
    String first, last
}

def p1 = new Person(first:'John', last: 'Doe')
def p2 = new Person(first:'John', last: 'Doe')
assert p1 == p2
