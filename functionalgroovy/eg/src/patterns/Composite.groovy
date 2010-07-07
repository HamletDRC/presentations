package patterns

interface Graphic {
     void print();
}

class Circle implements Graphic {
    public void print() { println "a circle" }
}

class CompositeGraphic implements Graphic {
    def leafs;
    public void print() {
        leafs.each { it.print() }
    }
}

def c = new CompositeGraphic(leafs: [new Circle(), new Circle()])
c.print()

def circle = { println "a circle" }

def makeComposite = { leaf1, leaf2 ->
    { -> leaf1(); leaf2() }
}

def c1 = makeComposite(circle, circle)
c1()
