package org.bnd

import org.osgi.framework.BundleActivator
import org.osgi.framework.BundleContext
import org.example.Greeter

public class BndActivator implements BundleActivator {

    public void start(BundleContext context) {
        println "Hello from a Groovy bnd example Activator"
        new Greeter().greet() 
    }

    public void stop(BundleContext context) { 
    }
}

