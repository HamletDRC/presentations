package guava

@Grab(group='com.google.guava', module='guava', version='r08')
@Grab(group='com.google.guava', module='guava', version='r08', classifier='sources')
import com.google.common.base.Objects
import com.google.common.base.Equivalences
import com.google.common.collect.ComparisonChain

class Person implements Comparable<Person> {
    String name;
    Date timestamp = new Date();

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("timestamp", timestamp).toString();
    }

    @Override
    boolean equals(Object obj) {
        if (obj.is(null)) { return false; }
        if (obj.is(this)) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Person rhs = (Person) obj;

        return Equivalences.equals().equivalent(name, rhs.name) &&
                Equivalences.equals().equivalent(timestamp, rhs.timestamp)
    }

    @Override
    int hashCode() {
        return Objects.hashCode(name, timestamp);
    }


    int compareTo(Person other) {
        return ComparisonChain.start()
                 .compare(name, other.name)
                 .compare(timestamp, other.timestamp)
                 .result();
    }
}


def hamlet = new Person(name: "hamlet")
def paul = new Person(name: "paul")

println hamlet.toString()

def imposter = new Person(name: "hamlet", timestamp: hamlet.timestamp)

assert hamlet != paul
assert hamlet == imposter
assert hamlet.hashCode() != paul.hashCode()
assert hamlet < paul
assert paul > hamlet
