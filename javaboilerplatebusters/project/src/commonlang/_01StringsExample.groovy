

@Grab(group='commons-lang', module='commons-lang', version='2.6')
@Grab(group='commons-lang', module='commons-lang', version='2.6', classifier='sources')
import org.apache.commons.lang.StringUtils

/* Stringly typed system support */

assert StringUtils.isAlpha("abcde");
assert StringUtils.isNumeric("12345");
assert StringUtils.isAlphanumeric("12345abc");

assert StringUtils.isBlank("");
assert StringUtils.isBlank(null);


assert StringUtils.isAllLowerCase("abcdef");
assert StringUtils.isAllUpperCase("ABCDEF");

assert "" == StringUtils.defaultString("");
assert "" == StringUtils.defaultString(null);


assert "abc" == StringUtils.left("abcdef", 3);
assert "def" == StringUtils.right("abcdef", 3);
assert null == StringUtils.right(null, 3);

Object[] array = [1, 2, 3] as Object[]
assert "1, 2, 3" == StringUtils.join(array, ', ')

List list = [1, 2, 3]
assert "1, 2, 3" == StringUtils.join(list, ', ')


System.out.println "Success";