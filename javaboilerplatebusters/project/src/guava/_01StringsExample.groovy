

@Grab(group='com.google.guava', module='guava', version='r08')
@Grab(group='com.google.guava', module='guava', version='r08', classifier='sources')
import com.google.common.base.Joiner
import com.google.common.base.Splitter
import com.google.common.base.Strings

// joining
Set set = [1, 2, 3] as Set
assert "1, 2, 3" == Joiner.on(", ").join(set)

// splitting
String string = "1, 2, , 3";

Iterable<String> x = Splitter.on(",")
        .omitEmptyStrings()
        .trimResults()
        .split(string)

assert ["1", "2", "3"] == x.collect { it }


// fun with strings
assert Strings.emptyToNull("") == null
assert "".equals(Strings.nullToEmpty(null))
assert Strings.isNullOrEmpty("");
assert "abcabcabc", Strings.repeat("abc", 3);

