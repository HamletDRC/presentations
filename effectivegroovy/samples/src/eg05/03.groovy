package eg05

@Grab(group = 'org.codehaus.gpars', module = 'gpars', version = '0.11')
import static groovyx.gpars.dataflow.DataFlow.task
import groovyx.gpars.dataflow.DataFlowVariable
import eg02.Person

final def count = new DataFlowVariable()

task {
    count << Person.findAll().size()
}

println count.val
