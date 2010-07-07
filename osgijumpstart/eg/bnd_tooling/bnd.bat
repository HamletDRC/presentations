export hello_bundle=../usablemodularbundle/build/libs/usablemodularbundle-1.0.jar
export osgi_bundle=../../../../osgi/lib/osgi-3.4.0.jar
export groovy_bundle=../../../../osgi/groovylib-1.6/lib/groovy-all-1.6-beta-2.jar

groovyc -d classes --classpath $hello_bundle:$osgi_bundle src/org/bnd/BndActivator.groovy
java -jar ./lib/bnd-0.0.337.jar build -classpath ./classes/,$groovy_bundle,$osgi_bundle -output bnd_tooling-1.0.jar ./build.bnd
