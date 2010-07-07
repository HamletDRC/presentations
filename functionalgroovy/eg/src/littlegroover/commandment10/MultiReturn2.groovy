package littlegroover.commandment10

import static littlegroover.Functions.cons

/*
The Tenth Commandment
Build functions to collect more than one value at a time
 */

def size(a) {
    a.length()
}
// remember remove? How about a remove along with the size of each element?

def removeAndCount(a, list) {
    def inner
    inner = { lat ->
        if (!lat) []
        else
            if (lat.head() == a) lat.tail()
            else (cons(
                    cons(lat.head(), [size(lat.head())]),
                    inner(lat.tail())))
    }
    inner(list)
}


assert [['apples', 6], ['oranges', 7]] == removeAndCount('berries', ['apples', 'oranges', 'berries'])