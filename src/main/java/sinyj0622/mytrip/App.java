package sinyj0622.mytrip;

import java.sql.Date;
import java.util.Scanner;

public class App{
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int SIZE = 100;
    int [] no = new int[SIZE];
    String[] travelDestnation = new String[SIZE];
    String[] travelTitle = new String[SIZE];
    int[] person = new int[SIZE];
    Date[] startDate = new Date[SIZE];
    Date[] endDate = new Date[SIZE];
    int[] travelMoney = new int[SIZE];


    int count = 0;
    for (int i = 0; i < SIZE; i++) {
      count++;
      System.out.print("번호: ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("여행 제목? ");
      travelTitle[i] = keyboard.nextLine();

      System.out.print("어디로 떠나세요?: ");
      travelDestnation[i] = keyboard.nextLine();

      System.out.print("여행 인원? ");
      person[i] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("여행 시작일? ");
      startDate[i] = Date.valueOf(keyboard.nextLine());

      System.out.print("여행 종료일? ");
      endDate[i] = Date.valueOf(keyboard.nextLine());

      System.out.print("예상 경비? ");
      travelMoney[i] = keyboard.nextInt();

      keyboard.nextLine();
      System.out.println();

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }
    

    keyboard.close();

    System.out.println("-------------------------------"); 
 

    for (int i = 0; i < count; i++) {
      System.out.printf("%d, %s, %s, %s ~ %s\n", 
          no[i], travelTitle[i], travelDestnation[i], startDate[i], endDate[i]);

    }


  }
}
