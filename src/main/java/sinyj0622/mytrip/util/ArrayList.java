package sinyj0622.mytrip.util;

import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E> {

  static final int DEFAULT_CAPACITY = 100;

  Object[] elementData;
  

  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
     this.elementData = new Object[DEFAULT_CAPACITY];
    }
    this.elementData = new Object[initialCapacity];
  }
  
  
  public void add(E e) {
    if (this.elementData.length > this.size) {
      int oldData = this.elementData.length;
      int newData = oldData + (oldData >> 1);
      
      Object[] newArr = new Object[newData];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
    }
    this.elementData[this.size++] = e;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {    
    if (index <0 || index >= this.size) {
    return null;
  }
    
    return (E) this.elementData[index];
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index <0 || index >= this.size) {
      return null;
    }
    E oldValue = (E) this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index <0 || index >= this.size) {
      return null;
    }
    
    E oldValue = (E) this.elementData[index];
    System.arraycopy(this.elementData, index + 1,
      this.elementData, index , this.size - (index + 1));
     /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementDate[index - 1] = this.elementDate[index];
    }*/
    size--;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public Object[] toArray() {
    return Arrays.copyOf(this.elementData, this.size);
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
    return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass());
    }
    System.arraycopy(this.elementData, 0, arr, 0, this.size);
    return arr;
  }
  

  public void add(int index, E e) {
    if (index < 0 || index >= this.size)
      return;

    if (this.size == this.elementData.length) {
      grow();
    }

    for (int i = size - 1; i >= index; i--)
      this.elementData[i + 1] = this.elementData[i];

    this.elementData[index] = e;
    this.size++;
  }
  
  private Object[] grow() {
    return this.elementData = Arrays.copyOf(this.elementData, 
        newCapacity());
  }
  
  private int newCapacity() {
    int oldSize = this.elementData.length;
    return oldSize + (oldSize >> 1);
  }
  
  
  
}
