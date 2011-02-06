package com.canoo.pingPong.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class PingEvent extends GwtEvent<PingEventHandler> {

    public static Type<PingEventHandler> TYPE = new Type<PingEventHandler>();

    @Override
    public Type<PingEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(PingEventHandler handler) {
        handler.onEvent(this);
    }
}
