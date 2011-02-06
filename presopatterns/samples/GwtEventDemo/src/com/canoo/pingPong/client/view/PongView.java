package com.canoo.pingPong.client.view;

import com.canoo.pingPong.client.events.PingEvent;
import com.canoo.pingPong.client.events.PingEventHandler;
import com.canoo.pingPong.client.events.PongEvent;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;

/**
 * @author Hamlet D'Arcy
 */
public class PongView extends Label {
    public PongView(final SimpleEventBus bus) {
        
        bus.addHandler(PingEvent.TYPE, new PingEventHandler() {
            public void onEvent(PingEvent event) {
                setText("Ping");
                new Timer() {
                    public void run() {
                        setText("");
                        bus.fireEvent(new PongEvent());
                    }
                }.schedule(1000);
            }
        });
    }
}
