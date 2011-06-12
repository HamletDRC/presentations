package files

def file = new File('./02.groovy')
println file.text











file.eachLine { println it }