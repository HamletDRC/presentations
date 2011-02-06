package griffoneventdemo

class PingController {

    def model
    def view

    def onPing = { evt = null ->
        doLater {
            model.message = 'Ping'
        }

        sleep(1000)
        edt {
            model.message = ''
        }
        app.event("Pong")
    }
}
