package sinyj0622.mytrip.util;

public abstract class AbstractList<E> implements List<E> {
  protected int size;
  
  public int size() {
    return this.size = size;
  }
  
  @Override
  public Iterator<E> iterator() {
    return new ListIterator<>(this);
  }
  
  
}

