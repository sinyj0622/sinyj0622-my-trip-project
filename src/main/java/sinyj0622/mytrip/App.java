package sinyj0622.mytrip;

import java.util.Scanner;

public class App{

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    TravelPlanHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;

    String command;
    do {
      System.out.print("명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/lesson/add":
          TravelPlanHandler.addTravelPlan();
          break;
        case "/lesson/list":
          TravelPlanHandler.listTravelPlan();
          break;
        case "/member/add":  
          MemberHandler.addMember();
          break;
        case "/member/list":  
          MemberHandler.listMember();
          break;      
        case "/board/add":
          BoardHandler.addBoard();
          break;          
        case "/board/list":
          BoardHandler.listBoard();
          break;
        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }
    } while (!command.equalsIgnoreCase("quit"));
    System.out.println("안녕!");
    keyboard.close();

  }






}
