package sinyj0622.mytrip;

import java.sql.Date;
import java.util.Scanner;

public class MemberHandler {
  static class Member {
    int no;
    String name;
    String nickname;
    String email;
    String passWord;
    String myphoto;
    String phonenumber;
    Date registeredDate;      
  }

  static final int MEMBER_SIZE = 100;
  static Member[] members = new Member[MEMBER_SIZE];
  static int memberCount = 0;
  static Scanner keyboard;

  static void addMember() {
    Member member = new Member();
    System.out.print("번호: ");
    member.no = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("이름: ");
    member.name = keyboard.nextLine();

    System.out.print("별명: ");
    member.nickname = keyboard.nextLine();

    System.out.print("암호: ");
    member.passWord = keyboard.nextLine();

    System.out.print("이메일: ");
    member.email = keyboard.nextLine();

    System.out.print("사진: ");
    member.myphoto = keyboard.nextLine();

    System.out.print("전화: ");
    member.phonenumber = keyboard.nextLine();

    member.registeredDate = new Date(System.currentTimeMillis());

    members[memberCount++] = member;
    System.out.println("저장하였습니다.");
    System.out.println();
    
  }

  static void listMember() {
    for (int i = 0; i < memberCount; i++){
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.no, m.name, m.email, m.phonenumber, m.registeredDate);
    }
  }
  
}
