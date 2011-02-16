package com.canoo.cdi;

import javax.enterprise.event.Observes;

public class GreetingObserver {
    public void onGreeting(@Observes Greeting greeting) {
        System.out.println("Somebody greets: '" + greeting.getContent() + "'.");
    }
}
