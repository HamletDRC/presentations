
@Grab(group='commons-lang', module='commons-lang', version='2.6')
@Grab(group='commons-lang', module='commons-lang', version='2.6', classifier='sources')
import org.apache.commons.lang.ArrayUtils

int[] evens = [2, 4, 6] as int[]
int[] odds = [1, 3, 5] as int[]

assert ArrayUtils.contains(evens, 2)
assert ArrayUtils.contains(odds, 3)

assert [2, 4, 6, 8] == ArrayUtils.add(evens, 8)
assert [2, 4, 6, 1, 3, 5] == ArrayUtils.addAll(evens, odds)

assert [2, 6] == ArrayUtils.remove(evens, 1)
assert [1, 3] == ArrayUtils.remove(odds, 2)


println "Success";