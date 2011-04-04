package functions.proxy;

import java.util.HashMap;
import java.util.Map;

public class DefaultResourceProvider implements ResourceProvider {

	private final Map<String, String> data = new HashMap<String, String>();

	@WithReadLock
	public String getResource(String key) throws Exception {
		return data.get(key);
	}

	@WithWriteLock
	public void refresh() throws Exception {
		System.out.println("Reloading the settings...");
	}
}
