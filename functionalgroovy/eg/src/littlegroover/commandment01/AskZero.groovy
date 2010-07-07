package littlegroover.commandment01

import static littlegroover.Functions.add1
import static littlegroover.Functions.sub1

// define math operators in relation to to primitives

def plus(n, m) {
    if (m == 0) n
    else plus(add1(n), m-1)
}

assert 2 == plus(1, 1)
assert 4 == plus(2, 2)

def minus(n, m) {
    if (m == 0) n
    else minus(sub1(n), m-1)
}

assert 0 == minus(1, 1)
assert 5 == minus(10, 5)


def multiply(n, m) {
    if (m == 0) 0
    else
        plus(n, multiply(n, (sub1(m))))
}

assert 6 == multiply(3, 2)
assert 12 == multiply(4, 3)

