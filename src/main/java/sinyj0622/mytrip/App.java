package sinyj0622.mytrip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.google.gson.Gson;

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
	static ArrayList<Board> boardList = new ArrayList<>();
	static LinkedList<Member> memberList = new LinkedList<>();
	static ArrayList<Plan> planList = new ArrayList<>();

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
		File file = new File("./board.json");

		try(BufferedReader in = new BufferedReader(new FileReader(file))) {

			Board[] boards = new Gson().fromJson(in, Board[].class);
			for (Board board : boards) {
				boardList.add(board);
			}
			
			System.out.printf("총 %d개의 게시글 데이터를 로딩했습니다.\n", boardList.size());
			
			} catch (IOException e) {
				System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
			}  

		}


		public static void saveBoardData() {
			File file = new File("./board.json");

			try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
				
				out.write( new Gson().toJson(boardList));
					
				System.out.printf("총 %d개의 게시글을 저장하였습니다.\n", boardList.size());

			} catch (IOException e) {
				System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

			}
		}

		public static void loadMemberData() {
			File file = new File("./member.json");

			try(BufferedReader in = new BufferedReader(new FileReader(file))) {

				Member[] members = new Gson().fromJson(in, Member[].class);
				for (Member member : members) {
					memberList.add(member);
				}
				
				System.out.printf("총 %d개의 회원 데이터를 로딩했습니다.\n", memberList.size() );
				
			} catch (IOException e) {
				System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
			} 
			
		}

		public static void saveMemberData() {
			File file = new File("./member.json");

			try (BufferedWriter out = new BufferedWriter(new FileWriter(file))){
				
				out.write(new Gson().toJson(memberList));
				
				System.out.printf("총 %d개의 회원 데이터를 저장하였습니다.\n", memberList.size() );


			} catch (IOException e) {
				System.out.println("파일 저장 중 오류 발생! - " + e.getMessage());
			} 
		}

		public static void loadPlanData() {
			File file = new File("./plan.json");

			try (BufferedReader in = new BufferedReader(new FileReader(file))) {
				
				planList.addAll(Arrays.asList(new Gson().fromJson(in, Plan[].class)));
				
				System.out.printf("총 %d개의 여행계획 데이터를 로딩했습니다.\n", planList.size());


			} catch (IOException e) {
				System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
			}  

		}

		public static void savePlanData() {
			File file = new File("./plan.json");

			try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {

				out.write(new Gson().toJson(planList));
				System.out.printf("총 %d개의 여행계획 데이터를 저장하였습니다.\n", planList.size());


			} catch (IOException e) {
				System.out.println("파일 저장 중 오류 발생! - " + e.getMessage());
			} 
		}
	}
