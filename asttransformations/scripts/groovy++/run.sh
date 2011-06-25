
groovyc slow.groovy -cp $HOME/.groovy/grapes/org.mbte.groovypp/groovypp/jars/groovypp-0.4.248_1.8.0.jar:$HOME/.groovy/grapes/org.mbte.groovypp/groovypp-all/jars/groovypp-all-0.4.248_1.8.0.jar

java -cp .:$HOME/.groovy/grapes/org.mbte.groovypp/groovypp/jars/groovypp-0.4.248_1.8.0.jar:$HOME/.groovy/grapes/org.mbte.groovypp/groovypp-all/jars/groovypp-all-0.4.248_1.8.0.jar:$HOME/dev/groovy-1.8.x/target/install/embeddable/groovy-all-1.8.1-SNAPSHOT.jar example.slow


