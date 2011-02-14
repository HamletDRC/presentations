package eg05

import java.util.concurrent.Executors
import java.util.concurrent.Callable
import domain.Person

def exe = Executors.newSingleThreadExecutor()

def future = exe.submit({
    Person.findAll()?.size()
} as Callable)

println future.get()

exe.shutdown()