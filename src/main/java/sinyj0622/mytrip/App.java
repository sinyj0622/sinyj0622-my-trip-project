package sinyj0622.mytrip;

import java.util.Scanner;
import sinyj0622.mytrip.handler.BoardHandler;
import sinyj0622.mytrip.handler.MemberHandler;
import sinyj0622.mytrip.handler.TravelPlanHandler;

public class App{

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    TravelPlanHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
    
    BoardHandler edit1 = new BoardHandler();
    BoardHandler edit2 = new BoardHandler();
    BoardHandler edit3 = new BoardHandler();
    BoardHandler edit4 = new BoardHandler();
    BoardHandler edit5 = new BoardHandler();
    MemberHandler memberEdit1 = new MemberHandler();
    TravelPlanHandler planEdit1 = new TravelPlanHandler();
    

    String command;
    do {
      System.out.print("명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/TravelPlan/add":
          planEdit1.addTravelPlan();
          break;
        case "/TravelPlan/list":
          planEdit1.listTravelPlan();
          break;
        case "/member/add":  
          memberEdit1.addMember();
          break;
        case "/member/list":  
          memberEdit1.listMember();
          break;      
        case "/board/add":
          edit1.addBoard();
          break;          
        case "/board/list":
          edit1.listBoard();
          break;
        case "/board/detail":
          edit1.detailBoard();
          break;
        case "/board2/add":
          edit2.addBoard();
          break;          
        case "/board2/list":
          edit2.listBoard();
          break;
        case "/board2/detail":
          edit2.detailBoard();
          break;
        case "/board3/add":
          edit3.addBoard();
          break;          
        case "/board3/list":
          edit3.listBoard();
          break;
        case "/board3/detail":
          edit3.detailBoard();
          break;
        case "/board4/add":
          edit4.addBoard();
          break;          
        case "/board4/list":
          edit4.listBoard();
          break;
        case "/board4/detail":
          edit4.detailBoard();
          break;
        case "/board5/add":
          edit5.addBoard();
          break;          
        case "/board5/list":
          edit5.listBoard();
          break;
        case "/board5/detail":
          edit5.detailBoard();
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
