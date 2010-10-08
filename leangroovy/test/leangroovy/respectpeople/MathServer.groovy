package leangroovy.respectpeople

@Grab(group='org.codehaus.groovy.modules', module='groovyws', version='0.5.1')

def server = new groovyx.net.ws.WSServer()

server.setNode("leangroovy.respectpeople.MathService", "http://localhost:6980/MathService")

server.start()
