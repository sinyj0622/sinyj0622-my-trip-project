package sinyj0622.mytrip;

import java.sql.Date;
import java.util.Scanner;

public class App{

  static Scanner keyboard = new Scanner(System.in);

  static class TravelPlan {
    int no;
    String Destnation;
    String travelTitle;
    int person;
    Date startDate;
    Date endDate;
    int travelMoney;
  }

  static final int TRAVELPLANS_SIZE = 100;
  static TravelPlan[] travelPlans = new TravelPlan[TRAVELPLANS_SIZE];
  static int travelplansCount = 0;

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


  static class Board {
    int no;
    String text;
    Date date;
    int viewCount;
  }

  static final int BOARD_SIZE = 100;
  static Board[] boards = new Board[BOARD_SIZE];
  static int boardCount = 0;

  public static void main(String[] args) {


    String command;
    do {
      System.out.print("명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/lesson/add":
          addTravelPlan();

          break;
        case "/lesson/list":
          listTravelPlan();

          break;
        case "/member/add":  
          addMember();
          break;

        case "/member/list":  
          listMember();
          break;      
          
        case "/board/add":
          addBoard();
          break;          

        case "/board/list":
          listBoard();
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

  static void addTravelPlan() {
    TravelPlan travelPlan = new TravelPlan();

    System.out.print("번호: ");
    travelPlan.no = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("여행 제목? ");
    travelPlan.travelTitle = keyboard.nextLine();

    System.out.print("어디로 떠나세요?: ");
    travelPlan.Destnation = keyboard.nextLine();

    System.out.print("여행 인원? ");
    travelPlan.person = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("여행 시작일? ");
    travelPlan.startDate = Date.valueOf(keyboard.nextLine());

    System.out.print("여행 종료일? ");
    travelPlan.endDate = Date.valueOf(keyboard.nextLine());

    System.out.print("예상 경비? ");
    travelPlan.travelMoney = keyboard.nextInt();

    travelPlans[travelplansCount++] = travelPlan;
    System.out.println("저장하였습니다.");

  }

  static void listTravelPlan() {
    for (int i = 0; i < travelplansCount; i++) {
      TravelPlan t = travelPlans[i];
      System.out.printf("%d, %s, %s, %s ~ %s\n", 
          t.no, t.travelTitle, t.Destnation, 
          t.startDate, t.endDate);
    }
  }

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

  }

  static void listMember() {
    for (int i = 0; i < memberCount; i++){
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.no, m.name, m.email, m.phonenumber, m.registeredDate);
    }
  }

  static void addBoard() {
    Board board = new Board();

    System.out.print("번호: ");
    board.no = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("내용: ");
    board.text = keyboard.nextLine();


    board.date = new Date(System.currentTimeMillis());
    board.viewCount = 0;


    boards[boardCount++] = board;
    System.out.println("저장하였습니다.");
  }

  static void listBoard() {
    for (int i = 0; i < boardCount; i++) {
      Board b = boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          b.no, b.text, b.date, b.viewCount);
    }
  }
}
