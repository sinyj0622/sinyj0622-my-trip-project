package sinyj0622.mytrip;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int SIZE = 100;
    
    class Member {
      int no;
      String name;
      String nickname;
      String email;
      String passWord;
      String myphoto;
      String phonenumber;
      Date registeredDate;      
    }

    Member[] members = new Member[SIZE];

    int count = 0;
    for (int i = 0; i < SIZE; i++){
      
      count++;
      
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

      members[i] = member;
      
      System.out.println();

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }


    keyboard.close();

    System.out.println("-------------------------------"); 



    for (int i = 0; i < count; i++){
      
      Member member = members[i];
      
      System.out.printf("%d, %s, %s, %s, %s\n", 
          member.no, member.name, member.email, member.phonenumber, member.registeredDate);


    }
  }
}
