package functions.controller

import java.util.concurrent.Callable;

public class GroovyResourceProvider {

	private final ResourceController controller = new ResourceController();
	private final Map<String, String> data = new HashMap<String, String>();

	public String getResource(final String key) throws Exception {
		controller.withReadLock({ data.get(key) } as Callable);
	}

	public void refresh() throws Exception {
		controller.withWriteLock({
            System.out.println("Reloading settings...");
			return null;
		} as Callable);
	}
}
