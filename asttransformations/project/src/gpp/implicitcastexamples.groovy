package gpp


class Holder {
    @Typed
    def typedMethod() {
        Object obj = new Date()
        Date d = obj  // Standard cast

        int i = "0"  // (int)String: Dynamically convert

        Runnable r = {print "in groovy++ run"}  // (Runnable)Closure: a class is created implementing 'void run() {}'
        Runnable r1 = [run : {print "also in groovy++ run"}]  // (Runnable)Map: a class is created implementing 'void run() {}' and other abstract methods if any.
        r1.run()
        d = []  // (Date)List: default constructor is invoked
    }

    def untypedMethod() {
        Object obj = new Date()
        Date d = obj  // Standard cast

        int i = "0"  // (int)String: Dynamically convert

        Runnable r = {print "in plain groovy run"}  // (Runnable)Closure: a class is created implementing 'void run() {}'
        Runnable r1 = [run : {print "also in plain groovy run"}]  // (Runnable)Map: a class is created implementing 'void run() {}' and other abstract methods if any.
        d = []  // (Date)List: default constructor is invoked
    }
}


new Holder().typedMethod()

println '\nSuccess'