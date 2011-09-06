
private def getFirstNames = { parameter -> 
    if (parameter == null) return null
    if (parameter.length() == 0) return []
    if (parameter != null && parameter instanceof Person) {
        return parameter.firstName
    }
    return parameter.collect { it.firstName } 
}



