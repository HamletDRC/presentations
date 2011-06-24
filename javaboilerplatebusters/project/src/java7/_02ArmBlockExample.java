package java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Hamlet D'Arcy
 */
public class _02ArmBlockExample {

    int readFirst_old(String path) throws IOException {

        FileReader reader = new FileReader(path);
        try {
            return reader.read();
        } finally {
            reader.close();
        }
    }





    private static class MyResource implements AutoCloseable {

        String getResource() {
            return "some resource";
        }

        @Override
        public void close() throws Exception {
            System.out.println("Whee... closing.");
        }
    }

    String readResource() throws Exception {

        try (MyResource resource = new MyResource()) {
            return resource.getResource();
        }
    }

    int readFirst(String path) throws IOException {

        try (FileReader reader = new FileReader(path)) {
            return reader.read();
        }
    }

}
