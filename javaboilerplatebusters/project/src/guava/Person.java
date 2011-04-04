package guava;

import com.google.common.base.Objects;
import com.google.common.base.Equivalences;
import com.google.common.collect.ComparisonChain;

import java.util.Date;

class Person implements Comparable<Person> {
    String name;
    Date timestamp = new Date();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {return name; }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("timestamp", timestamp).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Person rhs = (Person) obj;

        return Equivalences.equals().equivalent(name, rhs.name) &&
                Equivalences.equals().equivalent(timestamp, rhs.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, timestamp);
    }


    public int compareTo(Person other) {
        return ComparisonChain.start()
                 .compare(name, other.name)
                 .compare(timestamp, other.timestamp)
                 .result();
    }
}
