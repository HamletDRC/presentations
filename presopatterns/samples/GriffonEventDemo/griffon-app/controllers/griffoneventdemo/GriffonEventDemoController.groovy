package griffoneventdemo

class GriffonEventDemoController {
    // these will be injected by Griffon
    def model
    def view

    void mvcGroupInit(Map args) {
        createMVCGroup('Ping', 'ping')
        createMVCGroup('Pong', 'pong')
    }

    def serve = { evt = null ->

        view.serveButton.visible = false

        doOutside { app.event('Ping') }
    }
}
