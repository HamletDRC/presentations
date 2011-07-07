package ej08_namedarguments

import domain.Person

assert new Person(id: 1, firstName: 'John', lastName: 'Doe') ==
            new Person(id: 1, firstName: 'John', lastName: 'Doe')


println new Person(id: 1, firstName: 'John', lastName: 'Doe')