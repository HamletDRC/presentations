package eg05

import domain.Person

def count
def t = Thread.start {
    count = Person.findAll()?.size()
}

t.join()
println count