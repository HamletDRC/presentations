@groovy.transform.TupleConstructor
class Person {
    String first, last
}

def p1 = new Person('John', 'Doe')
def p2 = new Person('John')
