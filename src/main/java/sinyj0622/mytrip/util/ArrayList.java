package sinyj0622.mytrip.util;

import java.util.Arrays;

public class ArrayList<E> {

  static final int DEFAULT_CAPACITY = 100;

  Object[] elementDate;
  int size;


  public ArrayList() {
    this.elementDate = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
     this.elementDate = new Object[DEFAULT_CAPACITY];
    }
    this.elementDate = new Object[initialCapacity];
  }
  
  
  public void add(E e) {
    if (this.elementDate.length > this.size) {
      int oldData = this.elementDate.length;
      int newData = oldData + (oldData >> 1);
      
      Object[] newArr = new Object[newData];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementDate[i];
      }
      this.elementDate = newArr;
    }
    this.elementDate[this.size++] = e;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {    
    if (index <0 || index >= this.size) {
    return null;
  }
    
    return (E) this.elementDate[index];
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index <0 || index >= this.size) {
      return null;
    }
    E oldValue = (E) this.elementDate[index];
    this.elementDate[index] = e;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index <0 || index >= this.size) {
      return null;
    }
    
    E oldValue = (E) this.elementDate[index];
    System.arraycopy(this.elementDate, index + 1,
      this.elementDate, index , this.size - (index + 1));
     /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementDate[index - 1] = this.elementDate[index];
    }*/
    size--;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public Object toArray() {
    return Arrays.copyOf(this.elementDate, this.size);
    /*Object[] arr = new Object[this.size];
    for (int i = 0; i < size; i++) {
      arr[i] = this.elementDate[i];
    }
    return arr;
    */
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
    return (E[]) Arrays.copyOf(this.elementDate, this.size, arr.getClass());
    }
    System.arraycopy(this.elementDate, 0, arr, 0, this.size);
    return arr;
  }
  
  
  public int size() {
    return this.size = size;
  }
  
  
  
  
  
}
