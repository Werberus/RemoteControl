package testFeatures.Files;

import java.awt.*;
import java.awt.Frame;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
//import javax.swing.tree.DefaultMutableTreeNode;

// Вызывается из главной функции, вызывает
//	функцию шифрования и создания файла
public class FormFail extends JFrame {
    private static final long serialVersionUID = 1L;
    String host;
    String User;
    String port;
    String pass;
    String FailName;
    FormFail() {
        //super();
        JFrame jf= new JFrame("Save Server");
        //jf.setLayout(new FlowLayout(FlowLayout.CENTER));
        jf.setLayout(null);
        jf.setSize(400,250);
        jf.setLocation(500, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField jt = new JTextField(20); // login
        jt.setLocation(30, 30);
        //	JTextField jt2 = new JTextField(20); // pass
        JPasswordField jt2 = new JPasswordField(20);
        JTextField jt3 = new JTextField(20);
        JTextField jt4 = new JTextField(20);
        JTextField jt5 = new JTextField(20);

        JButton b1 = new JButton("Write");
        b1.setLocation(60, 140);
        b1.setSize(120, 40);

        JButton b2 = new JButton("Brow");
        b2.setLocation(190, 120);
        b2.setSize(70, 20);

        JLabel l = new JLabel("User");
        l.setLocation(10, 20);
        l.setSize(40, 20);
        jf.add(l);

        jt.setLocation(60, 20);
        jt.setSize(120, 20);

        l = new JLabel("Pass");
        l.setLocation(10, 45);
        l.setSize(40, 20);
        jf.add(l);

        jt2.setLocation(60, 45);
        jt2.setSize(120, 20);

        l = new JLabel("Port");
        l.setLocation(10, 70);
        l.setSize(40, 20);
        jf.add(l);

        jt3.setLocation(60, 70);
        jt3.setSize(120, 20);

        l = new JLabel("Host ip");
        l.setLocation(10, 95);
        l.setSize(40, 20);
        jf.add(l);

        jt4.setLocation(60, 95);
        jt4.setSize(120, 20);

        l = new JLabel("Путь");
        l.setLocation(10, 120);
        l.setSize(40, 20);
        jf.add(l);

        jt5.setLocation(60, 120);
        jt5.setSize(120, 20);

        jf.add(jt);
        jf.add(jt2);
        jf.add(jt3);
        jf.add(jt4);
        jf.add(jt5);
        jf.add(b1);
        jf.add(b2);
        jf.setVisible(true);

        b1.addActionListener(new ActionListener(){
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent ae) {
                FailName = jt5.getText(); // путь до файла
                host = jt4.getText();
                User = jt.getText();
                port = jt3.getText();
                pass = jt2.getText();
                try {
                    new Encryp(User,  host,  port,  pass, FailName);
                } catch (FileNotFoundException e) {
                    // TODO Автоматически созданный блок catch
                    e.printStackTrace();
                }}
        });

        b2.addActionListener(new ActionListener(){
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent ae) {
                FileDialog fd = new FileDialog(jf, "123124");
                fd.setVisible(true);
                jt5.setText(fd.getDirectory() + fd.getFile());
            }
        });
    }
}