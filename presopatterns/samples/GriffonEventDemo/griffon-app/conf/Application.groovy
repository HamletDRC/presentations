application {
    title = 'GriffonEventDemo'
    startupGroups = ['GriffonEventDemo']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "GriffonEventDemo"
    'GriffonEventDemo' {
        model = 'griffoneventdemo.GriffonEventDemoModel'
        controller = 'griffoneventdemo.GriffonEventDemoController'
        view = 'griffoneventdemo.GriffonEventDemoView'
    }

}
