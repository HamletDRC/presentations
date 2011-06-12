package ej02

import domain.Person

def p = new Person(1, '', '').with {
    id = 1
    firstName = 'David'
    lastName = 'Villa'
    delegate
}

assert (p instanceof Person)
println p

//The groovy notation "def p = new Person().with { id = 5 }" does work in Groovy 1.9