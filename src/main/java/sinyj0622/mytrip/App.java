package sinyj0622.mytrip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
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
		File file = new File("./board.csv");

		FileReader in = null;
		Scanner dataScan = null;

		try {
			in = new FileReader(file);
			dataScan = new Scanner(in);
			int count = 0;

			while (true) {
				try {

					String line = dataScan.nextLine();
					String[] data = line.split(",");

					Board board = new Board();
					board.setNo(Integer.parseInt(data[0]));
					board.setText(data[1]);
					board.setDate(Date.valueOf(data[2]));
					board.setViewCount(Integer.parseInt(data[3]));

					boardList.add(board);
					count++;

				} catch (Exception e) {
					break;
				}
			}
			System.out.printf("총 %d개의 게시글 데이터를 로딩했습니다.\n", count);


		} catch (FileNotFoundException e) {
			System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
		}  

		finally {
			try {
				dataScan.close();
			} catch(Exception e) {

			}
			try {
				in.close();
			} catch (Exception e) {

			}
		}
	}


	public static void saveBoardData() {
		File file = new File("./board.csv");
		FileWriter out = null;

		try {
			out = new FileWriter(file);
			int count = 0;

			for (Board board : boardList) {
				String line = String.format("%d,%s,%s,%d\n", board.getNo(), board.getText(), 
						board.getDate(), board.getViewCount());

				out.write(line);
				count++;
			}

			System.out.printf("총 %d개의 게시글을 저장하였습니다.\n", count);

		} catch (IOException e) {
			System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

		} finally {
			try {
				out.close();
			} catch (IOException e) {

			}
		}
	}

	public static void loadMemberData() {
		File file = new File("./member.csv");
		FileReader in = null;
		Scanner dataScan = null;

		try {
			in = new FileReader(file);
			dataScan = new Scanner(in);
			int count = 0;
			while(true) {
				try{
					String line = dataScan.nextLine();
					String[] data = line.split(",");

					Member member = new Member();
					member.setNo(Integer.parseInt(data[0]));
					member.setName(data[1]);
					member.setNickname(data[2]);
					member.setEmail(data[3]);
					member.setPassWord(data[4]);
					member.setMyphoto(data[5]);
					member.setPhonenumber(data[6]);
					member.setRegisteredDate(Date.valueOf(data[7]));

					memberList.add(member);
					count++;
				} catch(Exception e) {
					break;
				}
			}

			System.out.printf("총 %d개의 회원 데이터를 로딩했습니다.\n", count );
		} catch (FileNotFoundException e) {
			System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
		} finally {
			try {
				dataScan.close();
			} catch (Exception e) {

			}

			try {
				in.close();
			} catch (Exception e) {

			}
		}
	}

	public static void saveMemberData() {
		File file = new File("./member.csv");
		FileWriter out = null;

		try {
			out = new FileWriter(file);
			int count = 0;

			for (Member member : memberList) {
				String line = String.format("%d,%s,%s,%s,%s,%s,%s,%s\n", member.getNo(), member.getName(),
						member.getNickname(), member.getEmail(),member.getPassWord(), member.getMyphoto(),
						member.getPhonenumber(), member.getRegisteredDate());

				out.write(line);
				count++;
			}

			System.out.printf("총 %d개의 회원 데이터를 저장하였습니다.\n", count );


		} catch (IOException e) {
			System.out.println("파일 저장 중 오류 발생! - " + e.getMessage());
		} finally {
			try {
				out.close();
			} catch (IOException e) {

			}
		}
	}

	public static void loadPlanData() {
		File file = new File("./plan.csv");

		FileReader in = null;
		Scanner dataScan = null;

		try {
			in = new FileReader(file);
			dataScan = new Scanner(in);
			int count = 0;

			while (true) {
				try {

					String line = dataScan.nextLine();
					String[] data = line.split(",");

					Plan plan = new Plan();
					plan.setNo(Integer.parseInt(data[0]));
					plan.setDestnation(data[1]);
					plan.setTravelTitle(data[2]);
					plan.setPerson(data[3]);
					plan.setStartDate(data[4]);
					plan.setEndDate(data[5]);
					plan.setTravelMoney(data[6]);

					planList.add(plan);
					count++;

				} catch (Exception e) {
					break;
				}
			}
			System.out.printf("총 %d개의 여행계획 데이터를 로딩했습니다.\n", count);


		} catch (FileNotFoundException e) {
			System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
		}  

		finally {
			try {
				dataScan.close();
			} catch(Exception e) {

			}
			try {
				in.close();
			} catch (Exception e) {

			}
		}
	}

	public static void savePlanData() {
		File file = new File("./plan.csv");
		FileWriter out = null;

		try {
			out = new FileWriter(file);
			int count = 0;

			for (Plan plan : planList) {
				String line = String.format("%d,%s,%s,%s,%s,%s,%s\n", plan.getNo(),plan.getDestnation(),
						plan.getTravelTitle(), plan.getPerson(), plan.getStartDate(), plan.getEndDate(),
						plan.getTravelMoney());
				out.write(line);
				count++;
			}

			System.out.printf("총 %d개의 여행계획 데이터를 저장하였습니다.\n", count );


		} catch (IOException e) {
			System.out.println("파일 저장 중 오류 발생! - " + e.getMessage());
		} finally {
			try {
				out.close();
			} catch (IOException e) {

			}
		}
	}
}
