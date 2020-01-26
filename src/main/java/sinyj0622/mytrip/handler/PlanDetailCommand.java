package sinyj0622.mytrip.handler;

import java.util.Iterator;
import java.util.List;
import sinyj0622.mytrip.domain.Plan;
import sinyj0622.mytrip.util.Prompt;

public class PlanDetailCommand implements Command {

  List<Plan> planList;

  Prompt prompt;


  public PlanDetailCommand(Prompt prompt, List<Plan> list) {
    this.prompt = prompt;
    this.planList = list;
  }


 
  public void execute() {

    int index = indexOfPlan(prompt.inputInt("번호? "));

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


  private int indexOfPlan(int no) {
    for (int i = 0; i < this.planList.size(); i++) {
      if (this.planList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}


