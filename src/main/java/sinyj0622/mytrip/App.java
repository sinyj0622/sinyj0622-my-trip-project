package sinyj0622.mytrip;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Board;
import sinyj0622.mytrip.domain.Member;
import sinyj0622.mytrip.domain.Plan;
import sinyj0622.mytrip.handler.BoardAddCommand;
import sinyj0622.mytrip.handler.BoardDeleteCommand;
import sinyj0622.mytrip.handler.BoardDetailCommand;
import sinyj0622.mytrip.handler.BoardListCommand;
import sinyj0622.mytrip.handler.BoardUpdateCommand;
import sinyj0622.mytrip.handler.Command;
import sinyj0622.mytrip.handler.MemberHandler;
import sinyj0622.mytrip.handler.PlanHandler;
import sinyj0622.mytrip.util.Prompt;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {


    Prompt prompt = new Prompt(keyboard);

    ArrayList<Board> boardList = new ArrayList<>();
    Command boardAddCommand = new BoardAddCommand(prompt, boardList);
    Command boardListCommand = new BoardListCommand(boardList);
    Command boardDeleteCommand = new BoardDeleteCommand(prompt, boardList);
    Command boardDetailCommand = new BoardDetailCommand(prompt, boardList);
    Command boardUpdateCommand = new BoardUpdateCommand(prompt, boardList);

    LinkedList<Member> memberList = new LinkedList<>();
    MemberHandler memberEdit1 = new MemberHandler(prompt, memberList);

    ArrayList<Plan> planList = new ArrayList<>();
    PlanHandler planEdit1 = new PlanHandler(prompt, planList);


    String command;
    do {
      System.out.print("명령> ");
      command = keyboard.nextLine();

      commandStack.push(command);
      commandQueue.offer(command);

      switch (command) {
        case "/plan/add":
          planEdit1.addTravelPlan();
          break;
        case "/plan/list":
          planEdit1.listTravelPlan();
          break;
        case "/plan/detail":
          planEdit1.detailPlan();
          break;
        case "/plan/update":
          planEdit1.updatePlan();
          break;
        case "/plan/delete":
          planEdit1.deletePlan();
          break;
        case "/member/add":
          memberEdit1.addMember();
          break;
        case "/member/list":
          memberEdit1.listMember();
          break;
        case "/member/detail":
          memberEdit1.detailMember();
          break;
        case "/member/update":
          memberEdit1.updateMember();
          break;
        case "/member/delete":
          memberEdit1.deleteMember();
          break;
        case "/board/add":
          boardedit1.addBoard();
          break;
        case "/board/list":
          boardedit1.listBoard();
          break;
        case "/board/detail":
          boardedit1.detailBoard();
          break;
        case "/board/update":
          boardedit1.updateBoard();
          break;
        case "/board/delete":
          boardedit1.deleteBoard();
          break;
        case "history":
          printCommandHistory(commandStack.iterator());
          break;
        case "history2":
          printCommandHistory(commandQueue.iterator());
          break;
        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }
    } while (!command.equalsIgnoreCase("quit"));
    System.out.println("종료하였습니다.");
    keyboard.close();

  }

  public static void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;

      if ((count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }



}
