import javax.swing.*;

public class RemoteControl {
    public static void main(String args[]) {
        //int foo = Integer.parseInt("1234");
        //http://www.javenue.info/post/41
        /*new ConnectionSSH("root", "10.34.30.48", 22, "Cthdth@11");
        new ConnectionSSH("mtsgis", "10.34.30.60", 22, "Cthdth@11");*/
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WindowForm().setVisible(true);
            }
        });
    }
}