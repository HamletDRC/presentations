package griffoneventdemo

import java.awt.BorderLayout

application(title: 'GriffonEventDemo',
  size: [820,480],
  location: [50,50],
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {


    vbox {
        serveButton = button('Serve', actionPerformed: controller.&serve)
        panel {
            borderLayout()
            widget(app.views.ping.view, constraints: BorderLayout.WEST)
            widget(app.views.pong.view, constraints: BorderLayout.EAST)
        }
    }
}
