package findbugs;

public class Example2 {

	private Object state;

	private synchronized void setState(Object state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Example2{ state=" + state + '}';
	}
}
