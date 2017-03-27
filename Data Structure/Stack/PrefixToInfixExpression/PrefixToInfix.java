import java.util.Scanner;
import java.util.Stack;

public class PrefixToInfix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the Prefix Expression :");
			String prefix_exp = sc.next();
			System.out.println("Infix is :"
					+ PrefixToInfix.convertIn(prefix_exp));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}

	private static String convertIn(String prefix_exp) {
		int i = 0;
		char temp;
		String sym;
		Stack<String> infix = new Stack<String>();
		for (i = prefix_exp.length() - 1; i >= 0; i--) {
			temp = prefix_exp.charAt(i);
			sym = Character.toString(temp);
			if (isAlpha(temp)) {
				infix.push(sym);
			} else if (isOperator(temp)) {
				String operand1 = infix.pop();
				String operand2 = infix.pop();
				sym = "(" + operand1 + sym + operand2 + ")";
				infix.push(sym);
			}
		}
		return infix.pop();
	}

	private static boolean isOperator(char temp) {
		if (temp == '+' || temp == '-' || temp == '*' || temp == '/'
				|| temp == '%' || temp == '^') {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isAlpha(char temp) {
		if ((temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z')) {
			return true;
		} else {
			return false;
		}
	}
}
