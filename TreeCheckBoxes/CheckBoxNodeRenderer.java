package TreeCheckBoxes;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class CheckBoxNodeRenderer implements TreeCellRenderer {
    private final JPanel panel = new JPanel(new BorderLayout());
    private final TriStateCheckBox checkBox = new TriStateCheckBox();
    private final DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();

    @Override public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        JLabel l = (JLabel) renderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        l.setFont(tree.getFont());
        if (value instanceof DefaultMutableTreeNode) {
            panel.setFocusable(false);
            panel.setRequestFocusEnabled(false);
            panel.setOpaque(false);
            checkBox.setEnabled(tree.isEnabled());
            checkBox.setFont(tree.getFont());
            checkBox.setFocusable(false);
            checkBox.setOpaque(false);
            Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
            if (userObject instanceof CheckBoxNode) {
                CheckBoxNode node = (CheckBoxNode) userObject;
                if (node.status == Status.INDETERMINATE) {
                    checkBox.setIcon(new IndeterminateIcon());
                } else {
                    checkBox.setIcon(null);
                }
                l.setText(node.label);
                checkBox.setSelected(node.status == Status.SELECTED);
            }
            panel.add(checkBox, BorderLayout.WEST);
            panel.add(l);
            return panel;
        }
        return l;
    }
}