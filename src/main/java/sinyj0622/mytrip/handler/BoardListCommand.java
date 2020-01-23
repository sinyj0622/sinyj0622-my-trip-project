package sinyj0622.mytrip.handler;

import java.util.Iterator;
import java.util.List;
import sinyj0622.mytrip.domain.Board;
import sinyj0622.mytrip.util.Prompt;

public class BoardListCommand implements Command {


  List<Board> boardList;

  Prompt prompt;


  public BoardListCommand(List<Board> list) {
    this.boardList = list;
  }



  @Override
  public void execute() {

    Iterator<Board> iterator = boardList.iterator();
    while (iterator.hasNext()) {
      Board b = iterator.next();
      System.out.printf("%d, %s, %s, %d\n", b.getNo(), b.getText(), b.getDate(), b.getViewCount());
    }

  }


}
