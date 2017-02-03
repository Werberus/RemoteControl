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

        // создать 2 панели: левая - дерево, правая - рабочая область, хз еще, что там будет :D

        add(MyJTree());
    }

    //TODO - private метод, отвечающий за менюбар
    //TODO - private метод, отвечающий за дерево
    private JTree MyJTree() {
        JTree jtree = new JTree();

        return jtree;
    }
}
