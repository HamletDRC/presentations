package codenarc

class Example1 {

    def state

    boolean equals(Example1 o) {

        if (this.is(o)) { return true }
        if (!(o instanceof Example1)) { return false }

        Example1 example1 = (Example1) o

        if (state != example1.state) { return false }

        true
    }

    int hashCode() {
        (state != null ? state.hashCode() : 0)
    }
}

