package ej02

import domain.Person
import domain.PersonBuilder

Person p = new PersonBuilder().
        withID(1).
        withFirstName("David").
        withLastName("Villa").
        build();

System.out.println(p);

