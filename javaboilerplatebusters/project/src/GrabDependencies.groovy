

@Grab(group='com.google.guava', module='guava', version='r08')
import com.google.common.base.Joiner


println Joiner.on(", ").join([1, 2, 3]);


println "Dependencies grabbed successfully"