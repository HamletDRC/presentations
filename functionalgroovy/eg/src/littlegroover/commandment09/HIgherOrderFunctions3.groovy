package littlegroover.commandment09

import static littlegroover.Functions.cons

static def collect(lat, f) {
    if (!lat) []
    else
        if (f(lat.head())) collect(lat.tail(), f)
        else cons(lat.head(), collect(lat.tail(), f))
}

static def evens(lat) {
    collect(lat, {x -> x % 2 == 1 })
}

static def odds(lat) {
    collect(lat, {x -> x % 2 == 0 })
}

assert [2, 4, 6] == evens([1, 2, 3, 4, 5, 6])
assert [1, 3, 5] == odds([1, 2, 3, 4, 5, 6])



