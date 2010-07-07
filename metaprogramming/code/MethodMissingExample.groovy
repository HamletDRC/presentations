public class MyClass {
   def methodMissing(String name, args) {
       if (name == "greet") {
           println "Hello World"
           return
       }
       throw new MissingMethodException(name, delegate, args)
   }
}

new MyClass().greet();
