import javax.swing.*

public class SampleTestCase extends GroovyTestCase {

	def CAR_NAME1 = 'HSV Maloo'
	def CAR_NAME2 = 'P50'
	def CAR_NAME3 = 'Royale'
	def CAR_MAKE1 = 'Holden'
	def CAR_MAKE2 = 'Peel'
	def CAR_MAKE3 = 'Bugatti'
	
	public void testXmlResult() {
		
		def garage = new Garage(
			new Car(CAR_NAME1, CAR_MAKE1), 
			new Car(CAR_NAME2, CAR_MAKE2), 
			new Car(CAR_NAME3, CAR_MAKE3)
		)
		
		def actual = serialize(garage, Garage)
		
		def expected = """
			<garage>
				<car name="$CAR_NAME1" make="$CAR_MAKE1"  />
				<car name="$CAR_NAME2" make="$CAR_MAKE2"  />
				<car name="$CAR_NAME3" make="$CAR_MAKE3"  />
			</garage>
		"""
		
		assertXmlEqual(expected, actual) 	
	}
	
	public void testXmlResult_InJava() {
		
		Garage garage = new Garage(
			new Car(CAR_NAME1, CAR_MAKE1), 
			new Car(CAR_NAME2, CAR_MAKE2), 
			new Car(CAR_NAME3, CAR_MAKE3)
		); 
		
		
		String actual = serialize(garage, Garage.class);
		
		String expected = 
			"<garage>" + 
			"	<car name=\"" + CAR_NAME1 + "\" make=\"" + CAR_MAKE1 + "\" /> " +
			"	<car name=\"" + CAR_NAME2 + "\" make=\"" + CAR_MAKE2 + "\" /> " +
			"	<car name=\"" + CAR_NAME3 + "\" make=\"" + CAR_MAKE3 + "\" /> " +
			"</garage>";
		
		assertXmlEqual(expected, actual); 	
	}
	
	public void testXmlResult_InJava_More_Typical() {
		
		Garage garage = new Garage(
			new Car(CAR_NAME1, CAR_MAKE1), 
			new Car(CAR_NAME2, CAR_MAKE2), 
			new Car(CAR_NAME3, CAR_MAKE3)
		); 
		
		
		String actual = serialize(garage, Garage.class);
		
		String expected = readFromFile("MyTest.sample.xml"); 
		
		assertXmlEqual(expected, actual); 	
	}
	
	def serialize(x, y) {
		"""
			<garage>
				<car name="HSV Maloo" make="Holden"  />
				<car name="P50"       make="Peel"    />
				<car name="Royale"    make="Bugatti" />
			</garage>
		"""
	}
	
	def readFromFile(x) {
		"""
			<garage>
				<car name="HSV Maloo" make="Holden"  />
				<car name="P50"       make="Peel"    />
				<car name="Royale"    make="Bugatti" />
			</garage>
		"""
	}
	
	def assertXmlEqual(expected, actual) {
		assertEquals(
			expected.replace(' ', '').replace('\t', '').replace('\n', ''), 
			actual.replace(' ', '').replace('\t', '').replace('\n', '')
		)	
	}
	
	private JFrame makeLoginWindow(String username = null, String password = null) {

		JTextField userField = new JTextField()
		JTextField passwordField = new JTextField()
		if (username != null) userField.text = username
		if (password != null) passwordField.text = password 

		JFrame frame = new JFrame()
		frame.contentPane.add(userField)
		frame.contentPane.add(passwordField)
		return frame
	}
	
	public void testLoginWindow() {
		
		JFrame frame1 = makeLoginWindow()
		JFrame frame2 = makeLoginWindow("some username") 
		JFrame frame3 = makeLoginWindow("some username", "some password")
	}
	
	public void testJavaStyle_LoginWindow() {
		JFrame frame1 = makeLoginWindow2()
		JFrame frame2 = makeLoginWindow2("some username") 
		JFrame frame3 = makeLoginWindow2("some username", "some password")
	}
	
	
	private JFrame makeLoginWindow2() {
		makeLoginWindow2(null, null); 
	}
	private JFrame makeLoginWindow2(String username) {
		makeLoginWindow2(username, null); 
	}
		
	private JFrame makeLoginWindow2(String username, String password) {

		JTextField userField = new JTextField();
		JTextField passwordField = new JTextField();
		if (username != null) userField.setText(username); 
		if (password != null) passwordField.setText(password);  

		JFrame frame = new JFrame();
		frame.contentPane.add(userField);
		frame.contentPane.add(passwordField);
		return frame;
	}
	
}


class Garage {
	List cars

	Garage(Car... cars) {}	
}

class Car {
	String name
	String make

	Car(String x, String y) {}	
}