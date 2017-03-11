import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int ch = 0;
			// get the size of queue
			System.out.println("Enter size of queue :");
			int size = sc.nextInt();
			QueueImplement queue = new QueueImplement(size);
			do {
				int data = 0;
				System.out.println("*************QUEUE Operation*************");
				System.out.println("1 for INSERT");
				System.out.println("2 for DELETE");
				System.out.println("3 for DISPLAY");
				System.out.println("4 for Exit");
				ch = sc.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Enter the element :");
					data = sc.nextInt();
					// It is check the top==size-1 or not
					if (queue.isFull()) {
						// return true
						System.out.println("Queue is Full...");
					} else {
						// return false
						queue.insert(data);
					}
					break;
				case 2:
					// It is check the top==-1 or not
					if (queue.isEmpty()) {
						System.out.println("Queue is Empty...");
					} else {
						data = queue.delete();
						System.out.println("Deleting Element is :" + data);
					}
					break;
				case 3:
					if (queue.isEmpty()) {
						System.out.println("Queue is Empty...");
					} else {
						System.out.print("[");
						queue.display();
						System.out.print("]");
						System.out.println();
					}
					break;
				case 4:
					System.out.println("Thanks for Using Queue Operation");
					System.exit(0);
				default:
					System.out.println("Sorry, Please choose Proper input...");
					break;
				}
			} while (ch != 4);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}
}
