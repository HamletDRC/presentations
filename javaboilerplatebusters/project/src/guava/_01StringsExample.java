package guava;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author Hamlet D'Arcy
 */
public class _01StringsExample {

    public static void main(String[] args) {

        // joining
        Set<Integer> set = Sets.newHashSet(1, 2, 3);

        assert "1, 2, 3".equals(Joiner.on(", ").join(set));

        // splitting
        String string = "1, 2, , 3";

        Iterable<String> x = Splitter.on(",")
                .omitEmptyStrings()
                .trimResults()
                .split(string);

        Iterable<Integer> setAsInts = Iterables.transform(x,
                new Function<String, Integer>() {
                    @Override
                    public Integer apply(String input) {
                        return Integer.valueOf(input);
                    }
                });

        assert Lists.newArrayList(1, 2, 3).containsAll(Lists.newArrayList(setAsInts));


        // fun with strings
        assert Strings.emptyToNull("") == null;
        assert "".equals(Strings.nullToEmpty(null));
        assert Strings.isNullOrEmpty("");
        assert "abcabcabc".equals(Strings.repeat("abc", 3));
    }
}
