package annotations;

import org.intellij.lang.annotations.Pattern;

class PatternExample {

    @Pattern("[a-zA-Z]+")
    String getName() {
        return "my name";
    }
}

