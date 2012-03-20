package codenarc

class Example2 {

    List<Number> odds(List<Number> input) {
        if (input == null) {
            return null
        }

        input.findAll { it % 2 == 1 }
    }
}
