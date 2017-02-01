import com.jcraft.jsch.*;
import java.io.InputStream;

class ConnectionSSH extends Thread {
    private String username;
    private String host;
    private int port;
    private String password; // шифровать?
    ConnectionSSH(String username, String host, int port, String password) {
        this.username = username;
        this.host = host;
        this.port = port;
        this.password = password;
        Thread t = new Thread(this, host);
        t.start();
    }

    public void run() {
        executeSSH();
    }

    private void executeSSH() {
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            String[] command = commands();
            for (String aCommand : command) {
                JSch jsch = new JSch(); // от этого все пляшет
                Session session = jsch.getSession(username, host, port); // сессия вида ssh -p 22 username@host
                session.setPassword(password); // пароль
                // TODO - переделать пароль, хранить шифрованным

                session.setConfig(config);
                session.connect();
                Channel channel = session.openChannel("exec");
                ((ChannelExec) channel).setCommand(aCommand);
                channel.setInputStream(null);
                ((ChannelExec) channel).setErrStream(System.err);
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
                        if (in.available() > 0) continue;
                        System.out.println(host + "exit-status: " + channel.getExitStatus());
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String[] commands() {
        return new String[]{"echo test > ~/test111", "echo test2 > ~/test123", "echo test2 > ~/test123", "echo test2 > ~/test123", "echo test2 > ~/test123", "echo test2 > ~/test123", "echo test2 > ~/test123", "echo test2 > ~/test123", "echo test2 > ~/test123", "echo test2 > ~/test123", "echo test2 > ~/test123", "echo test2 > ~/test123", "echo test2 > ~/test123", "echo test2 > ~/test123", "echo test2 > ~/test123"};
    }
}