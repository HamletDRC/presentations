package com.canoo.pingPong.client.events;

import com.google.gwt.event.shared.GwtEvent;


public class PongEvent extends GwtEvent<PongEventHandler> {

    public static Type<PongEventHandler> TYPE = new Type<PongEventHandler>();

    @Override
    public Type<PongEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(PongEventHandler handler) {
        handler.onEvent(this);
    }
}
