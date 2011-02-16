package com.canoo.cdi.controller;

import com.canoo.cdi.event.PingEvent;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@SuppressWarnings({"UnusedDeclaration"})
public class PingPongController {

    @Inject
    Event<PingEvent> event;

    public void start(@Observes ContainerInitialized e) {
        event.fire(new PingEvent());
    }
}
