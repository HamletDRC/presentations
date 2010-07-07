package littlegroover.commandment06

import static littlegroover.Functions.*

/**
 The Sixth Commandment
 Simplify only after the function is correct
 */



def isMember(a, list) {
    def inner
    inner = { lat ->
        if (!lat) false
        else
            if (lat.head() == a) true
            else inner(lat.tail())
    }
    inner(list)
}

assert isMember(3, [1, 2, 3, 4, 5])
assert !isMember(66, [1, 2, 3, 4, 5])


def replace(_new, old, list) {
    def inner
    inner = { lat ->
        if (!lat) []
        else
            if (lat.head() == old)
                cons(_new, inner(lat.tail()))
            else
                cons(lat.head(), inner(lat.tail()))
    }
    inner(list)
}


assert ['chocolate', 'ice', 'cream'] == replace('chocolate', 'vanilla', ['vanilla', 'ice', 'cream'])
