package com.canoo.cdi.view;


import com.canoo.cdi.event.PingEvent;
import com.canoo.cdi.event.PongEvent;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class PongView {

    @Inject
    Event<PingEvent> event;

    public void onPong(@Observes PongEvent e) throws Exception {
        System.out.println("Pong");
        Thread.sleep(1000);
        event.fire(new PingEvent());
    }
}
