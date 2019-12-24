package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Board;

public class BoardHandler {


  static final int BOARD_SIZE = 100;
  static Board[] boards = new Board[BOARD_SIZE];
  static int boardCount = 0;
  public static Scanner keyboard;
  
  public static void addBoard() {
    Board board = new Board();

    System.out.print("번호: ");
    board.no = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("내용: ");
    board.text = keyboard.nextLine();


    board.date = new Date(System.currentTimeMillis());
    board.viewCount = 0;


    boards[boardCount++] = board;
    System.out.println("저장하였습니다.");
    System.out.println();
    
  }

  public static void listBoard() {
    for (int i = 0; i < boardCount; i++) {
      Board b = boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          b.no, b.text, b.date, b.viewCount);
    }
    System.out.println();
  }
  
}
