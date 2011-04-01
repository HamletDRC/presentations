package commonlang

@Grab(group = 'commons-lang', module = 'commons-lang', version = '2.6')
@Grab(group = 'commons-lang', module = 'commons-lang', version = '2.6', classifier = 'sources')
import org.apache.commons.lang.builder.ToStringBuilder
import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.CompareToBuilder


class Person implements Comparable<Person> {
    String name;
    Date timestamp = new Date();

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("timestamp", timestamp)
                .toString();
    }

    @Override
    boolean equals(Object obj) {
        if (obj.is(null)) { return false; }
        if (obj.is(this)) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Person rhs = (Person) obj;
        return new EqualsBuilder()
                .append(name, rhs.name)
                .append(timestamp, rhs.timestamp)
                .isEquals();
    }

    @Override
    int hashCode() {
        return new HashCodeBuilder(99, 33).
                append(name).
                append(timestamp).
                toHashCode();
    }


    int compareTo(Person other) {
             return new CompareToBuilder()
               .append(this.name, other.name)
               .toComparison();
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
