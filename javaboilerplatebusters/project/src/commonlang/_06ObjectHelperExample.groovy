package commonlang

@Grab(group = 'commons-lang', module = 'commons-lang', version = '2.6')
@Grab(group = 'commons-lang', module = 'commons-lang', version = '2.6', classifier = 'sources')
import org.apache.commons.lang.builder.ToStringBuilder
import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.CompareToBuilder


def hamlet = new Person(name: "hamlet")
def paul = new Person(name: "paul")

println hamlet.toString()

def imposter = new Person(name: "hamlet", timestamp: hamlet.timestamp)

assert hamlet != paul
assert hamlet == imposter
assert hamlet.hashCode() != paul.hashCode()
assert hamlet < paul
assert paul > hamlet
