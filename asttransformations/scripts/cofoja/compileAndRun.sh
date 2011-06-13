# compile the Kettle with the annotation processor
javac \
    -cp cofoja-1.0-20110613.jar \
    -processor com.google.java.contract.core.apt.AnnotationProcessor \
    Kettle.java  \
&& java -ea -javaagent:./cofoja-1.0-20110613.jar Kettle \
&& java \
    -cp cofoja-1.0-20110613.jar \
    -Dcom.google.java.contract.classoutput=compiled \
    com.google.java.contract.core.agent.PreMain \
    Kettle.class
