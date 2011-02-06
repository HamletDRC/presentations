package griffoneventdemo

view = hbox {

    label(icon: imageIcon('/pingpong.png'))
    label(text:bind {model.message})
}
