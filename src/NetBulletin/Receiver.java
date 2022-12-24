package NetBulletin;

import java.io.DataInputStream;
import java.net.Socket;

public class Receiver extends Thread {

    Socket socket;
    DataInputStream in;


    public Receiver(Socket socket) {

        try {
            in = new DataInputStream(socket.getInputStream());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void run() {

        while (in != null) {
            try {
                System.out.println(in.readUTF());
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
