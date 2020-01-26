package sinyj0622.mytrip.handler;

import java.util.Iterator;
import java.util.List;
import sinyj0622.mytrip.domain.Plan;
import sinyj0622.mytrip.util.Prompt;

public class PlanAddCommand implements Command {

  List<Plan> planList;

  Prompt prompt;


  public PlanAddCommand(Prompt prompt, List<Plan> list) {
    this.prompt = prompt;
    this.planList = list;
  }


  public void execute() {
    Plan travelPlan = new Plan();

    travelPlan.setNo(prompt.inputInt("번호: "));
    travelPlan.setTravelTitle(prompt.inputString("여행 제목? "));
    travelPlan.setDestnation(prompt.inputString("어디로 떠나세요?: "));
    travelPlan.setPerson(prompt.inputString("여행 인원? "));
    travelPlan.setStartDate(prompt.inputString("여행 시작일? "));
    travelPlan.setEndDate(prompt.inputString("여행 종료일? "));
    travelPlan.setTravelMoney(prompt.inputString("예상 경비? "));

    this.planList.add(travelPlan);

    System.out.println("여행 계획을 저장하였습니다.");

  }

}


