import com.jcraft.jsch.JSch;

public class ConnectionSSH {

    String host;
    String user;
    int port;

    // вызываем SSH-коннект: ConnectionSSH(user, host, port)
    public ConnectionSSH(String user, String host, int port) {
        this.user = user;
        this.host = host;
        this.port = port;
    }

    public void connect() {
        JSch jsch = new JSch();



    }
}
