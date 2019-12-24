package sinyj0622.mytrip;

import java.util.Scanner;
import sinyj0622.mytrip.handler.BoardHandler;
import sinyj0622.mytrip.handler.BoardHandler2;
import sinyj0622.mytrip.handler.BoardHandler3;
import sinyj0622.mytrip.handler.BoardHandler4;
import sinyj0622.mytrip.handler.BoardHandler5;
import sinyj0622.mytrip.handler.MemberHandler;
import sinyj0622.mytrip.handler.TravelPlanHandler;

public class App{

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    TravelPlanHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
    BoardHandler2.keyboard = keyboard;
    BoardHandler3.keyboard = keyboard;
    BoardHandler4.keyboard = keyboard;
    BoardHandler5.keyboard = keyboard;
    

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
        case "/board/detail":
          BoardHandler.detailBoard();
          break;
        case "/board2/add":
          BoardHandler2.addBoard();
          break;          
        case "/board2/list":
          BoardHandler2.listBoard();
          break;
        case "/board2/detail":
          BoardHandler2.detailBoard();
          break;
        case "/board3/add":
          BoardHandler3.addBoard();
          break;          
        case "/board3/list":
          BoardHandler3.listBoard();
          break;
        case "/board3/detail":
          BoardHandler3.detailBoard();
          break;
        case "/board4/add":
          BoardHandler4.addBoard();
          break;          
        case "/board4/list":
          BoardHandler4.listBoard();
          break;
        case "/board4/detail":
          BoardHandler4.detailBoard();
          break;
        case "/board5/add":
          BoardHandler5.addBoard();
          break;          
        case "/board5/list":
          BoardHandler5.listBoard();
          break;
        case "/board5/detail":
          BoardHandler5.detailBoard();
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
