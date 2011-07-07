package ej02_builders

import domain.Person

def p = new Person(1, '', '')
p.with {
    id = 1
    firstName = 'David'
    lastName = 'Villa'
}

assert (p instanceof Person)
println p.dump()

//The groovy notation "def p = new Person().with { id = 5 }" does work in Groovy 1.9