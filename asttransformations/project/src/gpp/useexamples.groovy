package gpp

use(Collections) {
    List l = (0..10).toList()
    l.shuffle()
    println l
}


@Typed
@Use(Collections)
def myShuffle() {
    List l = (0..10).toList()
    l.shuffle()
    println l
}


myShuffle()