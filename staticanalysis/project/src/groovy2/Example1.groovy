package groovy2


void method(String message) {
  if (message != null) {
      println("Received input: ${message.toUppercase()}")
  }
}
