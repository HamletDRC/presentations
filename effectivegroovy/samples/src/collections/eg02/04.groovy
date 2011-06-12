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

// group by is another
frequencies = people.groupBy { it.lastName }
println frequencies

println 'Success'




// inject is one way
int charCount = 0;
for (Person p : people) {
    charCount += p.getLastName().length();
}
println charCount

charCount = people.inject(0) { acc, p ->
    acc+= p.lastName.length()
    acc
}
println charCount

