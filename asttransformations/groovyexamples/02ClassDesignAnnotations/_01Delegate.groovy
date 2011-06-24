class NoisySet extends HashSet {
    @Override 
    boolean add(i) {
        println "adding $i"
        super.add(i)
    }

    @Override 
    boolean addAll(Collection i) {
        for(def x : i) { println "adding $x" }
        super.addAll(i)
    }
}

def set = [] as NoisySet

set.add(1)
//set.addAll([1, 2, 3])