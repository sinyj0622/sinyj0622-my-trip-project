package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.TravelPlan;

public class TravelPlanHandler {


  TravelPlan[] travelPlans = new TravelPlan[TRAVELPLANS_SIZE];
  int travelplansCount = 0;
  
  static final int TRAVELPLANS_SIZE = 100;
  public static Scanner keyboard;
  
  public void addTravelPlan() {
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

    this.travelPlans[this.travelplansCount++] = travelPlan;
    System.out.println("여행 계획을 저장하였습니다.");
    System.out.println();
    
  }

  public void listTravelPlan() {
    for (int i = 0; i < this.travelplansCount; i++) {
      TravelPlan t = this.travelPlans[i];
      System.out.printf("%d, %s, %s, %s ~ %s\n", 
          t.no, t.travelTitle, t.Destnation, 
          t.startDate, t.endDate);
    }
    System.out.println();
  }
}
