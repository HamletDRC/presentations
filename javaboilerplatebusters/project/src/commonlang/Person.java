package commonlang;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Date;

public class Person implements Comparable<Person> {
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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
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
    public int hashCode() {
        return new HashCodeBuilder().
                append(name).
                append(timestamp).
                toHashCode();
    }


    public int compareTo(Person other) {
        return new CompareToBuilder()
                .append(this.name, other.name)
                .toComparison();
    }
}
