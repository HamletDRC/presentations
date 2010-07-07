package littlegroover.commandment02

import static littlegroover.Functions.cons

def evens(lat) {
    if (!lat) []
    else
        if (lat.head() % 2) evens(lat.tail())
        else cons(lat.head(), evens(lat.tail()))
}

assert [2, 4, 6] == evens([1, 2, 3, 4, 5, 6])


def remove(a, lat) {
    if (!lat) []
    else
        if (lat.head() == a) lat.tail()
        else (cons(lat.head(), remove(a, lat.tail())))
}


assert ['apples', 'oranges'] == remove('berries', ['apples', 'oranges', 'berries'])
assert ['butter', 'jelly'] == remove('peanut', ['peanut', 'butter', 'jelly'])

