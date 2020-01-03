package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Board;

public class BoardHandler {


  BoardList boardList;

  Scanner input;


  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new BoardList();
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
    Board[] board= this.boardList.toArray();
    for (Board b : board)
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getText(), b.getDate(), b.getViewCount());
    System.out.println();
  }


  public void detailBoard() {
    System.out.print("게시글 번호? ");
    int no = input.nextInt();
    input.nextLine();

    Board board = this.boardList.get(no);

    if (board == null) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
    }
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getText() );
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());

    System.out.println();

  }

}
