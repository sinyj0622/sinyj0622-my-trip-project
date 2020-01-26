package sinyj0622.mytrip.handler;

import java.util.Iterator;
import java.util.List;
import sinyj0622.mytrip.domain.Plan;
import sinyj0622.mytrip.util.Prompt;

public class PlanDeleteCommand implements Command {

  List<Plan> planList;

  Prompt prompt;


  public PlanDeleteCommand(Prompt prompt, List<Plan> list) {
    this.prompt = prompt;
    this.planList = list;
  }




  public void execute() {
    int index = indexOfPlan(prompt.inputInt("번호? "));

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


