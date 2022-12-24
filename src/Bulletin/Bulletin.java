package Bulletin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class Bulletin {

    private List<Document> list = new ArrayList<>();
    private boolean state = true;
    Scanner scanner = new Scanner(System.in);

    public void systemOut() {

        System.out.println("==============================");
        System.out.println("번호 제목 작성자   작성일");
        System.out.println("------------------------------");
    }

    public void quest() {

        System.out.print("1.목록 2.등록 3.내용 4.삭제 0.종료 >> ");
    }

    public void list() {

        int count = 1;
        systemOut();

        for (Iterator<Document> itr = list.iterator(); itr.hasNext(); ) {
            System.out.print(count + "\t");
            itr.next().getPrint();
            count++;
        }
    }

    public void create() {

        list.add(new Document());
        quest();
    }

    public void content() {

        list();
        System.out.print("위에 게시판 번호중 하나를 넣어 주세요. >> ");
        int inputNumber = scanner.nextInt();
        systemOut();
        System.out.print(inputNumber + "\t");
        list.get(--inputNumber).getPrintContent();
        quest();
    }

    public void remove() {

        list();
        System.out.print("위에 게시판 번호중 제거할 글을 숫자로 하나를 넣어 주세요. >> ");
        int number = scanner.nextInt();

        list.remove(number - 1);

        System.out.println("해당 게시판을 삭제하였습니다.");
        quest();
    }

    public boolean quit() {

        System.out.println("게시판이 종료됩니다.");
        return false;
    }

    public void start() {

        systemOut();
        quest();
        while (state) {
            int inputNum = scanner.nextInt();
            switch (inputNum) {
                case 0:
                    state = quit();
                    break;
                case 1:
                    list();
                    quest();
                    break;
                case 2:
                    create();
                    break;
                case 3:
                    content();
                    break;
                case 4:
                    remove();
            }
        }
    }
}


