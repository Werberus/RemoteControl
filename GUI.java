import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class GUI extends JFrame {
    public GUI() {
        super("RemoteControl");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800,600));
        pack();
        setLocationRelativeTo(null);
        setJMenuBar(menu());
    }

    private JTree treeStruct() {
        JTree tree = new JTree();

        // Корневая ветка
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Корень");

        // лвл1
        DefaultMutableTreeNode lvl11 = new DefaultMutableTreeNode("Папка1.1");
        DefaultMutableTreeNode lvl12 = new DefaultMutableTreeNode("Папка1.2");
        DefaultMutableTreeNode lvl13 = new DefaultMutableTreeNode("Папка1.3");

        //лвл2 - сами объекты


        return tree;
    }

    private JMenuBar menu() {
        JMenuBar bar = new JMenuBar();

        JMenu File = new JMenu("File");
        JMenuItem Close = new JMenuItem("Close");

        File.add(Close);
        bar.add(File);

        return bar;
    }

}
