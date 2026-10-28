package lab1t1;

import java.util.NoSuchElementException;

public class Stack<E> {
	private Node<E> top;
	private int size; 
	
	public Stack() {
		top = null;
		size = 0;
	}
	
	private static class Node<E>{
		private final E value;
		private Node<E> next;
		
		private Node(E value) {
			this.value = value;
		}
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int size() {
		return size;
	}
	
	public void push(E element) {
		Node<E> node = new Node<>(element);
		node.next = top;
		top = node;
		size++;
	}
	
	public E top() {
		if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
		
		return top.value;
	}
	
	public E pop() {
		if (isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
		
		E value = top.value;
		top = top.next;
		size--;
		
		return value;
	}
	
	public Dequeues<E> toDequeue(){
		Dequeues<E> dequeue = new Dequeues<>();
		Node<E> current = top;
		
		while(current != null) {
			dequeue.insertLast(current.value);
			current = current.next;
		}
		return dequeue;
	}
	
	public void print() {
        Node<E> current = top;
        System.out.println("-------");
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println("-------");
    }
}
