import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the Infix Expression :");
			String infix_exp = sc.next();
			InfixToPostfix itp = new InfixToPostfix(infix_exp);
			if (itp.isBalanced()) {
				System.out.println("Postfix Expression is :"
						+ itp.convertPostfix());
			} else {
				System.out
						.println("Given Expression is not Balanced Expression");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}
}
