package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.List;
import sinyj0622.mytrip.domain.Member;
import sinyj0622.mytrip.util.Prompt;

public class MemberDetailCommand implements Command {


  List<Member> memberList;

  Prompt prompt;


  public MemberDetailCommand(Prompt prompt, List<Member> list) {
    this.prompt = prompt;
    this.memberList = list;
  }



  public void execute() {
    int index = indexOfMember(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    Member member = this.memberList.get(index);
    System.out.printf("번호: %d\n", member.getNo());
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("별명: %s\n", member.getNickname());
    System.out.printf("암호: %s\n", member.getPassWord());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("사진: %s\n", member.getMyphoto());
    System.out.printf("전화: %s\n", member.getPhonenumber());


  }

 
  private int indexOfMember(int no) {
    for (int i = 0; i < this.memberList.size(); i++) {
      if (this.memberList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
