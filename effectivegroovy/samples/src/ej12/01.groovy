package ej12

class Person implements Comparable<Person> {
    String firstName
    String lastName
    int id

    @Override
    int compareTo(Person o) {
        int r1 = this.lastName.compareTo(o.lastName)
        if (r1 != 0) return r1

        int r2 = this.firstName.compareTo(o.firstName)
        if (r2 != 0) return r2

        this.id.compareTo(id)
    }
}

def p1 = new Person(id: 1, firstName: 'Hamlet', lastName: "D'Arcy")
def p2 = new Person(id: 2, firstName: 'Bro', lastName: "D'Arcy")

assert p1 > p2
assert p2 < p1
assert (p1 <=> p2) == 1