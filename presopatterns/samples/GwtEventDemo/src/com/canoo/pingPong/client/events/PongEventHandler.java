package com.canoo.pingPong.client.events;

import com.google.gwt.event.shared.EventHandler;


public interface PongEventHandler extends EventHandler {

    void onEvent(PongEvent event);
}
