package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import sinyj0622.mytrip.domain.Member;
import sinyj0622.mytrip.util.Prompt;

public class MemberListCommand implements Command {


  List<Member> memberList;


  public MemberListCommand(List<Member> list) {
    this.memberList = list;
  }

 
  public void execute() {

	Iterator<Member> iterator = memberList.iterator();
	while (iterator.hasNext()) {
		Member m = iterator.next();
      System.out.printf("%d, %s, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          m.getPhonenumber(), m.getRegisteredDate());
    }
  }


}
