package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.List;
import sinyj0622.mytrip.domain.Board;
import sinyj0622.mytrip.util.Prompt;

public class BoardUpdateCommand implements Command {


  List<Board> boardList;

  Prompt prompt;


  public BoardUpdateCommand(Prompt prompt, List<Board> list) {
    this.prompt = prompt;
    this.boardList = list;
  }



  @Override
  public void execute() {

    int index = indexOfBoard(prompt.inputInt("번호? "));


    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    Board oldBoard = this.boardList.get(index);
    Board newBoard = new Board();
 

    newBoard.setNo(oldBoard.getNo());
    newBoard.setViewCount(oldBoard.getViewCount());
    newBoard.setDate(new Date(System.currentTimeMillis()));
    newBoard.setText(
    		prompt.inputString(String.format("내용(%s)? ", oldBoard.getText())));

    
    if (newBoard.equals(oldBoard)) {
    	System.out.println("게시글 변경을 취소했습니다.");
    	return;
    }
    
    this.boardList.set(index, newBoard);

    System.out.println("게시글을 변경했습니다.");
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
