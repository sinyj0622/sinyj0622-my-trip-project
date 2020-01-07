package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Plan;
import sinyj0622.mytrip.util.ArrayList;

public class PlanHandler {

  ArrayList<Plan> planList;

  Scanner input;


  public PlanHandler(Scanner input) {
    this.input = input;
    this.planList = new ArrayList<Plan>();
  }


  public void addTravelPlan() {
    Plan travelPlan = new Plan();

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

    this.planList.add(travelPlan);

    System.out.println("여행 계획을 저장하였습니다.");
    System.out.println();

  }

  public void listTravelPlan() {
    Plan[] arr = new Plan[this.planList.size()];
    this.planList.toArray(arr);
    for(Plan p : arr) {
      System.out.printf("%d, %s, %s, %s ~ %s\n", 
          p.getNo(), p.getTravelTitle(), p.getDestnation(), 
          p.getStartDate(), p.getEndDate());
    }
  }
}
