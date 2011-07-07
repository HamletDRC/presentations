package eg07_mapimpl

import groovy.swing.SwingBuilder
import java.awt.event.MouseListener
import javax.swing.JFrame

def b
new SwingBuilder().frame(
        size: [300, 300],
        show: true,
        defaultCloseOperation: JFrame.EXIT_ON_CLOSE) {
    b = button(text: 'Click Me')
}

b.addMouseListener(
        [ mouseClicked: { println 'clicked!' }
        ] as MouseListener)
