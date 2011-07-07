package files

def file = new File('./03.groovy')
file.text = file.text + '\n // hello! '







file.append '\n // better hello! '






def list = ['one', 'two', 'three']
for (def e : list) {
    //file.append e   // this is bad
}

new File('./03output.txt').withWriter { Writer it ->
    for (def e : list) {
        it.append "$e\n"
    }
}

 // hello! 
 // better hello! 
 // hello! 
 // better hello! 