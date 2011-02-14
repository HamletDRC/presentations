package eg05

import eg02.Person
import java.util.concurrent.Executors
import java.util.concurrent.Callable

def exe = Executors.newSingleThreadExecutor()

def future = exe.submit({
    Person.findAll()?.size()
} as Callable)

println future.get()

exe.shutdown()