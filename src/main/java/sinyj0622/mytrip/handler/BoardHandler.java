package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Scanner;
import sinyj0622.mytrip.domain.Board;
import sinyj0622.mytrip.util.ArrayList;
import sinyj0622.mytrip.util.Prompt;

public class BoardHandler {


  ArrayList<Board> boardList;

  Prompt prompt;


  public BoardHandler(Prompt prompt) {
    this.prompt = prompt;
    this.boardList = new ArrayList<>();
  }
  
  public BoardHandler(Prompt prompt, int capacity) {
    this.prompt = prompt;
    this.boardList = new ArrayList<>(capacity);
  }

  public void addBoard() {
    Board board = new Board();


    board.setNo(prompt.inputInt("번호: "));
    board.setText(prompt.inputString("내용: "));
    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);


    this.boardList.add(board);
    System.out.println("내용을 저장하였습니다.");

  }

  public void listBoard() {
    
    Board[] arr = new Board[this.boardList.size()];
    
    this.boardList.toArray(arr);
    
    for (Board b : arr) {
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getText(), b.getDate(), b.getViewCount());
    }

  }


  public void detailBoard() {
  
    int index = indexOfBoard(prompt.inputInt("번호? "));
   
    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    
    Board board = this.boardList.get(index);
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("내용: %s\n", board.getText() );
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());

  }
  
  public void updateBoard() {
    
    int index = indexOfBoard(prompt.inputInt("번호? "));
    
    
    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    
    Board oldBoard = this.boardList.get(index);
    String text = prompt.inputString("내용(%s)?", oldBoard.getText());

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
	  
    int index = indexOfBoard(prompt.inputInt("번호? "));
    
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
