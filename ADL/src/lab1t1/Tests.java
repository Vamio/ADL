package lab1t1;

import java.util.NoSuchElementException;

public class Tests {
	public static final int[] DATA = {1, 34, 5, 15, 65, -1, 777, -67, 2346789, -999, 0};
	
	public static void testDLL() {
		//Double linked list
		System.out.println("==== Double linked list ====");
		DLList<Integer> dllist = new DLList<>();
		System.out.println("Testing empty list:");
		System.out.println("Is empty: " + dllist.isEmpty());
		System.out.println("The size is: " + dllist.size());
				
		System.out.println("Adding data to the list...");
		for (Integer o : DATA) {
			dllist.insertBeginning(o);
		}
				
		System.out.println();
		System.out.println("Testing filled list:");
		System.out.println("Is empty: " + dllist.isEmpty());
		System.out.println("The size is: " + dllist.size());
		System.out.print("printing array: ");
		dllist.print();
		System.out.println();
		
		System.out.println("Testing get and remove on empty DLL:");
		dllist.clear();
		
		// trying the methods get... and remove... with the empty list
		try {
			dllist.getFirst();
			System.out.println("getFirst: no exception (error)");
		} catch (NoSuchElementException e) {
			System.out.println("getFirst: exception (ok)");
		}
		try {
			dllist.getLast();
			System.out.println("getLast: no exception (error)");
		} catch (NoSuchElementException e) {
			System.out.println("getLast: exception (ok)");
		}
		try {
			dllist.removeBeginning();
			System.out.println("removeBeginning: no exception (error)");
		} catch (NoSuchElementException e) {
			System.out.println("removeBeginning: exception (ok)");
		}
		try {
			dllist.removeEnd();
			System.out.println("removeEnd: no exception (error)");
		} catch (NoSuchElementException e) {
			System.out.println("removeEnd: exception (ok)");
		}
		
		System.out.println("Is empty: " + dllist.isEmpty());
		System.out.println("The size is: " + dllist.size());
		System.out.println();
		
		System.out.println("Adding data to the list...");
		for (Integer o : DATA) {
			dllist.insertBeginning(o);
		}
		System.out.println("First element is " + dllist.getFirst());
		System.out.println("Last element is " + dllist.getLast());
		System.out.println();
		System.out.println("Removing first and last elements of the filled list...");
		System.out.println(dllist.removeBeginning());
		dllist.print();
		System.out.println(dllist.removeEnd());
		dllist.print();
		System.out.println("The size is: " + dllist.size());
		System.out.println("First element is " + dllist.getFirst());
		System.out.println("Last element is " + dllist.getLast());
		System.out.print("printing array: ");
		dllist.print();
		System.out.println("4th element is " + dllist.get(3));
		System.out.println();
	}
	
