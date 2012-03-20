package codenarc

class Example3 {

    void printUnique(Collection c) {
        def unique = c.unique()
        println unique.join(', ')
    }
}
