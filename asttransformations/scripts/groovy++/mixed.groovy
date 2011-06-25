
@Grab('org.mbte.groovypp:groovypp-all:0.4.248_1.8.0')
@Grab('org.mbte.groovypp:groovypp:0.4.248_1.8.0')
@Typed
class MyClass {
    
    int getHtmlSize() {
        String html = buildDynamicHtml()
        html.length()
    }

    @Typed(TypePolicy.DYNAMIC)
    def buildDynamicHtml() {
        def writer = new StringWriter()
        new groovy.xml.MarkupBuilder(writer).root {
            child()
            child()
        }
        writer.toString()
    }
}

assert 38 == new MyClass().htmlSize
println new MyClass().buildDynamicHtml()
