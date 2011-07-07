package ej16_composition

class NoisySet_bad extends HashSet {
    
    @Override boolean add(i) {
        println "adding $i"
        super.add(i)
    }

    @Override boolean addAll(Collection i) {
        for(def x : i) { println "adding $x" }
        super.addAll(i)
    }
}

class NoisySet implements Set {

    @Delegate
    Set delegate = new HashSet()

    @Override
    boolean add(i) {
        println "adding $i"
        delegate.add(i)
    }

    @Override
    boolean addAll(Collection i) {
        for(def x : i) { println "adding $x" }
        delegate.addAll(i)
    }
}

new NoisySet_bad().addAll([1, 2, 3])
println '---'
new NoisySet().addAll([1, 2, 3])
