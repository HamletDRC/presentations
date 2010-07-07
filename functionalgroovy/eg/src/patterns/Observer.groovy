package patterns


class MyObserver implements java.util.Observer {
    void update(Observable subject, state) {
        // ...
    }
}

def myObserver = { subject, state -> /*...*/ }
