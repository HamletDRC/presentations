package littlegroover.commandment03

import static littlegroover.Functions.cons

def replace(_new, old, lat) {
    if (!lat) []
    else
        if (lat.head() == old)
            cons(_new, replace(_new, old, lat.tail()))
        else
            cons(lat.head(), replace(_new, old, lat.tail()))
}

assert ['chocolate', 'ice', 'cream'] == replace('chocolate', 'vanilla', ['vanilla', 'ice', 'cream'])

def insertL(_new, old, lat) {
    if (!lat) []
    else
        if (lat.head() == old)
            cons(_new, cons(old, insertL(_new, old, lat.tail())))
        else
            cons(lat.head(), insertL(_new, old, lat.tail()))
}

assert ['donuts', 'and', 'milk'] == insertL('and', 'milk', ['donuts', 'milk'])

def insertR(_new, old, lat) {
    if (!lat) []
    else
        if (lat.head() == old)
            cons(old, cons(_new, insertR(_new, old, lat.tail())))
        else
            cons(lat.head(), insertR(_new, old, lat.tail()))
}

assert ['donuts', 'and', 'milk'] == insertR('and', 'donuts', ['donuts', 'milk'])

