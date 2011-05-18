package eg02

import domain.Person

List<Person> people = Person.findAll();

boolean found = false;
for (Person p : people) {
    if ("Joe".equals(p.getFirstName())) {
        found = true;
        break;
    };
}
System.out.println("Joe Found: " + found);



assert people.any { it.firstName == 'Joe' }

println people.any { it.firstName == 'Joe' }