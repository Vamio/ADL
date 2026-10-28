package lab1t1;

public class Tests {
	static boolean checkSort(Object[] items) {
		// Check if the data set is all ints
		if(!allInts(items)) {
			System.out.print("Cannot check non-int arrays. ");
			return false;
		}
		// check if ints are in the rising sequence
		for(int i = 0; i < items.length - 1; i++) {
			if((int)items[i] > (int)items[i + 1]) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean allInts(Object[] items) {
		for (Object o : items) {
			if(o == null || o.getClass() != Integer.class) {
				return false;
			}
		}
		return true;
	}
	static int numOfElements(Object[] items) {
		return items.length;
	}
		
	static void testingInts() {
		System.out.println("Testing if data sets are of type Integer:");
		System.out.println("DATA is of type Integer: " + allInts(MyData.DATA));
		System.out.println("DATA1 is of type Integer: " + allInts(MyData.DATA1));
		System.out.println("DATA2 is of type Integer: " + allInts(MyData.DATA2));
		System.out.println();
	}
	
	static void testingSort() {
		System.out.println("Testing if data sets are sorted starting from the smallest Integer:");
		System.out.println("DATA is sorted: " + checkSort(MyData.DATA));
		System.out.println("DATA1 is sorted: " + checkSort(MyData.DATA1));
		System.out.println("DATA2 is sorted: " + checkSort(MyData.DATA2));
		System.out.println();
	}
	
	static void testingNumOfEls() {
		System.out.println("Testing a number of elements:");
		System.out.println("DATA has " + numOfElements(MyData.DATA)+ " elements");
		System.out.println("DATA1 has " + numOfElements(MyData.DATA1)+ " elements");
		System.out.println("DATA2 has " + numOfElements(MyData.DATA2)+ " elements");
	}
	
	public static void main(String[] args) {
		testingInts();
		testingSort();
		testingNumOfEls();
	}

}
