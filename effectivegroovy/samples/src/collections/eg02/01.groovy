import domain.Person

List<Person> people = Person.findAll();

List<Integer> ids = new ArrayList<Integer>();
for (Person p : people) {
    ids.add(p.getId());
}

def ids1 = people.collect { it.id }


def ids2 = people*.id      // found by CodeNarc

println ids
println ids1
println ids2
println 'Success'


