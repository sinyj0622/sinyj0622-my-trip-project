package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Member;

public class MemberHandler {

  
  MemberList memberList;

  Scanner input;


  public MemberHandler(Scanner input) {
    this.input = input;
    this.memberList = new MemberList();  
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

    this.memberList.add(member);
    System.out.println("회원 정보를 저장하였습니다.");
    System.out.println();

  }

  public void listMember() {
    Member[] members = this.memberList.toArray();
    for (Member m : members)
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.getNo(), m.getName(), m.getEmail(), m.getPhonenumber(), m.getRegisteredDate());

  }

}
