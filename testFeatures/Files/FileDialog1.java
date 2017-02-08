package testFeatures.Files;

import java.awt.*;
import java.awt.event.*;

//Диалоговое окно
@SuppressWarnings("serial")
public class FileDialog1 extends Frame {
    FileDialog1(String title){
        super(title);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}