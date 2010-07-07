package littlegroover.commandment09

import static littlegroover.Functions.cons

static def collect(list, f) {
    def inner
    inner = { lat ->
        if (!lat) []
        else
            if (f(lat.head())) inner(lat.tail())
            else cons(lat.head(), inner(lat.tail()))
    }
    inner(list)
}

static def evens(lat) {
    collect(lat, {x -> x % 2 == 1 })
}

static def odds(lat) {
    collect(lat, {x -> x % 2 == 0 })
}

assert [2, 4, 6] == evens([1, 2, 3, 4, 5, 6])
assert [1, 3, 5] == odds([1, 2, 3, 4, 5, 6])



