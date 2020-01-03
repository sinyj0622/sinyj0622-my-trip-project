package sinyj0622.mytrip.handler;

import java.util.Arrays;
import sinyj0622.mytrip.domain.Plan;

public class PlanList {

  static final int TRAVELPLANS_SIZE = 100;

  Plan[] travelPlans;
  int travelplansCount = 0;


  public PlanList() {
    this.travelPlans = new Plan[TRAVELPLANS_SIZE];
  }

  public PlanList(int capacity) {
    if (capacity < TRAVELPLANS_SIZE || capacity > 10000)
      this.travelPlans = new Plan[TRAVELPLANS_SIZE];
    else
      this.travelPlans = new Plan[capacity];
  }

  public void add(Plan travelPlan) {
    if (this.travelplansCount == this.travelPlans.length) {
      int oldCapacity = this.travelPlans.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.travelPlans = Arrays.copyOf(this.travelPlans, newCapacity);
    }
    this.travelPlans[this.travelplansCount++] = travelPlan;
    
  }

  public Plan[] toArray() {
    return Arrays.copyOf(this.travelPlans, this.travelplansCount);
  }
  
  
  
  
  
}
