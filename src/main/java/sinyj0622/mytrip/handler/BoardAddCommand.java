package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.List;
import sinyj0622.mytrip.domain.Board;
import sinyj0622.mytrip.util.Prompt;

public class BoardAddCommand implements Command {


  List<Board> boardList;

  Prompt prompt;


  public BoardAddCommand(Prompt prompt, List<Board> list) {
    this.prompt = prompt;
    this.boardList = list;
  }


  @Override
  public void execute() {
    Board board = new Board();


    board.setNo(prompt.inputInt("번호: "));
    board.setText(prompt.inputString("내용: "));
    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);


    this.boardList.add(board);
    System.out.println("내용을 저장하였습니다.");

  }


}
