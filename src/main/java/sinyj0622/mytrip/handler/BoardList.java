package sinyj0622.mytrip.handler;

import java.util.Arrays;
import sinyj0622.mytrip.domain.Board;

public class BoardList {

  static final int BOARD_SIZE = 100;

  Board[] boards;
  int boardCount = 0;


  public BoardList() {
    this.boards = new Board[BOARD_SIZE];
  }


  public BoardList(int capacity) {
    if (capacity < BOARD_SIZE || capacity > 10000) 
      this.boards = new Board[BOARD_SIZE];
    else
      this.boards = new Board[capacity];
  }


  public void add(Board board) {
    if (this.boards.length == this.boardCount) {
      int oldCapacity = this.boards.length;
      int newCapacity = oldCapacity + (oldCapacity << 1);
      this.boards = Arrays.copyOf(this.boards, newCapacity);
    }
    this.boards[this.boardCount++] = board;

  }


  public Board[] toArray() {
    return Arrays.copyOf(this.boards, this.boardCount);

  }


  public Board get(int no) {
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].getNo() == no) {
        return this.boards[i];
      }
    }
    return null;
  }


}
