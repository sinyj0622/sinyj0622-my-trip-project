package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Board;

public class BoardHandler {


  Board[] boards = new Board[BOARD_SIZE];
  int boardCount = 0;
  
  static final int BOARD_SIZE = 100;
  public static Scanner keyboard;

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호: ");
    board.no = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("내용: ");
    board.text = keyboard.nextLine();


    board.date = new Date(System.currentTimeMillis());
    board.viewCount = 0;


    this.boards[this.boardCount++] = board;
    System.out.println("내용을 저장하였습니다.");
    System.out.println();

  }

  public void listBoard() {
    for (int i = 0; i < this.boardCount; i++) {
      Board b = this.boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          b.no, b.text, b.date, b.viewCount);
    }
    System.out.println();
  }


  public void detailBoard() {
    System.out.print("게시글 번호? ");
    int no = keyboard.nextInt();
    keyboard.nextLine();

    Board board = null;
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == no) {
        board = this.boards[i];
        break;
      }
    }
   if (board == null) {
     System.out.println("게시물 번호가 유효하지 않습니다.");
     return;
   }
     System.out.printf("번호: %d\n", board.no);
     System.out.printf("제목: %s\n", board.text );
     System.out.printf("등록일: %s\n", board.date);
     System.out.printf("조회수: %d\n", board.viewCount);

     System.out.println();
   
  }
        
}
