package eg05

import eg02.Person

def count
def t = Thread.start {
    count = Person.findAll()?.size()
}

t.join()
println count