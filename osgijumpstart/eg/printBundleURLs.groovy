
new File ('.').eachDirRecurse { dir -> 
  if (dir.getName() == 'libs') {
    dir.eachFileMatch (~/.*\.jar/) { file -> 
      println "install " + file.toURL()
    } 
  }
} 
def groovy = new File("../../../../osgi/groovylib-1.6/lib/groovy-all-1.6-beta-2.jar")
println "install " + groovy.toURL()
