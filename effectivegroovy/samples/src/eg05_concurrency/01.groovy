package eg05_concurrency

import domain.Person

def count
def t = Thread.start {
    count = Person.findAll()?.size()
}

t.join()
println count