package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Member;
import sinyj0622.mytrip.util.ArrayList;
import sinyj0622.mytrip.util.Prompt;

public class MemberHandler {

  
  ArrayList<Member> memberList;

  Prompt prompt;


  public MemberHandler(Scanner input) {
    this.prompt = prompt;
    this.memberList = new ArrayList<>();  
  }


  public void addMember() {
    Member member = new Member();
    member.setNo(prompt.inputInt("번호: "));
    member.setName(prompt.inputString("이름: "));
    member.setNickname(prompt.inputString("별명: "));
    member.setPassWord(prompt.inputString("암호: "));
    member.setEmail(prompt.inputString("이메일: "));
    member.setMyphoto(prompt.inputString("사진: "));
    member.setPhonenumber(prompt.inputString("전화: "));
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
    int index = indexOfMember(prompt.inputInt("번호? "));
    
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
    int index = indexOfMember(prompt.inputInt("번호? "));
    
    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }
    
    Member oldMember = this.memberList.get(index);
    Member newMember = new Member();
    
    boolean changed = false;
    String inputStr = null;
    newMember.setNo(oldMember.getNo());

    newMember.setName(prompt.inputString(String.format("이름(%s)?", 
        oldMember.getName()),oldMember.getName()));
    
    newMember.setNickname(prompt.inputString(String.format("별명(%s)?", 
        oldMember.getNickname()), oldMember.getNickname()));
    
    newMember.setPassWord(prompt.inputString(String.format("암호(%s)?", 
        oldMember.getPassWord()), oldMember.getPassWord()));
    
    newMember.setEmail(prompt.inputString(String.format("이메일(%s)?", 
        oldMember.getEmail()), oldMember.getEmail()));
    
    newMember.setMyphoto(prompt.inputString(String.format("사진(%s)?", 
        oldMember.getMyphoto()), oldMember.getMyphoto()));
    
    newMember.setPhonenumber(prompt.inputString(String.format("전화(%s)?", 
        oldMember.getPhonenumber()), oldMember.getPhonenumber()));


    if (changed) {
      this.memberList.set(index, newMember);
      System.out.println("회원을 변경했습니다.");
    } else {
      System.out.println("회원 변경을 취소하였습니다.");
    }
    
  }
  
  public void deleteMember() {
    int index = indexOfMember(prompt.inputInt("번호? "));
    
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
