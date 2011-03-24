import groovy.xml.MarkupBuilder

new MarkupBuilder().root {

    people{
        person(id: 1)
        person(id: 2)
        person(id: 3)
    }
}


