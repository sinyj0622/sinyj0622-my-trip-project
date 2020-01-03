package sinyj0622.mytrip.handler;

import java.util.Arrays;

public class ArrayList {

  static final int DEFAULT_CAPACITY = 100;

  Object[] list;
  int size = 0;


  public ArrayList() {
    this.list = new Object[DEFAULT_CAPACITY];
  }


  public ArrayList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000) 
      this.list = new Object[DEFAULT_CAPACITY];
    else
      this.list = new Object[capacity];
  }


  public void add(Object obj) {
    if (this.list.length == this.size) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = obj;

  }


  public Object[] toArray() {
    return Arrays.copyOf(this.list, this.size);

  }


  public Object get(int idx) {
    if (idx >= 0 && idx < this.size) {
      return this.list[idx];
    } else {
      return null;
    }
  }


}
