package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.List;
import sinyj0622.mytrip.domain.Board;
import sinyj0622.mytrip.util.Prompt;

public class HelloCommand implements Command {

  Prompt prompt;


  public HelloCommand(Prompt prompt) {
    this.prompt = prompt;
  }


  @Override
  public void execute() {
	
    String name = prompt.inputString("이름?: ");
    System.out.printf("%s님 반갑습니다.\n", name);
  }


}
