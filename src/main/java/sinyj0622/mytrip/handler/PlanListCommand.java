package sinyj0622.mytrip.handler;

import java.util.Iterator;
import java.util.List;
import sinyj0622.mytrip.domain.Plan;
import sinyj0622.mytrip.util.Prompt;

public class PlanListCommand implements Command {

  List<Plan> planList;

  Prompt prompt;


  public PlanListCommand(List<Plan> list) {
    this.planList = list;
  }



  public void execute() {

    Iterator<Plan> iterator = planList.iterator();
    while (iterator.hasNext()) {
      Plan p = iterator.next();
      System.out.printf("%d, %s, %s, %s ~ %s\n", p.getNo(), p.getTravelTitle(), p.getDestnation(),
          p.getStartDate(), p.getEndDate());
    }
  }

 
  
}


