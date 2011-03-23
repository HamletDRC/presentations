import groovy.swing.*
import javax.swing.*
import java.awt.BorderLayout as BL

count = 0
new SwingBuilder().edt {

  frame(
        title: "Java Frame", 
        size: [300, 300], 
        locationRelativeTo: null, 
        defaultCloseOperation:JFrame.EXIT_ON_CLOSE, 
        show: true) {

    borderLayout()
    myLabel = label(text:"Click the button!", constraints: BL.NORTH)
    button(text:'Click Me',
         actionPerformed: {myLabel.text = "Clicked ${++count} time(s)."},
         constraints:BL.SOUTH)
  }
}


