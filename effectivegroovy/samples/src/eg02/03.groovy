import domain.Person

List<Person> people = Person.findAll();

List<Person> bucks = new ArrayList<Person>();
for (Person p : people) {
    if ("Buck".equals(p.getLastName())) {
        bucks.add(p);
    }
}
println bucks

bucks = people.findAll { it.lastName == 'Buck' }
println bucks

println 'Success'


