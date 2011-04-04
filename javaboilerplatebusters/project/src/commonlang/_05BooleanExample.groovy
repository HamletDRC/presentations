
@Grab(group='commons-lang', module='commons-lang', version='2.6')
@Grab(group='commons-lang', module='commons-lang', version='2.6', classifier='sources')
import org.apache.commons.lang.BooleanUtils

assert BooleanUtils.toBoolean("true"); 
assert BooleanUtils.toBoolean("TRUE");
assert BooleanUtils.toBoolean("tRUe");
assert BooleanUtils.toBoolean("on");
assert BooleanUtils.toBoolean("ON");
assert BooleanUtils.toBoolean("yes");
assert BooleanUtils.toBoolean("YES");

println "Success";