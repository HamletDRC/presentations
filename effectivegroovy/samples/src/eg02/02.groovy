import eg02.Person

List<Person> people = Person.findAll();

Person joe = null;
for (Person p : people) {
    if ("Joe".equals(p.getFirstName())) {
        joe = p;
        break;
    }
}
println joe

joe = people.find { it.firstName == 'Joe' }
println joe

println 'Success'


