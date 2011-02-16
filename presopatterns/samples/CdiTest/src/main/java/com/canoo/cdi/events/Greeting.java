package com.canoo.cdi.events;

public class Greeting {
    private final String fContent;

    public Greeting(String content) {
        fContent = content;
    }

    public String getContent() {
        return fContent;
    }
}
