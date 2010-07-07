def builder = new groovy.xml.MarkupBuilder()

def xml = builder.stocks { 
    stock(symbol: 'JAVA')
    stock(symbol: 'MSFT')
    stock(symbol: 'IBM' )
}

