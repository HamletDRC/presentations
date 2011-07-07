package eg08_closures



withCloseable(new PrintWriter(new File('./02.out'))) {
    it.println ('Spring IO Rocks!')
}


static def withCloseable(Closeable closeable, Closure delegate) {
    try {
        delegate(closeable)
    } finally {
        closeable.close()
    }
}

