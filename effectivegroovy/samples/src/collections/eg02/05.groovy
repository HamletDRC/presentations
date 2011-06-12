import domain.Person

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

assert people != familyReps
familyReps = people.unique() { it.lastName }

println familyReps
assert people == familyReps  // OH NOES, mutation! 


// sort display the same error
def unsortedList = [2, 3, 1]
def sortedList = unsortedList.sort()
assert sortedList == [1, 2, 3]
assert unsortedList == [1, 2, 3]

println 'Success'

