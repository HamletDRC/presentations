package littlegroover.commandment01


def size(lat) {
    if (!lat) 0
    else 1 + size(lat.tail())
}

assert 0 == size([])
assert 1 == size(['apples'])
assert 3 == size(['apples', 'oranges', 'pears'])

// find if element in list exists

def isMember(a, lat) {
    if (!lat) false
    else
        if (lat.head() == a) true
        else isMember(a, lat.tail())
}

assert isMember(3, [1, 2, 3, 4, 5])
assert !isMember(66, [1, 2, 3, 4, 5])

