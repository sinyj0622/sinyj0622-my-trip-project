package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Board;
import sinyj0622.mytrip.util.ArrayList;

public class BoardHandler {


  ArrayList<Board> boardList;

  Scanner input;


  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new ArrayList<>();
  }
  
  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    this.boardList = new ArrayList<>(capacity);
  }

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호: ");
    board.setNo(input.nextInt());
    input.nextLine();

    System.out.print("내용: ");
    board.setText(input.nextLine());


    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);


    this.boardList.add(board);
    System.out.println("내용을 저장하였습니다.");
    System.out.println();

  }

  public void listBoard() {
    
    Board[] arr = new Board[this.boardList.size()];
    
    this.boardList.toArray(arr);
    
    for (Board b : arr) {
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getText(), b.getDate(), b.getViewCount());
    }
      System.out.println();
  }


  public void detailBoard() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfBoard(no);
   
    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    
    Board board = this.boardList.get(index);
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("내용: %s\n", board.getText() );
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());

    System.out.println();

  }
  
  public void updateBoard() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();
    
    int index = indexOfBoard(no);
    
    
    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    
    Board oldBoard = this.boardList.get(index);
    System.out.printf("내용(%s)?", oldBoard.getText());
    String text = input.nextLine();

    if (text.length() == 0) {
      System.out.println("게시글 변경을 취소했습니다.");
      return;
    }
    
    Board newBoard = new Board();
    newBoard.setViewCount(oldBoard.getViewCount());
    newBoard.setNo(oldBoard.getNo());
    newBoard.setText(text);
    newBoard.setDate(new Date(System.currentTimeMillis()));
    
    this.boardList.set(index, newBoard);
    
    System.out.println("게시글을 변경했습니다.");
  }
  
  public void deleteBoard() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();
    
    int index = indexOfBoard(no);
    
    
    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    
    this.boardList.remove(index);
    
    System.out.println("게시글을 삭제했습니다.");
  }
  
  private int indexOfBoard(int no) {
    for (int i = 0; i < this.boardList.size(); i++) {
      if (this.boardList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
