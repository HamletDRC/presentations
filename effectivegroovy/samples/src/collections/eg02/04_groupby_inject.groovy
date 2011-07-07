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

// group by is one way
frequencies = people.groupBy { it.lastName }
println frequencies

println 'Success'


// how about a group-by, group-by
def expected = [
        Buck:[
                Chuck:'[domain.Person(1, Chuck, Buck)]',
                Joe:'[domain.Person(3, Joe, Buck)]]',
        ],
        Plumber:[
                Mario:'[domain.Person(2, Mario, Plumber)]']
        ]
def result = people.groupBy({ it.lastName }, { it.firstName })
//assert result == expected

// inject is another way
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

