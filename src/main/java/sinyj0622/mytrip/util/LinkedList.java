package sinyj0622.mytrip.util;

import java.lang.reflect.Array;

public class LinkedList<E> extends AbstractList<E> {

	Node<E> first;
	Node<E> last;

	public void add(E e) {
		Node<E> newNode = new Node<>();
		newNode.value = e;

		if (first == null) {
			last = first = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		this.size++;
	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			return null;
		} else {
			Node<E> cursor = first;
			for(int i = 0; i < index; i++) {
				cursor = cursor.next;
			}
			return (E) cursor.value;
		}
	}

	public void add(int index, E e) {
		if (index < 0 || index >= size) {
			return;
		} else {
			Node<E> newNode = new Node<E>();
			newNode.value = e;

			if (first == null) {
				last = first = newNode;
			} else {
				last.next = newNode;
				last = newNode;
			}
			this.size++;
		}
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size) 
			return null;
		
		
		Node<E> cursor = first;
		for (int i = 0; i < index - 1; i++) {
			cursor = cursor.next;
		}
		
		Node<E> deleteNode = null;
		if (index == 0) {
			deleteNode = first;
			first = deleteNode.next;
		} else {
			deleteNode = cursor.next;
			cursor.next = deleteNode.next;
		}
		deleteNode.next = null;
		size--;
		
		return (E) deleteNode.value;
	}
	

	@SuppressWarnings("unchecked")
	public E set(int index, E e) {
		if (index < 0 || index >= size) 
			return null;
		
		Node<E> cursor = first;
		for (int i = 0; i < index; i++) {
			cursor = cursor.next;
		}
		
		Object oldValue = cursor.value;
		cursor.value = e;
		
		return (E)oldValue;
		
	}
	
	public Object[] toArray() {
		Object[] arr = new Object[size];
		
		Node<E> cursor = first;
		for (int i = 0; i < size; i++)
		{ arr[i] = cursor.value;
		  cursor = cursor.next;
			}
		return arr;
		}

	
	public E[] toArray(E[] arr) {

		if (arr.length < size) {
			arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), size);
		}
		Node<E> cursor = first;
		for (int i = 0; i < size; i++)
		{ arr[i] = cursor.value;
		  cursor = cursor.next;
			}
		return arr;
		}

	
	
	static class Node<T> {
		Node<T> next;
		T value;
	}
}
