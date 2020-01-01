package sinyj0622.mytrip.domain;

import java.sql.Date;

public class TravelPlan {
	private int no;
	private String Destnation;
	private String travelTitle;
	private int person;
	private Date startDate;
	private Date endDate;
	private int travelMoney;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDestnation() {
		return Destnation;
	}
	public void setDestnation(String destnation) {
		Destnation = destnation;
	}
	public String getTravelTitle() {
		return travelTitle;
	}
	public void setTravelTitle(String travelTitle) {
		this.travelTitle = travelTitle;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getTravelMoney() {
		return travelMoney;
	}
	public void setTravelMoney(int travelMoney) {
		this.travelMoney = travelMoney;
	}
}
