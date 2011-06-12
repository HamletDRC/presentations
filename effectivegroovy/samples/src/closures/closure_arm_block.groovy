package closures


// java
Writer writer1 = new StringWriter();
try {
    writer1.write("... some data");
} finally {
    writer1.close();
}
println writer1.toString()

Writer writer2 = new StringWriter();
try {
    writer2.write("... some data");
} finally {
    try {
        writer2.close();
    } catch(IOException e) {
        // ignored
    }
}
println writer2.toString()


// function objects
def withJavaClose(Closeable c, Runnable f) {
    try {
        f.run();
    } finally {
        try {
            c.close();
        } catch(IOException e) {
            // ignored
        }
    }
}

final Writer writer3 = new StringWriter();
withJavaClose(writer3, new Runnable() {
    @Override
    void run() {
        writer3.write("... some data");
    }
});
println writer3.toString()

// return values? exceptions?

// ARM blocks
def withClose(Closeable c, Closure f) {
    try {
        f();
    } finally {
        try {
            c.close();
        } catch(IOException e) {
            // ignored
        }
    }
}

final Writer writer4 = new StringWriter();
withClose(writer4) {
        writer4.write("... some data");
}
println writer4.toString()

// use closures to create higher-order functions (like ARM blocks)

