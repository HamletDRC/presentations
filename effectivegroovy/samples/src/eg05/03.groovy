package eg05

@Grab(group = 'org.codehaus.gpars', module = 'gpars', version = '0.10')
import static groovyx.gpars.dataflow.DataFlow.task
import groovyx.gpars.dataflow.DataFlowVariable
import domain.Person

final def count = new DataFlowVariable()

task {
    count << Person.findAll().size()
}

println count.val
