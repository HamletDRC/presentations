@Lazy
import java.sql.Connection
import static java.sql.DriverManager.*

class Person {
    @Lazy
    def connection = getConnection('jdbc:odbc:dummy', 'sa', '')
}


new Person()