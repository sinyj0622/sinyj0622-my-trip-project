package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Member;

public class MemberHandler {

  Member[] members;
  int memberCount = 0;
  
  static final int MEMBER_SIZE = 100;
  Scanner input;
  
  
  public MemberHandler(Scanner input) {
	  this.input = input;
	  this.members = new Member[MEMBER_SIZE];
  }
  
  public MemberHandler(Scanner input, int capacity) {
	  this.input = input;
	  if (capacity < MEMBER_SIZE || capacity > 10000)
		  this.members = new Member[MEMBER_SIZE];
	  else
		  this.members = new Member[capacity];
  }
  
  
  

  public void addMember() {
    Member member = new Member();
    System.out.print("번호: ");
    member.setNo(input.nextInt());
    input.nextLine();

    System.out.print("이름: ");
    member.setName(input.nextLine());

    System.out.print("별명: ");
    member.setNickname(input.nextLine());

    System.out.print("암호: ");
    member.setPassWord(input.nextLine());

    System.out.print("이메일: ");
    member.setEmail(input.nextLine());

    System.out.print("사진: ");
    member.setMyphoto(input.nextLine());

    System.out.print("전화: ");
    member.setPhonenumber(input.nextLine());

    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    this.members[this.memberCount++] = member;
    System.out.println("회원 정보를 저장하였습니다.");
    System.out.println();
    
  }

  public void listMember() {
    for (int i = 0; i < this.memberCount; i++){
      Member m = this.members[i];
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.getNo(), m.getName(), m.getEmail(), m.getPhonenumber(), m.getRegisteredDate());
    }
    System.out.println();
  }
  
}
