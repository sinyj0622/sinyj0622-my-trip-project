package sinyj0622.mytrip;

import java.util.Scanner;
import sinyj0622.mytrip.handler.BoardHandler;
import sinyj0622.mytrip.handler.MemberHandler;
import sinyj0622.mytrip.handler.PlanHandler;

public class App{

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    
    BoardHandler edit1 = new BoardHandler(keyboard);
    MemberHandler memberEdit1 = new MemberHandler(keyboard);
    PlanHandler planEdit1 = new PlanHandler(keyboard);
    

    String command;
    do {
      System.out.print("명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/plan/add":
          planEdit1.addTravelPlan();
          break;
        case "/plan/list":
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
