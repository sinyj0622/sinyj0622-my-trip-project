package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Board;
import sinyj0622.mytrip.util.ArrayList;

public class BoardHandler {


  ArrayList<Board> boardList;

  Scanner input;


  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new ArrayList<Board>();
  }
  
  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    this.boardList = new ArrayList<>(capacity);
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
    
    Board[] arr = new Board[this.boardList.size()];
    
    this.boardList.toArray(arr);
    
    for (Board b : arr) {
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getText(), b.getDate(), b.getViewCount());
    }
      System.out.println();
  }


  public void detailBoard() {
    System.out.print("인덱스 번호? ");
    int no = input.nextInt();
    input.nextLine();

    Board b = (Board) this.boardList.get(no);

    if (b == null) {
      System.out.println("인덱스 번호가 유효하지 않습니다.");
      return;
    }
    System.out.printf("번호: %d\n", b.getNo());
    System.out.printf("제목: %s\n", b.getText() );
    System.out.printf("등록일: %s\n", b.getDate());
    System.out.printf("조회수: %d\n", b.getViewCount());

    System.out.println();

  }

}
