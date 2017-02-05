package TreeCheckBoxes;

import java.util.*;
import javax.swing.*;

class TriStateCheckBox extends JCheckBox {
    @Override public void updateUI() {
        Icon currentIcon = getIcon();
        setIcon(null);
        super.updateUI();
        if (Objects.nonNull(currentIcon)) {
            setIcon(new IndeterminateIcon());
        }
        setOpaque(false);
    }
}