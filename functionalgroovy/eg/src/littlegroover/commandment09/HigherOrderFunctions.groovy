package littlegroover.commandment09

import static littlegroover.Functions.cons

def evens(lat) {
    if (!lat) []
    else
        if (lat.head()%2) evens(lat.tail())
        else cons(lat.head(), evens(lat.tail()))
}

assert [2, 4, 6] == evens([1, 2, 3, 4, 5, 6])


def odds(lat) {
    if (!lat) []
    else
        if (lat.head()%2 == 0) odds(lat.tail())
        else cons(lat.head(), odds(lat.tail()))
}

assert [1, 3, 5] == odds([1, 2, 3, 4, 5, 6])

