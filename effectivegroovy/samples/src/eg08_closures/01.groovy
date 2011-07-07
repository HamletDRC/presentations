package eg08_closures


def writer = new PrintWriter(new File('./01.out'))

try {
    writer.println ('Spring IO Rocks!')
} finally {
    writer.close()
}

