package lab1t1;

public class Dequeues<E>{
	private DLList<E> list; 
	
	public Dequeues() {
		list = new DLList<>();
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void insertFirst(E el) {
		list.insertBeginning(el);
	}
	
	public void insertLast(E el) {
		list.insertEnd(el);
	}
	
	public E removeFirst() {
		return list.removeBeginning();
	}
	
	public E removeLast() {
		return list.removeEnd();
	}
	
	public E getFirst() {
		return list.getFirst();
	}
	
	public E getLast() {
		return list.getLast();
	}
	
	public void print() {
		list.print();
	}
	
	public Stack<E> toStack(){
		Stack<E> stack = new Stack<>();
		
		for(int i = 0; i < list.size(); i++) {
			E element = list.removeEnd();
			stack.push(element);
			list.insertBeginning(element);
		}
		return stack;
	}

}
