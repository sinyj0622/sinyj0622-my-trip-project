package sinyj0622.mytrip.handler;

import java.util.Arrays;
import sinyj0622.mytrip.domain.Member;

public class MemberList {

  static final int MEMBER_SIZE = 100;

  Member[] members;
  int memberCount = 0;

  public MemberList() {
    this.members = new Member[MEMBER_SIZE];
  }

  public MemberList(int capacity) {
    if (capacity < MEMBER_SIZE || capacity > 10000)
      this.members = new Member[MEMBER_SIZE];
    else
      this.members = new Member[capacity];
  }


  public void add(Member member) {
    if (this.memberCount == this.members.length) {
      int oldCapacity = this.members.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.members = Arrays.copyOf(this.members, newCapacity);
    }
    this.members[this.memberCount++] = member;
  }


  public Member[] toArray() {
    return Arrays.copyOf(this.members, this.memberCount);

  }



}
