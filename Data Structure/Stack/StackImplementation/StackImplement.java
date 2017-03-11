
public class StackImplement {

	protected int stackarray[];
	protected int size, top, len;

	public StackImplement(int size) {
		this.size = size;
		stackarray = new int[size];
		top = -1;
	}

	public void push(int data) {
		top++;
		stackarray[top] = data;
	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (top == size - 1) {
			return true;
		} else {
			return false;
		}
	}

	public int pop() {
		int data = stackarray[top];
		top--;
		return data;
	}

	public int peek() {
		int data = stackarray[top];
		return data;
	}

	public void display() {
		for (int i = top; i >= 0; i--) {
			System.out.print(stackarray[i] + "\t");
		}
	}
}
