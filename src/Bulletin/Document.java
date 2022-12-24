package Bulletin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Document { // 게시글 만들기
    private String title;
    private String content;
    private String writer;
    private String day;
    Scanner scanner = new Scanner(System.in);

    public Document() { // 게시글 생성
        System.out.print("제목 > ");
        this.title = scanner.nextLine();
        System.out.print("내용 > ");
        this.content = scanner.nextLine();
        System.out.print("작성자 > ");
        this.writer = scanner.nextLine();
        LocalDateTime now = LocalDateTime.now();

        day = now.format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 HH시 mm분 ss초"));
        System.out.println("글이 정상적으로 추가 되었습니다.");
    }

    public void getPrint() {
        System.out.println(title + "\t" + writer + "\t" + day);
    }

    public void getPrintContent() {
        System.out.println(title + "\t" + content + "\t" + writer + "\t" + day);
    }
}