

@Typed
class MyPrinter {
    void print(String s) {
        println s
    }
}

void print(String s) {
    println s
}

print 'Hello Groovy'
new MyPrinter().print 'Hello Groovy++'



// class generated as part of build
// new org.mbte.groovypp.ReleaseInfo().getAllProperties()
