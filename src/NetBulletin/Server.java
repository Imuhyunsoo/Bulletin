package NetBulletin;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(2800);

            while(true) {
                socket = serverSocket.accept();

                Network network = new Network(socket);

                network.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}