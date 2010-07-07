package example;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: hdarcy
 * Date: Jul 25, 2009
 * Time: 8:16:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Service {
    static long getFileSize(String path) {
        return new File(path).length();
    }
}
