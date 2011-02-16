package com.canoo.cdi.decorators;

import com.canoo.cdi.IGreeter;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class GreeterDecorator implements IGreeter {
    @Inject
    @Delegate
    @Any
    IGreeter fGreeter;

    public void sayHello(String name) {
        fGreeter.sayHello("*** " + name + " ***");
    }
}