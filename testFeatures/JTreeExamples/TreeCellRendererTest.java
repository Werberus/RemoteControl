package testFeatures.JTreeExamples;

// Пример использования стандартного отображащего объекта DefaultTreeCellRenderer
import javax.swing.*;
import javax.swing.tree.*;

public class TreeCellRendererTest extends JFrame
{
	private static final long serialVersionUID = 1L;
	final   String     ROOT  = "<html><font color=blue>Корневая запись";
	// Массив листьев деревьев
	final   String[]   nodes = new String[]  {"<html><pre>Напитки", "Сладости", "Фрукты"};
	final   String[][] leafs = new String[][]{{"Чай", "Кофе", "Коктейль", "Сок", "Морс", "Минералка"},
			                                  {"<html><i>Пирожное", "<html><i>Мороженое", 
		                                       "<html><b>Зефир", "<html><b>Халва"},
		                                      {"Груша"}};
	public TreeCellRendererTest()
	{
		super("Пример TreeCellRenderer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Создание модели дерева
		JTree tree = new JTree(createTreeModel());
		// Создание и настройка отображающего объекта
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon  (new ImageIcon("images/man.png"));
		renderer.setOpenIcon  (new ImageIcon("images/woman.png"));
		renderer.setClosedIcon(new ImageIcon("images/star.png"));
		// Определение в дереве отображающего объекта
		tree.setCellRenderer(renderer);
		// Размещение дерева в интерфейсе
		getContentPane().add(new JScrollPane(tree));
		setSize(300, 300);
		// Вывод окна на экран
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
		DefaultMutableTreeNode fruit = new DefaultMutableTreeNode(nodes[2], true);
		// Добавление ветвей к корневой записи
		root.add(drink);
		root.add(sweet);
		root.add(fruit);
		// Добавление листьев - потомков 2-го уровня
		for ( int i = 0; i < leafs[0].length; i++)
			drink.add(new DefaultMutableTreeNode(leafs[0][i], false));
		for ( int i = 0; i < leafs[1].length; i++)
			sweet.add(new DefaultMutableTreeNode(leafs[1][i], false));
		for ( int i = 0; i < leafs[2].length; i++)
			fruit.add(new DefaultMutableTreeNode(leafs[2][i], false));
		// Создание стандартной модели
		return new DefaultTreeModel(root);
	}
	public static void main(String[] args) {
		new TreeCellRendererTest();
	}
}
