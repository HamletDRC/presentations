package guava

def hamlet = new Person(name: "hamlet")
def paul = new Person(name: "paul")

println hamlet.toString()

def imposter = new Person(name: "hamlet", timestamp: hamlet.timestamp)

assert hamlet != paul
assert hamlet == imposter
assert hamlet.hashCode() != paul.hashCode()
assert hamlet < paul
assert paul > hamlet
