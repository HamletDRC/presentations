application {
    title = 'GriffonEventDemo'
    startupGroups = ['GriffonEventDemo']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "Pong"
    'Pong' {
        model = 'griffoneventdemo.PongModel'
        controller = 'griffoneventdemo.PongController'
        view = 'griffoneventdemo.PongView'
    }

    // MVC Group for "Ping"
    'Ping' {
        model = 'griffoneventdemo.PingModel'
        controller = 'griffoneventdemo.PingController'
        view = 'griffoneventdemo.PingView'
    }

    // MVC Group for "GriffonEventDemo"
    'GriffonEventDemo' {
        model = 'griffoneventdemo.GriffonEventDemoModel'
        controller = 'griffoneventdemo.GriffonEventDemoController'
        view = 'griffoneventdemo.GriffonEventDemoView'
    }

}
