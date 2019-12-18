package sinyj0622.mytrip;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int SIZE = 100;
    int [] no = new int[SIZE];
    String[] name = new String[SIZE];
    String[] nickname = new String[SIZE];
    String[] email = new String[SIZE];
    String[] passWord = new String[SIZE];
    String[] myphoto = new String[SIZE];
    String[] phonenumber = new String[SIZE];
    Date[] date = new Date[SIZE];
    String response;



    int count = 0;
    for (int i = 0; i < SIZE; i++){
      count++;
      System.out.print("번호: ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("이름: ");
      name[i] = keyboard.nextLine();

      System.out.print("별명: ");
      nickname[i] = keyboard.nextLine();
      
      System.out.print("암호: ");
      passWord[i] = keyboard.nextLine();

      System.out.print("이메일: ");
      email[i] = keyboard.nextLine();

      System.out.print("사진: ");
      myphoto[i] = keyboard.nextLine();

      System.out.print("전화: ");
      phonenumber[i] = keyboard.nextLine();

      date[i] = new Date(System.currentTimeMillis());

      System.out.println();

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }


    keyboard.close();

    System.out.println("-------------------------------"); 



    for (int i = 0; i < count; i++){
      System.out.printf("%d, %s, %s, %s, %s\n", 
          no[i], name[i], email[i], phonenumber[i], date[i]);


    }
  }
}
