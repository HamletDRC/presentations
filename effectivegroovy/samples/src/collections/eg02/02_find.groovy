import domain.Person

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


// find result
def result = [1, 2, 3].findResult {
    it == 2 ? 'found it!' : null
}

assert result == 'found it!'
println result

// find results
def result2 = [1, '2', 'cheese', 3].findResults {
    try {
        it as Integer
    } catch (NumberFormatException) {
        null
    }
}

assert result2 == [1, 2, 3]

// identity find all
assert [0, false, [], 0.0].findAll() == []
assert [0, false, [], 0.0].findAll(Closure.IDENTITY) == []