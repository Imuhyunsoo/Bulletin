package NetBulletin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Network extends Thread {

    protected static boolean state = true;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    Bulletin bulletin;

    public Network(Socket socket) {

        try {
            this.socket = socket;
            bulletin = new Bulletin(socket);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


    @Override
    public void run() {

        bulletin.systemRule();
        bulletin.quest();

        while (in != null) {
            try {
                switch(in.readUTF()) {
                    case "0" : out.writeUTF("클라이언트를 종료합니다."); socket.close(); break;
                    case "1" : bulletin.list(); break;
                    case "2" : bulletin.create(); break;
                    case "3" : bulletin.content(); break;
                    case "4" : bulletin.remove(); break;
                    default : out.writeUTF("잘못 입력하셨습니다.");
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
}
