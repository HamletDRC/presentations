def builder = new groovy.xml.MarkupBuilder()

def stockList = ['JAVA', 'MSFT', 'IBM']

def xml = builder.stocks { 
	stockList.each { 
		    stock(symbol: it)
	}
}
