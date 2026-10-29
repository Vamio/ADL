package lab1t1;

import java.util.Objects;
import java.util.NoSuchElementException;

public class DLList<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public DLList() {
		head = null;
		tail = null; 
		size = 0;
	}
	
	private class Node<E>{
		private E element = null;
		private Node<E> next; 
		private Node<E> prev;
		
		private Node(E element){
			this.element = element;
		}
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void insertBeginning(E el) {
	    Node<E> node = new Node<>(el);
	    
	    if (isEmpty()) {
	        tail = node;
	    } else {
	        node.next = head;
	        head.prev = node;
	    }
	    
	    head = node;
	    size++;
	}
	
	public void insertEnd(E el) {
		Node<E> node = new Node<>(el);
		
	    if (isEmpty()) {
	        head = node;
	    } else {
	        node.prev = tail;   // new node points back to the old last node
	        tail.next = node;   // old last node points forward to the new node
	    }
	    
	    tail = node;
	    size++;
	}
	
	public E removeBeginning() {
		if (isEmpty()) {
	        throw new NoSuchElementException("List is empty.");
	    }
	    E element = head.element;
	    if (head == tail) {
	        head = null;
	        tail = null;
	    } else {
	        Node<E> oldHead = head;
	        head = head.next;
	        head.prev = null;
	        oldHead.next = null;
	    }
	    size--;
	    
	    return element;
	}
	
	public E removeEnd() {
		if(isEmpty()) {
			System.out.println("List is empty.");
			throw new NoSuchElementException("List is empty.");
		}
		
		E element = tail.element;
		
		if (head == tail) {
	        head = null;
	        tail = null;
	    } else {
	        Node<E> temp = tail;
	        tail = tail.prev;
	        tail.next = null;
	        temp.prev = null;
	    }
		
	       size--;
	       
	       return element;
	}
	
	public boolean remove(E el) {
		Node<E> temp = head;
		Node<E> prev = null;
		
		while(temp != null) {
			if(Objects.equals(el, temp.element)) {
				if(prev == null) {
					head = temp.next;
				} else {
					prev.next = temp.next;
				}
				size--;
				return true;
			}
			prev = temp;
			temp = prev.next;
		}
		return false;
	}
	
	public E getFirst() {
		if(isEmpty()) {
			System.out.println("List is empty.");
			throw new NoSuchElementException("List is empty.");
		}
		return head.element;
	}
	
	public E getLast() {
		if(isEmpty()) {
			System.out.println("List is empty.");
			throw new NoSuchElementException("List is empty.");
		}
		return tail.element;
	}
	
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new NoSuchElementException(":(");
		}
		Node<E> tempNode = head;
		
		for (int i = 0; i < index; i++) {
			tempNode = tempNode.next;
		}
		
		return tempNode.element;
	}
	
	public void clear() {
		head = null;
		tail = null; 
		size = 0;
	}
	
    public void print() {
    	Node<E> current = head;
    	while (current != null) {
    		System.out.print(current.element + " ");
    		current = current.next;
    	}
    	System.out.println();
    }	
}