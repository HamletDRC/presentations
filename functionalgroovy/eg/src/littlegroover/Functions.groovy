package littlegroover

class Functions {

    static def cons(atom, lat) {
        def x = [atom]
        x.addAll(lat)
        x
    }

    static def add1(a) { a + 1 }

    static def sub1(a) { a - 1 }    
}
