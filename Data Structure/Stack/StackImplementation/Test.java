import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int ch = 0;
			// get the size of stack
			System.out.println("Enter size of stack :");
			int size = sc.nextInt();
			StackImplement stk = new StackImplement(size);
			do {
				int data = 0;
				System.out.println("*************Stack Operation*************");
				System.out.println("1 for PUSH");
				System.out.println("2 for POP");
				System.out.println("3 for PEEK");
				System.out.println("4 for DISPLAY");
				System.out.println("5 for Exit");
				ch = sc.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Enter the data element :");
					data = sc.nextInt();
					// It is check the top==size-1 or not
					if (stk.isFull()) {
						// return true
						System.out.println("Stack is Full...");
					} else {
						// return false
						stk.push(data);
					}
					break;
				case 2:
					// It is check the top==-1 or not
					if (stk.isEmpty()) {
						System.out.println("Stack is Empty...");
					} else {
						data = stk.pop();
						System.out.println("Removing Element is :" + data);
					}
					break;
				case 3:
					if (stk.isEmpty()) {
						System.out.println("Stack is Empty...");
					} else {
						data = stk.peek();
						System.out.println("Top Value without Removing is :"
								+ data);
					}
					break;
				case 4:
					if (stk.isEmpty()) {
						System.out.println("Stack is Empty...");
					} else {
						System.out.print("[");
						stk.display();
						System.out.print("]");
						System.out.println();
					}
					break;
				case 5:
					System.out.println("Thanks for Using Stack Operation");
					System.exit(0);
				default:
					System.out.println("Sorry, Please choose Proper input...");
					break;
				}
			} while (ch != 5);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}
}
