public class MyClass implements GroovyInterceptable {

   def invokeMethod(String name, args) {

       System.out.println "Before $name"

       def m = this.metaClass.getMetaMethod(name, args)
       def result = m.invoke(this, args)

       System.out.println "After $name"

       return result
   }

   def greet() {
       System.out.println "Hello World!"
   }

}

new MyClass().greet()
