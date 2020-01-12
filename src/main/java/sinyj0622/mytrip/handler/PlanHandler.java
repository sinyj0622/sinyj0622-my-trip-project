package sinyj0622.mytrip.handler;

import java.util.LinkedList;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Plan;
import sinyj0622.mytrip.util.ArrayList;
import sinyj0622.mytrip.util.Prompt;

public class PlanHandler {

	LinkedList<Plan> planList;

	Prompt prompt;


	public PlanHandler(Prompt prompt) {
		this.prompt = prompt;
		this.planList = new LinkedList<Plan>();
	}


	public void addTravelPlan() {
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


	public void updatePlan() {
		int index = indexOfPlan(prompt.inputInt("번호? "));

		if (index == -1) {
			System.out.println("해당 번호의 여행계획이 없습니다.");
			return;
		}

		Plan oldPlan = this.planList.get(index);
		Plan newPlan = new Plan();

		String inputStr = null;
		newPlan.setNo(oldPlan.getNo());

		newPlan.setTravelTitle(prompt.inputString(
				String.format("여행제목(%s): ", oldPlan.getTravelTitle())
				,oldPlan.getTravelTitle()));

		newPlan.setDestnation(prompt.inputString(
				String.format("어디로 떠나세요(%s): ", oldPlan.getDestnation())
				,oldPlan.getDestnation()));

		newPlan.setPerson(prompt.inputString(
				String.format("여행인원(%s): ", oldPlan.getPerson())
				,oldPlan.getPerson()));

		newPlan.setStartDate(prompt.inputString(
				String.format("여행 시작일 (%s): ", oldPlan.getStartDate())
				,oldPlan.getStartDate()));
		
		newPlan.setEndDate(prompt.inputString(
				String.format("여행 종료일 (%s): ", oldPlan.getEndDate())
				,oldPlan.getEndDate()));

		newPlan.setPerson(prompt.inputString(
				String.format("여행인원(%s): ", oldPlan.getTravelMoney())
				,oldPlan.getTravelMoney()));

		newPlan.setTravelMoney(prompt.inputString(
				String.format("예상 경비(%s): ", oldPlan.getPerson())
				,oldPlan.getPerson()));


		if (oldPlan.equals(newPlan)) {
			System.out.println("여행계획 변경을 취소하였습니다.");
			return;
		}
		this.planList.set(index, newPlan);
		System.out.println("여행계획을 변경하였습니다.");
	}



	public void deletePlan() {
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


