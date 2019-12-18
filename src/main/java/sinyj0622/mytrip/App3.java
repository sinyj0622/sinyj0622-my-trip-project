package sinyj0622.mytrip;

import java.sql.Date;
import java.util.Scanner;


public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int SIZE = 100;
    int[] no = new int[SIZE];
    String[] text = new String[SIZE];
    Date[] date = new Date[SIZE];
    int[] viewCount = new int[SIZE];

    int count = 0;
    for (int i = 0; i < SIZE; i++ ) {
      System.out.print("번호: ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("내용: ");
      text[i] = keyboard.nextLine();


      date[i] = new Date(System.currentTimeMillis());
      viewCount[i] = 0;

      count++;
      
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
      System.out.printf("%d, %s, %s, %d\n", 
          no[i], text[i], date[i], viewCount[i]);


    }
  }
}


