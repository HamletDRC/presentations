package com.canoo.cdi;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class CdiMain {

    @Inject
    Event<Greeting> fEvent;

    public void start(@Observes ContainerInitialized event) {
        String greeting = "Hello Madrid";
        fEvent.fire(new Greeting(greeting));
    }
}
