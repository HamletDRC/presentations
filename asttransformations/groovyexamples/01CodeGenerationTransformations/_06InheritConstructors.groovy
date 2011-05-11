@groovy.transform.InheritConstructors
class MyPrintWriter extends PrintWriter { }

assert new MyPrintWriter(new File('out.txt'))