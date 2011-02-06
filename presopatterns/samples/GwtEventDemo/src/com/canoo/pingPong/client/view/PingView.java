package com.canoo.pingPong.client.view;

import com.canoo.pingPong.client.events.PingEvent;
import com.canoo.pingPong.client.events.PongEvent;
import com.canoo.pingPong.client.events.PongEventHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;

public class PingView extends Label {

    public PingView(final SimpleEventBus bus) {
        
        bus.addHandler(PongEvent.TYPE, new PongEventHandler() {
            public void onEvent(PongEvent event) {
                setText("Pong");

                new Timer() {
                    public void run() {
                        setText("");
                        bus.fireEvent(new PingEvent());
                    }
                }.schedule(1000);
            }
        });
        
    }
}
