package com.canoo.pingPong.client.events;

import com.google.gwt.event.shared.EventHandler;


public interface PingEventHandler extends EventHandler {

    void onEvent(PingEvent event);
}
