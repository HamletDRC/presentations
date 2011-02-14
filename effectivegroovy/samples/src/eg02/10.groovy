package eg02

List<Person> people = Person.findAll();

boolean mismatch = true;
for (Person p : people) {
    if (p.getFirstName() == null) {
        mismatch = false;
        break;
    };
}
System.out.println("Everyone has first name? " + mismatch);





println "Everyone has first name? " + people.every { it.firstName }