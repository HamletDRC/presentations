package com.canoo.cdi;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class Cdi {
    @Inject
    IGreeter fGreeter;

    public void start(@Observes ContainerInitialized event) {
        fGreeter.sayHello("Alberto");
    }
}
