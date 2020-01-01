package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.TravelPlan;

public class TravelPlanHandler {


  TravelPlan[] travelPlans = new TravelPlan[TRAVELPLANS_SIZE];
  int travelplansCount = 0;
  
  static final int TRAVELPLANS_SIZE = 100;
  Scanner input;
  
  
  public TravelPlanHandler(Scanner input) {
	  this.input = input;
  }
  
  public TravelPlanHandler(Scanner input, int capacity) {
	  this.input = input;
	  if (capacity < TRAVELPLANS_SIZE || capacity > 10000)
		  this.travelPlans = new TravelPlan[TRAVELPLANS_SIZE];
	  else
		  this.travelPlans = new TravelPlan[capacity];
  }
  
  
  public void addTravelPlan() {
    TravelPlan travelPlan = new TravelPlan();

    System.out.print("번호: ");
    travelPlan.setNo(input.nextInt());
    input.nextLine();

    System.out.print("여행 제목? ");
    travelPlan.setTravelTitle(input.nextLine());

    System.out.print("어디로 떠나세요?: ");
    travelPlan.setDestnation(input.nextLine());

    System.out.print("여행 인원? ");
    travelPlan.setPerson(input.nextInt());
    input.nextLine();

    System.out.print("여행 시작일? ");
    travelPlan.setStartDate(Date.valueOf(input.nextLine()));

    System.out.print("여행 종료일? ");
    travelPlan.setEndDate(Date.valueOf(input.nextLine()));

    System.out.print("예상 경비? ");
    travelPlan.setTravelMoney(input.nextInt());
    input.nextLine();

    this.travelPlans[this.travelplansCount++] = travelPlan;
    System.out.println("여행 계획을 저장하였습니다.");
    System.out.println();
    
  }

  public void listTravelPlan() {
    for (int i = 0; i < this.travelplansCount; i++) {
      TravelPlan t = this.travelPlans[i];
      System.out.printf("%d, %s, %s, %s ~ %s\n", 
          t.getNo(), t.getTravelTitle(), t.getDestnation(), 
          t.getStartDate(), t.getEndDate());
    }
    System.out.println();
  }
}
