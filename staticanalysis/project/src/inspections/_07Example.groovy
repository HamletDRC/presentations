package inspections

class _07Example {
    
    private def Object lock = new Object()

    def method() {
        synchronized(lock) {
            // do something
        }
    }
}
