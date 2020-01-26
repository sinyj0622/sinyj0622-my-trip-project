package sinyj0622.mytrip;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
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
import sinyj0622.mytrip.handler.HelloCommand;
import sinyj0622.mytrip.handler.MemberAddCommand;
import sinyj0622.mytrip.handler.MemberDeleteCommand;
import sinyj0622.mytrip.handler.MemberDetailCommand;
import sinyj0622.mytrip.handler.MemberListCommand;
import sinyj0622.mytrip.handler.MemberUpdateCommand;
import sinyj0622.mytrip.handler.PlanAddCommand;
import sinyj0622.mytrip.handler.PlanDeleteCommand;
import sinyj0622.mytrip.handler.PlanDetailCommand;
import sinyj0622.mytrip.handler.PlanListCommand;
import sinyj0622.mytrip.handler.PlanUpdateCommand;
import sinyj0622.mytrip.util.Prompt;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {


    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> commandMap = new HashMap<>();
    
    ArrayList<Board> boardList = new ArrayList<>();
    commandMap.put("/board/add", new BoardAddCommand(prompt, boardList));
    commandMap.put("/board/list", new BoardListCommand(boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(prompt, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(prompt, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(prompt, boardList));

    LinkedList<Member> memberList = new LinkedList<>();
    commandMap.put("/member/add", new MemberAddCommand(prompt, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(prompt, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(prompt, memberList));
    commandMap.put("/member/list", new MemberListCommand(memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(prompt, memberList));

    ArrayList<Plan> planList = new ArrayList<>();
    commandMap.put("/plan/add",new PlanAddCommand(prompt, planList));
    commandMap.put("/plan/delete",new PlanDeleteCommand(prompt, planList));
    commandMap.put("/plan/detail",new PlanDetailCommand(prompt, planList));
    commandMap.put("/plan/list",new PlanListCommand(planList));
    commandMap.put("/plan/update",new PlanUpdateCommand(prompt, planList));


    HelloCommand helloCommand = new HelloCommand(prompt);
    commandMap.put("/hello",new HelloCommand(prompt)); 
    
    String command;
    while (true) {
      System.out.print("명령> ");
      command = keyboard.nextLine();
      

      if (command.length() == 0) 
    	  continue;
    	  
      if (command.equals("quit")) {
    	  System.out.println("안녕!");
    	  break;
      } else if (command.equals("history")) {
    	  printCommandHistory(commandStack.iterator());
    	  continue;
      } else if (command.equals("history2")) {
    	  printCommandHistory(commandQueue.iterator());
    	  continue;
      } 
      
      commandStack.push(command);
      
      commandQueue.offer(command);

      
      Command commandHandler = commandMap.get(command);
         
     if (commandHandler != null) {
    	 try {
    	 commandHandler.execute();
    	 } catch(Exception e) {
         System.out.printf("명령어 실행 중 오류 발생: %s\n", e.getMessage());
    	 }
     } else {
    	 System.out.println("실행할 수 없는 명령입니다.");
     }
    }
     
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
