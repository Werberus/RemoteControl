package testFeatures;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeTest extends JFrame implements TreeSelectionListener {

    private static final long serialVersionUID = 1L;
    private JTree tree; // наше дерево
    private JTextField jtf = new JTextField();

    public JTreeTest() {
        // ------------------------------------------
        // добавление и настройка компонент
        Container c = getContentPane(); // клиентская область окна
        c.setLayout(new BorderLayout()); // выбираем компоновщик

        //-------------------------------------------
        // построение дерева
        // корневая ветка
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        // создание трех дочерних веток
        DefaultMutableTreeNode lvl1node1 = new DefaultMutableTreeNode(
                "lvl1node1"); // будет листом
        DefaultMutableTreeNode lvl1node2 = new DefaultMutableTreeNode(
                "lvl1node2"); // будет веткой
        DefaultMutableTreeNode lvl1node3 = new DefaultMutableTreeNode(
                "lvl1node3"); // будет листом

        // добавление их корневой ветке
        root.add(lvl1node1);
        root.add(lvl1node2);
        root.add(lvl1node3);

        // добавляем дочерние элементы (листья) второй ветке
        lvl1node2.add(new DefaultMutableTreeNode("lvl2node2_node1"));
        lvl1node2.add(new DefaultMutableTreeNode("lvl2node2_node2"));
        lvl1node2.add(new DefaultMutableTreeNode("lvl2node2_node3"));

        // создаем элемент управления с указанным деревом данных
        tree = new JTree(root);
        tree.addTreeSelectionListener(this);

        // добавляем элементы управления в окно
        c.add(new JScrollPane(tree));
        c.add(jtf, BorderLayout.SOUTH);

        // -------------------------------------------
        // настройка окна
        setTitle("JTreeTest"); // заголовок окна
        // желательные размеры окна
        setPreferredSize(new Dimension(640, 480));
        // завершить приложение при закрытии окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // устанавливаем желательные размеры
        setVisible(true); // отображаем окно
    }

    // запуск оконного приложения
    public static void main(String args[]) {
        new JTreeTest();
    }

    // метод интерфейса TreeSelectionListener
    public void valueChanged(TreeSelectionEvent arg0) {
        jtf.setText("old selection: "
                + arg0.getOldLeadSelectionPath()
                + ";  new selection: "
                // второй раз явно преобразовываем в строку методом toString
                + arg0.getNewLeadSelectionPath().toString());
    }

}