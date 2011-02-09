import eg02.Person

List<Person> people = Person.findAll();

List<Person> familyReps = new ArrayList<Person>();
List<String> seenFamilies = new ArrayList<String>();
for (Person p : people) {
    if (!seenFamilies.contains(p.getLastName())) {
        seenFamilies.add(p.getLastName());
        familyReps.add(p)
    } 
}
println familyReps

familyReps = people.unique() { it.lastName }

println familyReps

println 'Success'


