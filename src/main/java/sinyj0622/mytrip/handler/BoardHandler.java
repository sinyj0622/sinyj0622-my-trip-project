package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Board;

public class BoardHandler {


  ArrayList boardList;

  Scanner input;


  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new ArrayList();
  }


  public void addBoard() {
    Board board = new Board();

    System.out.print("번호: ");
    board.setNo(input.nextInt());
    input.nextLine();

    System.out.print("내용: ");
    board.setText(input.nextLine());


    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);


    this.boardList.add(board);
    System.out.println("내용을 저장하였습니다.");
    System.out.println();

  }

  public void listBoard() {
    Object[] arr = this.boardList.toArray();
    for (Object obj : arr) {
      Board b = (Board)obj;
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getText(), b.getDate(), b.getViewCount());
    }
      System.out.println();
  }


  public void detailBoard() {
    System.out.print("게시글 번호? ");
    int no = input.nextInt();
    input.nextLine();

    Board b = (Board) this.boardList.get(no);

    if (b == null) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
    }
    System.out.printf("번호: %d\n", b.getNo());
    System.out.printf("제목: %s\n", b.getText() );
    System.out.printf("등록일: %s\n", b.getDate());
    System.out.printf("조회수: %d\n", b.getViewCount());

    System.out.println();

  }

}
