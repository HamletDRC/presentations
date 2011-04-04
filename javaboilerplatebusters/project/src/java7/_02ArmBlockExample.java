package java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Hamlet D'Arcy
 */
public class _02ArmBlockExample {

    String readFirstLineFromFile_old(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));

        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    String readFirstLineFromFile(String path) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    String readResource() throws Exception {

        try (MyResource resource = new MyResource()) {
            return resource.getResource();
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
}
