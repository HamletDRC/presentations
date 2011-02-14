package eg03

def file = new File('./03.groovy')
file.text = file.text + '\n // hello! '







file.append '\n // better hello! '

