package sinyj0622.mytrip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
	static List<Board> boardList = new ArrayList<>();
	static List<Member> memberList = new LinkedList<>();
	static List<Plan> planList = new ArrayList<>();

	public static void main(String[] args) {

		loadBoardData();
		loadMemberData();
		loadPlanData();

		Prompt prompt = new Prompt(keyboard);
		HashMap<String, Command> commandMap = new HashMap<>();

		commandMap.put("/board/add", new BoardAddCommand(prompt, boardList));
		commandMap.put("/board/list", new BoardListCommand(boardList));
		commandMap.put("/board/delete", new BoardDeleteCommand(prompt, boardList));
		commandMap.put("/board/detail", new BoardDetailCommand(prompt, boardList));
		commandMap.put("/board/update", new BoardUpdateCommand(prompt, boardList));

		commandMap.put("/member/add", new MemberAddCommand(prompt, memberList));
		commandMap.put("/member/delete", new MemberDeleteCommand(prompt, memberList));
		commandMap.put("/member/detail", new MemberDetailCommand(prompt, memberList));
		commandMap.put("/member/list", new MemberListCommand(memberList));
		commandMap.put("/member/update", new MemberUpdateCommand(prompt, memberList));

		commandMap.put("/plan/add",new PlanAddCommand(prompt, planList));
		commandMap.put("/plan/delete",new PlanDeleteCommand(prompt, planList));
		commandMap.put("/plan/detail",new PlanDetailCommand(prompt, planList));
		commandMap.put("/plan/list",new PlanListCommand(planList));
		commandMap.put("/plan/update",new PlanUpdateCommand(prompt, planList));

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
				} catch (Exception e) {
					System.out.printf("명령어 실행 중 오류 발생: %s\n", e.getMessage());
				}
			} else {
				System.out.println("실행할 수 없는 명령입니다.");
			}
		}

		keyboard.close();

		saveBoardData();
		saveMemberData();
		savePlanData();

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


	public static void loadBoardData() {

		try(ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("./board.ser2")))) {

			boardList =  (List<Board>) in.readObject();
			
			System.out.printf("총 %d개의 게시글 데이터를 로딩했습니다.\n", boardList.size());
			
			} catch (Exception e) {
				System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
			}  

		}


		public static void saveBoardData() {
			
			try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("./board.ser2")))) {
				
				out.writeObject(boardList);
			
					
				System.out.printf("총 %d개의 게시글을 저장하였습니다.\n", boardList.size());

			} catch (IOException e) {
				System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

			}
		}

		public static void loadMemberData() {

			try(ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("./member.ser2")))) {

				memberList = (List<Member>) in.readObject();
				
				System.out.printf("총 %d개의 회원 데이터를 로딩했습니다.\n", memberList.size() );
				
			} catch (Exception e) {
				System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
			} 
			
		}

		public static void saveMemberData() {

			try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("./member.ser2")))){
				
				out.writeObject(memberList);
				
				System.out.printf("총 %d개의 회원 데이터를 저장하였습니다.\n", memberList.size() );


			} catch (IOException e) {
				System.out.println("파일 저장 중 오류 발생! - " + e.getMessage());
			} 
		}

		public static void loadPlanData() {

			try (ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("./plan.ser2")))) {
				
				planList = (List<Plan>) in.readObject();
				
				System.out.printf("총 %d개의 여행계획 데이터를 로딩했습니다.\n", planList.size());


			} catch (Exception e) {
				System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
			}  

		}

		public static void savePlanData() {

			try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("./plan.ser2")))) {

				out.writeObject(planList);
				
				System.out.printf("총 %d개의 여행계획 데이터를 저장하였습니다.\n", planList.size());


			} catch (IOException e) {
				System.out.println("파일 저장 중 오류 발생! - " + e.getMessage());
			} 
		}
	}
