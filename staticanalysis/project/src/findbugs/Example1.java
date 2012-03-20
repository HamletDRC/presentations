package findbugs;

public class Example1 {

	Boolean isTrue(String input) {
		if (input.equals("true")) {
			return true;
		} else if (input.equals("false")) {
			return false;
		}
		return null;
	}

}
