package sinyj0622.mytrip;

import java.util.Scanner;
import sinyj0622.mytrip.handler.BoardHandler;
import sinyj0622.mytrip.handler.MemberHandler;
import sinyj0622.mytrip.handler.TravelPlanHandler;

public class App{

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    
    BoardHandler edit1 = new BoardHandler(keyboard);
    BoardHandler edit2 = new BoardHandler(keyboard);
    BoardHandler edit3 = new BoardHandler(keyboard);
    BoardHandler edit4 = new BoardHandler(keyboard);
    BoardHandler edit5 = new BoardHandler(keyboard);
    MemberHandler memberEdit1 = new MemberHandler(keyboard);
    TravelPlanHandler planEdit1 = new TravelPlanHandler(keyboard);
    

    String command;
    do {
      System.out.print("명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "여행계획/추가":
          planEdit1.addTravelPlan();
          break;
        case "여행계획/목록":
          planEdit1.listTravelPlan();
          break;
        case "회원정보/추가":  
          memberEdit1.addMember();
          break;
        case "회원정보/목록":  
          memberEdit1.listMember();
          break;      
        case "게시글/추가":
          edit1.addBoard();
          break;          
        case "게시글/목록":
          edit1.listBoard();
          break;
        case "게시글/세부사항":
          edit1.detailBoard();
          break;
        case "게시글2/추가":
          edit2.addBoard();
          break;          
        case "게시글2/목록":
          edit2.listBoard();
          break;
        case "게시글2/세부사항":
          edit2.detailBoard();
          break;
        case "게시글3/추가":
          edit3.addBoard();
          break;          
        case "게시글3/목록":
          edit3.listBoard();
          break;
        case "게시글3/세부사항":
          edit3.detailBoard();
          break;
        case "게시글4/추가":
          edit4.addBoard();
          break;          
        case "게시글4/목록":
          edit4.listBoard();
          break;
        case "게시글4/세부사항":
          edit4.detailBoard();
          break;
        case "게시글5/추가":
          edit5.addBoard();
          break;          
        case "게시글5/목록":
          edit5.listBoard();
          break;
        case "게시글5/세부사항":
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
