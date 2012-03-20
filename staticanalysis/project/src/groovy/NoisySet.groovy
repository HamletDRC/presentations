package groovy

class NoisySet extends HashSet {

    boolean add(Object e) {
        println "adding $e"
        super.add(e)
    }

    boolean addAll(Collection c) {
        c?.each {
            println "adding $it"
        }
        super.addAll(c)
    }

    static void main(String[] args) {

        def s = [] as NoisySet
        s.add(1)
        s.add(2)
        s.add(3)
    }
}

