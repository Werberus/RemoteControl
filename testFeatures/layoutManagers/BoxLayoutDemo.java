// TODO - посмотри, как я сделан!

package testFeatures.layoutManagers;

import java.awt.Component;
import java.awt.Container;
import javax.swing.*;

public class BoxLayoutDemo {
    private static void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        addAButton("Button 1", pane);
        addAButton("Button 2", pane);
        addAButton("Button 3", pane);
        addAButton("Long-Named Button 4", pane);
        addAButton("5", pane);
    }

    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

    private static void createAndShowGUI() {
        // Создание фрейма
        JFrame frame = new JFrame("BoxLayoutDemo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[ ] args) {
        // запустить приложение
        javax.swing.SwingUtilities.invokeLater(BoxLayoutDemo::createAndShowGUI);
    }
}