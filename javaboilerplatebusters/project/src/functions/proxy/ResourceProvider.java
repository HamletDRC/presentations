
package functions.proxy;

public interface ResourceProvider {

	String getResource(String key) throws Exception;

	void refresh() throws Exception;
}
