package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Member;
import sinyj0622.mytrip.util.ArrayList;

public class MemberHandler {

  
  ArrayList<Member> memberList;

  Scanner input;


  public MemberHandler(Scanner input) {
    this.input = input;
    this.memberList = new ArrayList<>();  
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
    
    Member[] arr = new Member[this.memberList.size()];
    
    this.memberList.toArray(arr);
    for (Member m : arr) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.getNo(), m.getName(), m.getEmail(), m.getPhonenumber(), m.getRegisteredDate());
    }
  }
  
  public void detailMember() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();
    
    int index = indexOfMember(no);
    
    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }
    
    Member member = this.memberList.get(index);
    System.out.printf("번호: %d\n", member.getNo());
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("별명: %s\n", member.getNickname());
    System.out.printf("암호: %s\n", member.getPassWord());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("사진: %s\n", member.getMyphoto());
    System.out.printf("전화: %s\n", member.getPhonenumber());

    System.out.println();

  }
  
  public void updateMember() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();
    
    int index = indexOfMember(no);
    
    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }
    
    Member oldMember = this.memberList.get(index);
    Member newMember = new Member();
    
    boolean changed = false;
    String inputStr = null;
    newMember.setNo(oldMember.getNo());
    
    System.out.printf("이름(%s)?", oldMember.getName());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newMember.setName(oldMember.getName());
    } else {
      newMember.setName(inputStr);
      changed = true;
    }

    System.out.printf("별명(%s)?", oldMember.getNickname());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newMember.setNickname(oldMember.getNickname());
    } else {
      newMember.setNickname(inputStr);
      changed = true;
    }

    System.out.printf("암호(%s)?", oldMember.getPassWord());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newMember.setPassWord(oldMember.getPassWord());
    } else {
      newMember.setPassWord(inputStr);
      changed = true;
    }
    
    System.out.printf("이메일(%s)?", oldMember.getEmail());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newMember.setEmail(oldMember.getEmail());
    } else {
      newMember.setEmail(inputStr);
      changed = true;
    }
    
    System.out.printf("사진(%s)?", oldMember.getMyphoto());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newMember.setMyphoto(oldMember.getMyphoto());
    } else {
      newMember.setMyphoto(inputStr);
      changed = true;
    }
    
    System.out.printf("전화(%s)?", oldMember.getPhonenumber());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newMember.setPhonenumber(oldMember.getPhonenumber());
    } else {
      newMember.setPhonenumber(inputStr);
      changed = true;
    }
   
   
    

    if (changed) {
      this.memberList.set(index, newMember);
      System.out.println("회원을 변경했습니다.");
    } else {
      System.out.println("회원 변경을 취소하였습니다.");
    }
    
  }
  
  public void deleteMember() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();
    
    int index = indexOfMember(no);
    
    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }
    
  
    this.memberList.remove(index);
    
    System.out.println("회원을 삭제했습니다.");
  }
  
  private int indexOfMember(int no) {
    for (int i = 0; i < this.memberList.size(); i++) {
      if (this.memberList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
