package gpp

// ye olde Groovy 1.8
use(Collections) {
    List l = (0..10).toList()
    l.shuffle()
    println l
}

// the new hotness of g++
@Typed
@Use(Collections)
def myShuffle() {
    List l = (0..10).toList()
    l.shuffle()
    println l
}


myShuffle()