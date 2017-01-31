import com.jcraft.jsch.*;

import java.io.InputStream;

public class testConnectionSSH {
    private String username;
    private String host;
    private int port;
    private String password; // ???
    public testConnectionSSH(String username, String host, int port, String password) {
        this.username = username;
        this.host = host;
        this.port = port;
        this.password = password;
        executeSSH();
    }


    /**
     * java.util.Properties config = new java.util.Properties();
     config.put("StrictHostKeyChecking", "no");
     session.setConfig(config);
     */


    private void executeSSH() {
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");


            JSch jsch = new JSch(); // от этого все пляшет
            Session session = jsch.getSession(username, host, port); // сессия вида ssh -p 22 username@host
            //session.setHost(host);
            //session.setPort(port);
            session.setPassword(password); // пароль
            session.setConfig(config);
            String command = "ifconfig > /root/ifcfgout.txt"; // команда на выполнение

            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            channel.setInputStream(null);

            ((ChannelExec)channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();

            channel.connect();

            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    if(in.available() > 0) continue;
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }

            channel.disconnect();
            session.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }




        /*System.out.println(username);
        System.out.println(host);
        System.out.println(port);
        System.out.println(password);*/
    }
}