	public static void testDequeue() {
		System.out.println("=== Dequeue ===");
		Dequeues<Integer> dequeue = new Dequeues<>();
		System.out.println("Is empty: " + dequeue.isEmpty());
		System.out.println("The size is: " + dequeue.size());
		try {
			dequeue.getFirst();
			System.out.println("peekFirst: no exception (error)");
		} catch (NoSuchElementException e) {
			System.out.println("peekFirst: exception (ok)");
		}
		try {
			dequeue.getLast();
			System.out.println("peekLast: no exception (error)");
		} catch (NoSuchElementException e) {
			System.out.println("peekLast: exception (ok)");
		}
		try {
			dequeue.removeFirst();
			System.out.println("removeFirst: no exception (error)");
		} catch (NoSuchElementException e) {
			System.out.println("removeFirst: exception (ok)");
		}
		try {
			dequeue.removeLast();
			System.out.println("removeLast: no exception (error)");
		} catch (NoSuchElementException e) {
			System.out.println("removeLast: exception (ok)");
		}
		System.out.println("Adding data at the back (addLast)...");
		for (int item : DATA) {
			dequeue.insertLast(item);
		}
		System.out.println("The size is: " + dequeue.size());
		System.out.print("Dequeue: ");
		dequeue.print();
		System.out.println("Front is " + dequeue.getFirst() + " (expected " + DATA[0] + ")");
		System.out.println("Back is " + dequeue.getLast() + " (expected "
				+ DATA[DATA.length - 1] + ")");
		System.out.print("addLast + removeFirst, queue order (FIFO): ");
		while (!dequeue.isEmpty()) {
			System.out.print(dequeue.removeFirst() + " ");
		}
		System.out.println();
		System.out.println("Adding data at the front (addFirst)...");
		for (int item : DATA) {
			dequeue.insertFirst(item);
		}
		System.out.print("Dequeue: ");
		dequeue.print();
		System.out.print("addFirst + removeFirst, stack order (LIFO): ");
		while (!dequeue.isEmpty()) {
			System.out.print(dequeue.removeFirst() + " ");
		}
		System.out.println();
		System.out.println("Mixed: addFirst(2), addLast(3), addFirst(1)...");
		dequeue.insertFirst(2);
		dequeue.insertLast(3);
		dequeue.insertFirst(1);
		System.out.print("Dequeue: ");
		dequeue.print();
		System.out.println("(expected [1, 2, 3])");
		System.out.println("Removed last: " + dequeue.removeLast() + " (expected 3)");
		System.out.println("Removed first: " + dequeue.removeFirst() + " (expected 1)");
		System.out.println("Remaining elements: ");
		dequeue.print();
		System.out.println("Size " + dequeue.size());
		dequeue.removeLast();
		System.out.println("Is empty after removing the last element: " + dequeue.isEmpty());
		System.out.println();
	}
	
	public static void testStack() {
		System.out.println("=== Stack ===");
		Stack<Integer> stack = new Stack<>();
		System.out.println("Is empty: " + stack.isEmpty());
		System.out.println("The size is: " + stack.size());
		try {
			stack.pop();
			System.out.println("pop: no exception (error)");
		} catch (NoSuchElementException e) {
			System.out.println("pop: exception (ok)");
		}
		try {
			stack.top();
			System.out.println("top: no exception (error)");
		} catch (NoSuchElementException e) {
			System.out.println("top: exception (ok)");
		}
		System.out.println("Pushing data onto the stack...");
		for (int item : DATA) {
			stack.push(item);
		}
		System.out.println("The size is: " + stack.size());
		System.out.println("Top element is " + stack.top() + " (expected "
				+ DATA[DATA.length - 1] + ")");
		stack.print();
		System.out.print("Popping all elements: ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		System.out.println("Is empty: " + stack.isEmpty());
		System.out.println();
	}
	
	public static void testTransformations() {
		System.out.println("=== Transformations ===");
		Stack<Integer> stack = new Stack<>();
		
		for (int item : DATA) {
			stack.push(item);
		}
		
		System.out.println("Stack before toDequeue:");
		stack.print();
		Dequeues<Integer> dequeue = stack.toDequeue();
		System.out.println("Stack size after toDequeue (unchanged): " + stack.size());
		System.out.println("Dequeue size: " + dequeue.size());
		System.out.println("Dequeue front is " + dequeue.getFirst() + " (expected top of stack " + stack.top() + ")");
		Stack<Integer> back = dequeue.toStack();
		System.out.println("Dequeue size after toStack (unchanged): " + dequeue.size());
		System.out.println("Stack after round trip stack -> dequeue -> stack:");
		back.print();
		System.out.println("Empty stack -> dequeue is empty: " + new Stack<Integer>().toDequeue().isEmpty());
		System.out.println("Empty dequeue -> stack is empty: " + new Dequeues<Integer>().toStack().isEmpty());
	}
	
	public static void main(String[] args) {
		testDLL();
		testDequeue();
		testStack();
		testTransformations();
	}

}
