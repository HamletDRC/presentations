package com.canoo.cdi.events;

import javax.enterprise.event.Observes;

public class GreetingObserver {
    public void onGreeting(@Observes Greeting greeting) {
        System.out.println("Sombody greets: '" + greeting.getContent() + "'.");
    }
}
