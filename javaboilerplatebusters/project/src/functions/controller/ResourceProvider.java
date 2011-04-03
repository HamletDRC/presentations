package functions.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ResourceProvider {

	private final ResourceController controller = new ResourceController();
	private final Map<String, String> data = new HashMap<String, String>();

	public String getResource(final String key) throws Exception {
		return controller.withReadLock(new Callable<String>() {
			public String call() throws Exception {
				return data.get(key);
			}
		});
	}

	public void refresh() throws Exception {
		controller.withWriteLock(new Callable<Void>() {
			public Void call() throws Exception {
                System.out.println("Reloading settings...");
				return null;
			}
		});
	}
}
