package inspections;

import java.io.FileReader;
import java.io.IOException;

public class Example02 {

    int readFirst(String path) throws IOException {

        FileReader reader = new FileReader(path);
        try {
            return reader.read();
        } finally {
            reader.close();
        }
    }


}