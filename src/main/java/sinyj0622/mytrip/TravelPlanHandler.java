package sinyj0622.mytrip;

import java.sql.Date;
import java.util.Scanner;

public class TravelPlanHandler {
  static class TravelPlan {
    int no;
    String Destnation;
    String travelTitle;
    int person;
    Date startDate;
    Date endDate;
    int travelMoney;
  }

  static final int TRAVELPLANS_SIZE = 100;
  static TravelPlan[] travelPlans = new TravelPlan[TRAVELPLANS_SIZE];
  static int travelplansCount = 0;
  static Scanner keyboard;
  
  static void addTravelPlan() {
    TravelPlan travelPlan = new TravelPlan();

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
    keyboard.nextLine();

    travelPlans[travelplansCount++] = travelPlan;
    System.out.println("저장하였습니다.");
    System.out.println();
    
  }

  static void listTravelPlan() {
    for (int i = 0; i < travelplansCount; i++) {
      TravelPlan t = travelPlans[i];
      System.out.printf("%d, %s, %s, %s ~ %s\n", 
          t.no, t.travelTitle, t.Destnation, 
          t.startDate, t.endDate);
    }
  }
}
