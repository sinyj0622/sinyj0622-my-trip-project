package sinyj0622.mytrip.handler;

import java.sql.Date;
import java.util.List;

import sinyj0622.mytrip.domain.Member;
import sinyj0622.mytrip.util.Prompt;

public class MemberAddCommand implements Command{


  List<Member> memberList;

  Prompt prompt;


  public MemberAddCommand(Prompt prompt, List<Member> list) {
    this.prompt = prompt;
    this.memberList = list;
  }


  public void execute() {
    Member member = new Member();
    member.setNo(prompt.inputInt("번호: "));
    member.setName(prompt.inputString("이름: "));
    member.setNickname(prompt.inputString("별명: "));
    member.setPassWord(prompt.inputString("암호: "));
    member.setEmail(prompt.inputString("이메일: "));
    member.setMyphoto(prompt.inputString("사진: "));
    member.setPhonenumber(prompt.inputString("전화: "));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    this.memberList.add(member);
    System.out.println("회원 정보를 저장하였습니다.");

  }

 

}
