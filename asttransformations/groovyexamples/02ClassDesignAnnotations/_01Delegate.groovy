class NoisySet extends HashSet {
    
    boolean add(i) {
        println "adding $i"
        super.add(i)
    }

    boolean addAll(Collection i) {
        for(def x : i) { println "adding $x" }
        super.addAll(i)
    }
}
def set = [] as NoisySet
set.addAll([1, 2, 3])