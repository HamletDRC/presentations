@groovy.transform.ToString
class Person {
    String first, last
}

def p = new Person(first:'John', last:'Doe')
assert p.toString() == 'Person(John, Doe)'
