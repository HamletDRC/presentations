package littlegroover.commandment10

import static littlegroover.Functions.cons

/*
The Tenth Commandment
Build functions to collect more than one value at a time
 */

def size(a) {
    a.length()
}
// remember insertL? How about an insertL along with a true/false indicator?

def removeAndCount(a, lat) {
    if (!lat) []
    else
        if (lat.head() == a) lat.tail()
        else (cons(
                cons(lat.head(), [size(lat.head())]),
                removeAndCount(a, lat.tail())))
}


assert [['apples', 6], ['oranges', 7]] == removeAndCount('berries', ['apples', 'oranges', 'berries'])