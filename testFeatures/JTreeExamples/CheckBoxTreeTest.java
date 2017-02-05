package testFeatures.JTreeExamples;

import javax.swing.*;
import javax.swing.tree.*;

public class CheckBoxTreeTest extends JFrame 
{
	private static final long serialVersionUID = 1L;
	final   String     ROOT  = "Корневая запись";
	// Массив листьев деревьев
	final   String[]   nodes = new String[]  {"Напитки", "Сладости"};
	final   String[][] leafs = new String[][]{{"Чай", "Кофе", "Коктейль", "Сок", "Морс", "Минералка"},
			                                  {"Пирожное", "Мороженое", "Зефир", "Халва"}};
	public CheckBoxTreeTest()
	{
		super("Пример JTree с флажками");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Создание модели дерева
		TreeModel model = createTreeModel();
		// Создание дерева
		CheckBoxTree tree = new CheckBoxTree(model);
		// Размещение дерева в интерфейсе
		getContentPane().add(new JScrollPane(tree));
		// Вывод окна на экран
		setSize(400, 300);
		setVisible(true);
	}
	// Иерархическая модель данных TreeModel для деревьев
	private TreeModel createTreeModel()
	{
		// Корневой узел дерева
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(ROOT);
		// Добавление ветвей - потомков 1-го уровня
		DefaultMutableTreeNode drink = new DefaultMutableTreeNode(nodes[0]);
		DefaultMutableTreeNode sweet = new DefaultMutableTreeNode(nodes[1]);
		// Добавление ветвей к корневой записи
		root.add(drink);
		root.add(sweet);
		// Добавление листьев - потомков 2-го уровня
		for ( int i = 0; i < leafs[0].length; i++)
			drink.add(new DefaultMutableTreeNode(new CheckBoxElement(false, leafs[0][i])));
		for ( int i = 0; i < leafs[1].length; i++)
			sweet.add(new DefaultMutableTreeNode(new CheckBoxElement(false, leafs[1][i])));
		// Создание стандартной модели
		return new DefaultTreeModel(root);
	}
	public static void main(String[] args) {
		new CheckBoxTreeTest();
	}
}
