package sinyj0622.mytrip.util;

import java.util.Arrays;

public class Stack<E> implements Cloneable {

  private static final int DEFAULT_CAPACITY = 10;
  Object[] elememtData;
  int size;

  public Stack() {
    this.elememtData = new Object[DEFAULT_CAPACITY];
    this.size = 0;
  }

  public void push(E value) {
    if (this.elememtData.length == this.size) 
      grow();
    this.elememtData[this.size++] = value;
  }

  public void grow() {
    this.elememtData = Arrays.copyOf(this.elememtData, newCapacity());
  }

  public int newCapacity() {
    int oldCapacity = this.elememtData.length;
    return oldCapacity + (oldCapacity >> 1);
  }

  public E pop() {
    if (this.empty()) 
      return null;
    E value = (E) this.elememtData[--this.size];
    return value;
  }

  public boolean empty() {
    return this.size == 0;
  }

  /*
  @Override
  public Stack clone() {
    try {
      return (Stack)super.clone();
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
  */

  @Override
  public Stack<E> clone() {
    try {
      Stack temp = (Stack) super.clone();
      Object[] arr = new Object[this.size];
      for (int i = 0; i < this.size; i++) {
        arr[i] = this.elememtData[i];
      }
      temp.elememtData = arr;
      
      return temp;

    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
  
  public Iterator<E> iterator(){
    return new StackIterator<>(this);
  }

}
