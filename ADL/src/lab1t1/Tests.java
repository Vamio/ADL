package lab1t1;

import java.util.NoSuchElementException;

public class Tests {
	public static void testDLL() {
		//Double linked list
		System.out.println("Double linked list.");
		DLList dllist = new DLList();
		System.out.println("Testing empty list:");
		System.out.println("Is empty: " + dllist.isEmpty());
		System.out.println("The size is: " + dllist.size());
				
		System.out.println("Adding data to the list...");
		for (Object o : MyData.DATA) {
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
		
		try {
			dllist.getFirst();
			dllist.getLast();
			dllist.removeBeginning();
			dllist.removeEnd();
			
		} catch(NoSuchElementException e) {
			System.out.println("List is empty, skipping...");
		}
		
		System.out.println("Is empty: " + dllist.isEmpty());
		System.out.println("The size is: " + dllist.size());
		System.out.println();
		
		System.out.println("Adding data to the list...");
		for (Object o : MyData.DATA) {
			dllist.insertBeginning(o);
		}
		System.out.println("First element is " + dllist.getFirst());
		System.out.println("Last element is " + dllist.getLast());
		System.out.println();
		System.out.println("Removing first and last elements...");
		System.out.println(dllist.removeBeginning());
		System.out.println(dllist.removeEnd());
		System.out.println("The size is: " + dllist.size());
		System.out.println("First element is " + dllist.getFirst());
		System.out.println("Last element is " + dllist.getLast());
		dllist.print();
		System.out.println();
	}
	
	public static void main(String[] args) {
		testDLL();
		
		
	}

}
