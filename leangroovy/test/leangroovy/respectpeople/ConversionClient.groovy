package leangroovy.respectpeople

@Grab(group='org.codehaus.groovy.modules', module='groovyws', version='0.5.1') 

wsdl = 'http://www.webservicex.net/CurrencyConvertor.asmx?WSDL'
proxy = new groovyx.net.ws.WSClient(wsdl, this.class.classLoader)
proxy.initialize()

rate = proxy.ConversionRate('EUR', 'CHF')
println "Euro to Swiss Franc conversion rate is: $rate"