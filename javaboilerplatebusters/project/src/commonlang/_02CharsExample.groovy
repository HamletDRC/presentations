
@Grab(group='commons-lang', module='commons-lang', version='2.6')
@Grab(group='commons-lang', module='commons-lang', version='2.6', classifier='sources')
import org.apache.commons.lang.CharUtils

char a = CharUtils.toChar("a");
char B = CharUtils.toChar("B");
char one = CharUtils.toChar("1");


assert CharUtils.isAsciiAlpha(a);
assert CharUtils.isAsciiAlphaLower(a);
assert CharUtils.isAsciiAlphanumeric(a);
assert CharUtils.isAsciiAlphaUpper(B);
assert CharUtils.isAsciiNumeric(one);


println "Success";