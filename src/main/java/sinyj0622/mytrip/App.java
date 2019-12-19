package sinyj0622.mytrip;

import java.sql.Date;
import java.util.Scanner;

public class App{
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int SIZE = 100;
    
    class TravelPlan {
      int no;
      String Destnation;
      String travelTitle;
      int person;
      Date startDate;
      Date endDate;
      int travelMoney;
    }
    
    TravelPlan[] travelPlans = new TravelPlan[SIZE];
    
    int count = 0;
    for (int i = 0; i < SIZE; i++) {
      
      TravelPlan travelPlan = new TravelPlan();
      
      count++;
      
      System.out.print("번호: ");
      travelPlan.no = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("여행 제목? ");
      travelPlan.travelTitle = keyboard.nextLine();

      System.out.print("어디로 떠나세요?: ");
      travelPlan.Destnation = keyboard.nextLine();

      System.out.print("여행 인원? ");
      travelPlan.person = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("여행 시작일? ");
      travelPlan.startDate = Date.valueOf(keyboard.nextLine());

      System.out.print("여행 종료일? ");
      travelPlan.endDate = Date.valueOf(keyboard.nextLine());

      System.out.print("예상 경비? ");
      travelPlan.travelMoney = keyboard.nextInt();

      travelPlans[i] = travelPlan;
      
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
      
      TravelPlan travelPlan = travelPlans[i];
      
      System.out.printf("%d, %s, %s, %s ~ %s\n", 
          travelPlan.no, travelPlan.travelTitle, travelPlan.Destnation, 
          travelPlan.startDate, travelPlan.endDate);

    }


  }
}
