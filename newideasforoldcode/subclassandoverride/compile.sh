javac domain/UserDTO.java
javac domain/User.java
javac domain/DataSource.java
javac original/UserService.java
groovyc groovy/UserService.groovy
groovy -cp .:original groovy/UserServiceTest.groovy
javac javaexample/UserService.java
javac -cp .:../../../lib/junit-4.4.jar javaexample/UserServiceTest.java
java -cp .:../../../lib/junit-4.4.jar org.junit.runner.JUnitCore javaexample.UserServiceTest
