import groovy.swing.*
import groovy.beans.Bindable
import javax.swing.*

class MyModel {
   @Bindable int count = 0
}

def model = new MyModel()
new SwingBuilder().edt {
  frame(
        title: "Java Frame", 
        size: [300, 100], 
        locationRelativeTo: null, 
        defaultCloseOperation:JFrame.EXIT_ON_CLOSE, 
        show: true) {

    gridLayout(cols: 1, rows: 2)
    label(text: bind(
            source: model, 
            sourceProperty: "count", 
            converter: { v ->  v? "Clicked $v times": ''})
    )
    button("Click me!", actionPerformed: { model.count++ })
  }
}
