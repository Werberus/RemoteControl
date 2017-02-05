import TreeCheckBoxes.*;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;

public class RemoteControl extends JPanel {
    // TODO - получать эти данные из конфига - раз, запихиваит эти данные в конфиг через ГУИ - два
    private final String root = "Российская Федерация";
    private final String[] folders = new String[]  {"МР Дальний Восток", "МР Приволжье", "МР Северо-Запад", "МР Сибирь", "МР Урал", "МР Центр", "МР Юг"};
    private final String[][] elements = new String[][]{{"Благовещенск", "Бурятия", "Владивосток", "Иркутск", "Комсомольск-на-Амуре", "Петропавловск-Камчатский", "Чита"}, {"Арзамас", "Балаково", "Ижевск", "Казань", "Киров", "Марий-Эл", "Нижний Новгород", "Оренбург", "Пенза",  "Самара", "Саратов", "Ульяновск", "Уфа"}, {"Великий Новгород", "Вологда", "Коряжма", "Мирный",  "Санкт-Петербург", "Северодвинск"}, {"Барнаул", "Кемерово", "Новокузнецк", "Новосибирск", "Норильск", "Омск"}, {"Екатеринбург", "Курган", "Пермь", "Тюмень", "ХМАО", "Челябинск", "ЯНАО"}, {"Белгород", "Владимир", "Воронеж", "Иваново", "Калуга", "Курск", "Орел", "Рязань", "Смоленск",  "Тамбов", "Тверь", "Тула", "Ярославль"}, {"Волгоград", "Краснодар", "Ростов"}};

    JLabel test = new JLabel("SomeText");

    private RemoteControl() {
        super(new GridLayout(1, 2));
        TreeModel model = createTreeModel();
        JTree tree = new JTree(model) {
            @Override public void updateUI() {
                setCellRenderer(null);
                setCellEditor(null);
                super.updateUI();
                setCellRenderer(new CheckBoxNodeRenderer());
                setCellEditor(new CheckBoxNodeEditor());
            }
        };
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        Enumeration<?> e = root.breadthFirstEnumeration();
        while (e.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
            node.setUserObject(new CheckBoxNode(Objects.toString(node.getUserObject(), ""), Status.DESELECTED));
        }
        model.addTreeModelListener(new CheckBoxStatusUpdateListener());
        tree.setEditable(true);
        tree.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        tree.expandRow(0);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(new JScrollPane(tree));
        add(new JScrollPane(test));
        setPreferredSize(new Dimension(320, 240));
    }



    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreateAndShowGUI();
            }
        });
    }

    public static void CreateAndShowGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        JFrame frame = new JFrame("@title@");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RemoteControl());
        //frame.setContentPane(new RemoteControl());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private TreeModel createTreeModel() {
        // Корневой узел дерева
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(this.root);
        // Добавление ветвей - потомков 1-го уровня
        DefaultMutableTreeNode dv = new DefaultMutableTreeNode(folders[0]);
        DefaultMutableTreeNode pv = new DefaultMutableTreeNode(folders[1]);
        DefaultMutableTreeNode sz = new DefaultMutableTreeNode(folders[2]);
        DefaultMutableTreeNode sib = new DefaultMutableTreeNode(folders[3]);
        DefaultMutableTreeNode ural = new DefaultMutableTreeNode(folders[4]);
        DefaultMutableTreeNode centr1 = new DefaultMutableTreeNode(folders[5]);
        DefaultMutableTreeNode ug = new DefaultMutableTreeNode(folders[6]);
        // Добавление ветвей к корневой записи
        root.add(dv);
        root.add(pv);
        root.add(sz);
        root.add(sib);
        root.add(ural);
        root.add(centr1);
        root.add(ug);
        // Добавление листьев - потомков 2-го уровня
        for (int i = 0; i < elements[0].length; i++)
            dv.add(new DefaultMutableTreeNode(elements[0][i], false));
        for (int i = 0; i < elements[1].length; i++)
            pv.add(new DefaultMutableTreeNode(elements[1][i], false));
        for (int i = 0; i < elements[2].length; i++)
            sz.add(new DefaultMutableTreeNode(elements[2][i], false));
        for (int i = 0; i < elements[3].length; i++)
            sib.add(new DefaultMutableTreeNode(elements[3][i], false));
        for (int i = 0; i < elements[4].length; i++)
            ural.add(new DefaultMutableTreeNode(elements[4][i], false));
        for (int i = 0; i < elements[5].length; i++)
            centr1.add(new DefaultMutableTreeNode(elements[5][i], false));
        for (int i = 0; i < elements[6].length; i++)
            ug.add(new DefaultMutableTreeNode(elements[6][i], false));
        // Создание стандартной модели
        return new DefaultTreeModel(root);
    }
}