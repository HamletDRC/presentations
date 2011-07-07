package ej02_builders

import domain.Person
import domain.PersonBuilder

Person p = new PersonBuilder().
        withID(1).
        withFirstName("David").
        withLastName("Villa").
        build();

System.out.println(p);

