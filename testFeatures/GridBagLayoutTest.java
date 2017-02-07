package testFeatures;

import java.awt.*;
import javax.swing.*;

class GridBagLayoutTest extends JFrame
{
    public GridBagLayoutTest() {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        getContentPane().setLayout(gridbag);

        c.fill = GridBagConstraints.BOTH;
        // Попробуйте убрать эту строку
        c.weightx = 1.0;
        makebutton("Button1", gridbag, c);
        makebutton("Button2", gridbag, c);
        makebutton("Button3", gridbag, c);

        c.gridwidth = GridBagConstraints.REMAINDER; //конец строки
        makebutton("Button4", gridbag, c);

        c.weightx = 0.0;     // вернуть к значению по умолчанию
        makebutton("Button5", gridbag, c); //другая строка

        // Попробуйте закрыть эту строку и открыть следующюю за ней
        c.gridwidth = GridBagConstraints.RELATIVE; //предпоследний элемент
        //c.gridwidth = 1;
        makebutton("Button6", gridbag, c);

        c.gridwidth = GridBagConstraints.REMAINDER; //конец строки
        makebutton("Button7", gridbag, c);

        c.gridwidth = 1;        //установить значение по умолчанию
        c.gridheight = 2;
        // Попробуйте убрать эту строку
        c.weighty = 1.0;
        makebutton("Button8", gridbag, c);

        // Попробуйте убрать эту строку
        c.weighty = 0.0;     //установить значение по умолчанию
        c.gridwidth = GridBagConstraints.REMAINDER; //конец строки
        c.gridheight = 1;     //установить значение по умолчанию
        makebutton("Button9", gridbag, c);
        makebutton("Button10", gridbag, c);

        setBounds(100,100,600,400);
    }

    protected void makebutton(String name, GridBagLayout gridbag, GridBagConstraints c)
    {
        Button button = new Button(name);
        gridbag.setConstraints(button, c);
        getContentPane().add(button);
    }

    public static void main(String[] args)
    {
        GridBagLayoutTest flt = new GridBagLayoutTest();
        flt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flt.setVisible(true);
    }
}