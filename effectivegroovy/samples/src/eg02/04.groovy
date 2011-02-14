import domain.Person

List<Person> people = Person.findAll();

Map<String, List<Person>> frequencies = new HashMap<String, List<Person>>();
for (Person p : people) {
    if (frequencies.containsKey(p.getLastName())) {
        frequencies.get(p.getLastName()).add(p)
    } else {
        frequencies.put(p.getLastName(), [p])
    }
}
println frequencies

frequencies = people.inject([:]) { acc, p ->
    acc[p.lastName] ? acc[p.lastName].add(p) : (acc[p.lastName] = [p])
    acc
}

println frequencies

println 'Success'


