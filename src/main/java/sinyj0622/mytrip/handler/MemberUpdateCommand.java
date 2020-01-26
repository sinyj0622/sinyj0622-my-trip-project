package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.List;
import sinyj0622.mytrip.domain.Member;
import sinyj0622.mytrip.util.Prompt;

public class MemberUpdateCommand implements Command {


  List<Member> memberList;

  Prompt prompt;


  public MemberUpdateCommand(Prompt prompt, List<Member> list) {
    this.prompt = prompt;
    this.memberList = list;
  }


 

  public void execute() {
    int index = indexOfMember(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    Member oldMember = this.memberList.get(index);
    Member newMember = new Member();


    String inputStr = null;
    newMember.setNo(oldMember.getNo());

    newMember.setName(
        prompt.inputString(String.format("이름(%s)?", oldMember.getName()), oldMember.getName()));

    newMember.setNickname(prompt.inputString(String.format("별명(%s)?", oldMember.getNickname()),
        oldMember.getNickname()));

    newMember.setPassWord(prompt.inputString(String.format("암호(%s)?", oldMember.getPassWord()),
        oldMember.getPassWord()));

    newMember.setEmail(
        prompt.inputString(String.format("이메일(%s)?", oldMember.getEmail()), oldMember.getEmail()));

    newMember.setMyphoto(prompt.inputString(String.format("사진(%s)?", oldMember.getMyphoto()),
        oldMember.getMyphoto()));

    newMember.setPhonenumber(prompt.inputString(
        String.format("전화(%s)?", oldMember.getPhonenumber()), oldMember.getPhonenumber()));


    if (oldMember.equals(newMember)) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }
    this.memberList.set(index, newMember);
    System.out.println("회원을 변경했습니다.");

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
