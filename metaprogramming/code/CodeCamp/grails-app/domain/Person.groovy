class Person {
	String name
	Date dateOfBirth
	
	String toString()
	{
		return "$name ${dateOfBirth.getDateString()}"
	}
}
