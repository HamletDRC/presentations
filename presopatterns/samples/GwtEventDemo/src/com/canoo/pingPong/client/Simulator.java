package com.canoo.pingPong.client;

import com.canoo.pingPong.client.events.PingEvent;
import com.canoo.pingPong.client.view.PingView;
import com.canoo.pingPong.client.view.PongView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Simulator implements EntryPoint {

    public void onModuleLoad() {

        final SimpleEventBus bus = new SimpleEventBus();

        RootPanel.get("pingSlot").add(new PingView(bus));
        RootPanel.get("pongSlot").add(new PongView(bus));


        final Button button = new Button("Serve!");
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                button.setVisible(false);
                bus.fireEvent(new PingEvent());
            }
        });
        RootPanel.get("buttonSlot").add(button);
    }
}
