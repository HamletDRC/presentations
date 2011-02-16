package griffoneventdemo

class PongController {

    def model
    def view

    def onPong = { evt = null ->
        doLater { model.message = 'Pong' }
        sleep(1000)
        edt { model.message = '' }
        app.event("Ping")
    }
}
