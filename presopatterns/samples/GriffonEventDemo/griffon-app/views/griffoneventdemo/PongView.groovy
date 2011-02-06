package griffoneventdemo

view = hbox {

    label(text: bind {model.message})
    label(icon: imageIcon('/pingpong2.png'))
}
