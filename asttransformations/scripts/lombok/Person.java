import lombok.*;

@Data
public class Person {

    String firstName; 
    String lastname;   

    @Synchronized
    void doit() {
        System.out.println("whatever");
    }
}

