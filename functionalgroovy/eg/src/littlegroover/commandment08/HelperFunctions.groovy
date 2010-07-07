package littlegroover.commandment08

import static littlegroover.Functions.cons

/*
The Eighth Commandment
Use help functions to abstract from representations
 */

def add1(n) {
    if (n == null) []
    else
        cons([], n)
}

assert [] == []
assert [ [] ] == add1([])
assert [ [], [], [] ] == add1([ [], [] ])

def sub1(n) {
    if (!n) null
    else n.tail()
}

assert [ [] ] == sub1([ [], [] ])
assert [ [], [] ] == sub1([ [], [], [] ])

def plus(n, m) {
    if (m == null) []
    else
        add1(plus(n, sub1(m)))
}

assert [ [], [] ] == plus([[]], [[]])