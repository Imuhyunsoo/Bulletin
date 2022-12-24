package NetBulletin;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {

    Socket socket;
    DataOutputStream out;

    public Sender(Socket socket) {

        try {
            out = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);
        while(out != null) {
            try {
                out.writeUTF(scanner.nextLine());
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
