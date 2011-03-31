package guava

@Grab(group='com.google.guava', module='guava', version='r08')
import com.google.common.base.Splitter


final String input = "One, Two,,Three,Four,Five";
printWords(Splitter.on(',').split(input));

printWords(Splitter.on(',').trimResults().split(input));

printWords(Splitter.on(',').trimResults().omitEmptyStrings().split(input));

private static printWords(Iterable<String> words) {
    for (String word : words) {
        System.out.printf("[%s]\n", word);
    }
    System.out.println();
}