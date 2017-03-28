import java.util.Scanner;
import java.util.Stack;

public class PostfixToInfix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter The Postfix Expression is :");
			String postfix_exp = sc.next();
			System.out.println("Infix Expression :"
					+ PostfixToInfix.convertoInfix(postfix_exp));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}

	private static String convertoInfix(String postfix_exp) {
		String sym;
		char temp;
		int i;
		Stack<String> infix = new Stack<String>();
		for (i = 0; i < postfix_exp.length(); i++) {
			temp = postfix_exp.charAt(i);
			sym = Character.toString(temp);
			if (isAlpha(temp)) {
				infix.push(sym);
			} else if (isOperator(temp)) {
				String opt1 = infix.pop();
				String opt2 = infix.pop();
				sym = "(" + opt2 + sym + opt1 + ")";
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
