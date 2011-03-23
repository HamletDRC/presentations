import javax.swing.*
import javax.swing.tree.DefaultMutableTreeNode as TreeNode
import groovy.swing.SwingBuilder

JTree mboxTree
new SwingBuilder().

    frame(
        title: 'Mailer', 
        defaultCloseOperation: JFrame.DISPOSE_ON_CLOSE,
        size: [800, 600], 
        show: true, 
        locationRelativeTo: null) {

    lookAndFeel('system')

    menuBar() {
        menu(text: 'File', mnemonic: 'F') {
            menuItem(text: 'Exit', mnemonic: 'X', actionPerformed: { dispose() })
        }
    }

    splitPane {
        scrollPane(constraints: 'left', preferredSize: [160, -1]) {
            mboxTree = tree(rootVisible: false)
        }
        splitPane(orientation:JSplitPane.VERTICAL_SPLIT, dividerLocation:280) {
            scrollPane(constraints: 'top') { mailTable = table() }
            scrollPane(constraints: 'bottom') { textArea() }
        }
    }

    ['From', 'Date', 'Subject'].each { mailTable.model.addColumn(it) }
}

mboxes = [
    [name: 'root@example.com', folders: [[name: 'Inbox'], [name: 'Trash'], [name: 'Sent'], [name: 'Junk'] ]],
    [name: 'test@foo.com', folders: [[name: 'Inbox'], [name: 'Trash'], [name: 'Sent'], [name: 'Junk']]]
]

mboxTree.model.root.removeAllChildren()
mboxes.each {mbox ->
    def node = new TreeNode(mbox.name)
    mbox.folders.each { folder -> node.add(new TreeNode(folder.name)) }
    mboxTree.model.root.add(node)
}
mboxTree.model.reload(mboxTree.model.root)
