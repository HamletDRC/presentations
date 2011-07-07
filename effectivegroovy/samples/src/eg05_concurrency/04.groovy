package eg05_concurrency

@Grab(group = 'org.codehaus.gpars', module = 'gpars', version = '0.11')
import static groovyx.gpars.dataflow.DataFlow.task
import groovyx.gpars.dataflow.DataFlowVariable
import domain.Address
import domain.Person

final def personCount = new DataFlowVariable()
final def addressCount = new DataFlowVariable()
final def total = new DataFlowVariable()

task {
    total << personCount.val + personCount.val
}
task {
    personCount << Person.findAll().size()
}
task {
    addressCount << Address.findAll().size()
}

println "Total: $total.val"
    