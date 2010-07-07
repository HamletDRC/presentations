package org.example.sayhello

import org.osgi.framework.BundleActivator
import org.osgi.framework.BundleContext
import org.example.Greeter

public class GreetingActivator implements BundleActivator {

    public void start(BundleContext context) {
	    println "Hello from Groovy Activator"
        def greeter = new Greeter()
        greeter.greet() 
    }

    public void stop(BundleContext context) { 
    }
}
