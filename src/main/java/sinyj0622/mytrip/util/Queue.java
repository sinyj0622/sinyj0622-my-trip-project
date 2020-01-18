package sinyj0622.mytrip.util;

public class Queue<E> extends LinkedList<E> implements Cloneable{

  public void offer(E value) {
    this.add(value);
  }
  
  public E poll() {
    return this.remove(0);
  }
  
  @Override
  public Queue<E> clone() {
    Queue<E> temp = new Queue<E>();
    
    for (int i = 0; i < this.size; i++) {
      temp.offer(this.get(i));
    }
    

    return temp;
  }

  public Iterator<E> iterator(){
	  
	  
    return new Iterator<E>(){

		  Queue<E> queue;
		  
		  {
		    this.queue = (Queue<E>)Queue.this.clone(); // 바깥클래스 인스턴스 멤버.clone 사용
		  }
		  
		  @Override
		  public boolean hasNext() {
		    return queue.size() > 0;
		  }
		  
		  @Override
		  public E next() {
		    return queue.poll();
		  }
		};
  }
  
  

}
