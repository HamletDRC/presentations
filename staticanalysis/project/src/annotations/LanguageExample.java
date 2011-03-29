package annotations;


import org.intellij.lang.annotations.Language;

public class LanguageExample {

    @Language("Groovy")
    String getScript() {
        return "5.times { count -> println \"Hello $count\" } ";
    }

    String getMarkup() {
        @Language("XML")
        String markup = "<root><body>Some Text</body></root>";
        return markup;
    }
}
