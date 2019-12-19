package sinyj0622.mytrip;

import java.sql.Date;
import java.util.Scanner;


public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    final int SIZE = 100;
    
    class Board {
      int no;
      String text;
      Date date;
      int viewCount;
    }
    
    Board[] boards = new Board[SIZE];
    

    int count = 0;
    for (int i = 0; i < SIZE; i++ ) {
      
      count++;     
      
      Board board = new Board();
      
      System.out.print("번호: ");
      board.no = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("내용: ");
      board.text = keyboard.nextLine();


      board.date = new Date(System.currentTimeMillis());
      board.viewCount = 0;


      boards[i] = board;
      
      System.out.println();

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }

    
    keyboard.close();

    System.out.println("-------------------------------"); 

    for ( int i = 0; i < count; i++) {
      
      Board board = boards[i];
      
      System.out.printf("%d, %s, %s, %d\n", 
          board.no, board.text, board.date, board.viewCount);


    }
  }
}


