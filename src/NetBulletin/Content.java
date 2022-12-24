package NetBulletin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Content { // 게시글 만들기

    private String title;
    private String content;
    private String writer;
    private String day;
    DataOutputStream out;
    DataInputStream in;

    public Content(Socket socket) { // 게시글 생성

        try {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

            out.writeUTF("제목 >>");
            this.title = in.readUTF();
            out.writeUTF("내용 >> ");
            this.content = in.readUTF();
            out.writeUTF("작성자 >> ");
            this.writer = in.readUTF();
            LocalDateTime now = LocalDateTime.now();
            day = now.format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 HH시 mm분 ss초"));
            out.writeUTF("글이 정상적으로 추가 되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {

        return (title + "\t" + writer + "\t" + day);
    }

    public String getContent() {

        return (title + "\t" + content + "\t" + writer + "\t" + day);
    }
}