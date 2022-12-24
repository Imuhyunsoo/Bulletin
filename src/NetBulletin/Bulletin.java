package NetBulletin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bulletin {

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    static List<Content> list = new ArrayList<>();

    public Bulletin(Socket socket) {

        try {
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void systemRule() {

        try {
            out.writeUTF("==================================================");
            out.writeUTF("번호 제목 작성자   작성일");
            out.writeUTF("----------------- Bulletin -----------------------");
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void quest() {

        try {
            out.writeUTF("1.목록 2.등록 3.내용 4.삭제 0.종료 >> ");
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void create() {

        list.add(new Content(socket));
        quest();
    }

    public void list() {

        int count = 1;
        systemRule();

        try {
            for (Iterator<Content> itr = list.iterator(); itr.hasNext(); ) {
                out.writeUTF(count + "\t" + itr.next().getTitle());
                count++;
            } quest();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean quit() {

        try {
            out.writeUTF("게시판이 종료됩니다.");
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public void content() {

        list();
        try {
            out.writeUTF("위에 게시판 번호중 하나를 넣어 주세요. >> ");
            String inputNum = in.readUTF();
            int intNum = Integer.parseInt(inputNum);
            systemRule();
            out.writeUTF(inputNum + "\t" + list.get(--intNum).getContent());
            quest();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void remove() {

        list();
        try {
            out.writeUTF("위에 게시판 번호중 제거할 글을 숫자로 하나를 넣어 주세요. >> ");
            String inputNum = in.readUTF();
            int intNum = Integer.parseInt(inputNum);
            list.remove(intNum - 1);
            out.writeUTF("해당 게시판을 삭제하였습니다.");
            quest();
        } catch (Exception e) { e.printStackTrace(); }
    }
}

