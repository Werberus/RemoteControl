import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

class WindowForm extends JFrame {
    WindowForm() {
        super("RemoteControl");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800,600));
        setLocationRelativeTo(null);
        pack();
        add(MyJTree());
    }

    //TODO - private метод, отвечающий за менюбар
    //TODO - private метод, отвечающий за дерево
    private JTree MyJTree() {
        JTree jtree = new JTree();

        return jtree;
    }
}
