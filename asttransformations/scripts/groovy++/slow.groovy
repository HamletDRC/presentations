
@Typed
package example

long result = 0
for (long x = 0; x < 100000000; x++) {
    result = result + x
}

println result
