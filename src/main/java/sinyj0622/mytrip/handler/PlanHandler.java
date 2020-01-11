package sinyj0622.mytrip.handler;

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
    travelPlan.setPerson(input.nextLine());

    System.out.print("여행 시작일? ");
    travelPlan.setStartDate(input.nextLine());

    System.out.print("여행 종료일? ");
    travelPlan.setEndDate(input.nextLine());

    System.out.print("예상 경비? ");
    travelPlan.setTravelMoney(input.nextLine());

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

  public void detailPlan() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();
    
    int index = indexOfPlan(no);

    if (index == -1) {
      System.out.println("해당 번호의 여행계획이 없습니다.");
      return;
    }

    Plan p = this.planList.get(index);
    System.out.printf("번호: %d\n", p.getNo());
    System.out.printf("여행 제목: %s\n", p.getTravelTitle());
    System.out.printf("어디로 떠나세요: %s\n", p.getDestnation());
    System.out.printf("여행인원: %s\n", p.getPerson());
    System.out.printf("여행 기간: %s ~ %s\n", p.getStartDate(), p.getEndDate());
    System.out.printf("예상 경비: %s\n", p.getTravelMoney());

    System.out.println();

  }


  public void updatePlan() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfPlan(no);

    if (index == -1) {
      System.out.println("해당 번호의 여행계획이 없습니다.");
      return;
    }

    Plan oldPlan = this.planList.get(index);
    Plan newPlan = new Plan();

    boolean changed = false;
    String inputStr = null;
    newPlan.setNo(oldPlan.getNo());

    System.out.printf("여행제목(%s): ", oldPlan.getTravelTitle());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newPlan.setTravelTitle(oldPlan.getTravelTitle());
    } else {
      newPlan.setTravelTitle(inputStr);
      changed = true;
    }

    System.out.printf("어디로 떠나세요(%s): ", oldPlan.getDestnation());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newPlan.setDestnation(oldPlan.getDestnation());
    } else {
      newPlan.setDestnation(inputStr);
      changed = true;
    }

    System.out.printf("여행인원(%s): ", oldPlan.getPerson());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newPlan.setPerson(oldPlan.getPerson());
    } else {
      newPlan.setPerson(inputStr);
      changed = true;
    }

    System.out.printf("여행 시작일 (%s): ", oldPlan.getStartDate());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newPlan.setStartDate(oldPlan.getStartDate());
    } else {
      newPlan.setStartDate(inputStr);
      changed = true;
    }

    System.out.printf("여행 종료일 (%s): ", oldPlan.getEndDate());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newPlan.setEndDate(oldPlan.getEndDate());
    } else {
      newPlan.setEndDate(inputStr);
      changed = true;
    }

    System.out.printf("예상 경비(%s): ", oldPlan.getTravelMoney());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newPlan.setTravelMoney(oldPlan.getTravelMoney());
    } else {
      newPlan.setTravelMoney(inputStr);
      changed = true;
    }


    if (changed) {
      this.planList.set(index, newPlan);
      System.out.println("여행계획을 변경했습니다.");
    } else {
      System.out.println("여행계획 변경을 취소하였습니다.");
    }

  }
  
  
  public void deletePlan() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();
    
    int index = indexOfPlan(no);

    if (index == -1) {
      System.out.println("해당 번호의 여행계획이 없습니다.");
      return;
    }
    
    this.planList.remove(index);
    
    System.out.println("여행계획을 삭제했습니다.");
  }

  
  private int indexOfPlan(int no) {
    for (int i = 0; i < this.planList.size(); i++) {
      if (this.planList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}


