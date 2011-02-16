package com.canoo.cdi.view;


import com.canoo.cdi.event.PingEvent;
import com.canoo.cdi.event.PongEvent;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class PingView {

    @Inject
    Event<PongEvent> event;

    public void onPing(@Observes PingEvent e) throws Exception {
        System.out.println("Ping");
        Thread.sleep(1000);
        event.fire(new PongEvent());
    }
}
