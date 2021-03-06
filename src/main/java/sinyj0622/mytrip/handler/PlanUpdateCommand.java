package sinyj0622.mytrip.handler;

import java.util.List;

import sinyj0622.mytrip.domain.Plan;
import sinyj0622.mytrip.util.Prompt;

public class PlanUpdateCommand implements Command {

  List<Plan> planList;

  Prompt prompt;


  public PlanUpdateCommand(Prompt prompt, List<Plan> list) {
    this.prompt = prompt;
    this.planList = list;
  }


  
  public void execute() {
    int index = indexOfPlan(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 여행계획이 없습니다.");
      return;
    }

    Plan oldPlan = this.planList.get(index);
    Plan newPlan = new Plan();

    String inputStr = null;
    newPlan.setNo(oldPlan.getNo());

    newPlan.setTravelTitle(prompt.inputString(String.format("여행제목(%s): ", oldPlan.getTravelTitle()),
        oldPlan.getTravelTitle()));

    newPlan.setDestnation(prompt.inputString(
        String.format("어디로 떠나세요(%s): ", oldPlan.getDestnation()), oldPlan.getDestnation()));

    newPlan.setPerson(
        prompt.inputString(String.format("여행인원(%s): ", oldPlan.getPerson()), oldPlan.getPerson()));

    newPlan.setStartDate(prompt.inputString(String.format("여행 시작일 (%s): ", oldPlan.getStartDate()),
        oldPlan.getStartDate()));

    newPlan.setEndDate(prompt.inputString(String.format("여행 종료일 (%s): ", oldPlan.getEndDate()),
        oldPlan.getEndDate()));

    newPlan.setPerson(prompt.inputString(String.format("여행인원(%s): ", oldPlan.getTravelMoney()),
        oldPlan.getTravelMoney()));

    newPlan.setTravelMoney(
        prompt.inputString(String.format("예상 경비(%s): ", oldPlan.getPerson()), oldPlan.getPerson()));


    if (oldPlan.equals(newPlan)) {
      System.out.println("여행계획 변경을 취소하였습니다.");
      return;
    }
    this.planList.set(index, newPlan);
    System.out.println("여행계획을 변경하였습니다.");
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


