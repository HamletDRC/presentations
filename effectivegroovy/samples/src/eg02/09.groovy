package eg02

List<Person> people = Person.findAll();

boolean found = false;
for (Person p : people) {
    if ("Joe".equals(p.getFirstName())) {
        found = true;
        break;
    };
}
System.out.println("Joe Found: " + found);





println people.any { it.firstName == 'Joe' }