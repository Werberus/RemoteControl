package TreeCheckBoxes;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;

public class CheckBoxNodeEditor extends AbstractCellEditor implements TreeCellEditor {
    private final JPanel panel = new JPanel(new BorderLayout());
    private final TriStateCheckBox checkBox = new TriStateCheckBox() {
        private transient ActionListener handler;
        @Override public void updateUI() {
            removeActionListener(handler);
            super.updateUI();
            setOpaque(false);
            setFocusable(false);
            handler = e -> stopCellEditing();
            addActionListener(handler);
        }
    };
    private final DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    private String str;

    @Override public Component getTreeCellEditorComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row) {
        JLabel l = (JLabel) renderer.getTreeCellRendererComponent(tree, value, true, expanded, leaf, row, true);
        l.setFont(tree.getFont());
        if (value instanceof DefaultMutableTreeNode) {
            panel.setFocusable(false);
            panel.setRequestFocusEnabled(false);
            panel.setOpaque(false);
            checkBox.setEnabled(tree.isEnabled());
            checkBox.setFont(tree.getFont());
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
                str = node.label;
            }
            panel.add(checkBox, BorderLayout.WEST);
            panel.add(l);
            return panel;
        }
        return l;
    }
    @Override public Object getCellEditorValue() {
        return new CheckBoxNode(str, checkBox.isSelected() ? Status.SELECTED : Status.DESELECTED);
    }
    @Override public boolean isCellEditable(EventObject e) {
        if (e instanceof MouseEvent && e.getSource() instanceof JTree) {
            Point p = ((MouseEvent) e).getPoint();
            JTree tree = (JTree) e.getSource();
            TreePath path = tree.getPathForLocation(p.x, p.y);
            return Optional.ofNullable(tree.getPathBounds(path)).map(r -> {
                r.width = checkBox.getPreferredSize().width;
                return r.contains(p);
            }).orElse(false);
        }
        return false;
    }
}