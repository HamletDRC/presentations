package com.canoo.cdi;

import com.canoo.cdi.events.Greeting;
import com.canoo.cdi.interceptors.Transactional;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.Random;

public class Greeter implements IGreeter {
    private int fId = new Random().nextInt(100);

    @Inject
    Event<Greeting> fEvent;

    @Transactional
    public void sayHello(String name) {
        String greeting = "Hello: " + name + "!!!";
        System.out.println("(" + fId + ") " + greeting);
        fEvent.fire(new Greeting(greeting));
    }
}
