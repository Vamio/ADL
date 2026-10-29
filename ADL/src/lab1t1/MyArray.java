package lab1t1;

public class MyArray<E> {
	private int size;
	private Object[] elements = new Object[5];
	
	public MyArray() {
		size = 0;
	}
	
	public void add(E e) {
		if (size == elements.length) {
			// Extending array
			Object[] temp = new Object[size + 5];
			System.arraycopy(elements, 0, temp, 0, size);
			elements = temp;
		}
		elements[size] = e;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public E get(int index) {
		return (E) elements[index];
	}
	
	public void remove(int index) {
		if (index == size) {
			size--;
		}
		else {
			System.arraycopy(elements, index+1, elements, index, elements.length - 1 - index);
			elements[size--] = null;
		}
	}
	
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}
	
	public Stack<E> toStack() {
		Stack<E> stack = new Stack<>();
		
		for(int i = size - 1; i >= 0; i--) {
			stack.push(get(i));
		}
		return stack;
	}
}
