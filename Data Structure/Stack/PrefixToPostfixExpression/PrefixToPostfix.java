import java.util.Scanner;
import java.util.Stack;

public class PrefixToPostfix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the Prefix Expression :");
			String prefix_exp = sc.next();
			System.out.println("Postfix Expression is : "
					+ PrefixToPostfix.convertPostfix(prefix_exp));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}

	private static String convertPostfix(String prefix_exp) {
		Stack<String> postfix = new Stack<String>();
		char temp;
		String sym;
		int i;
		for (i = prefix_exp.length() - 1; i >= 0; i--) {
			temp = prefix_exp.charAt(i);
			sym = Character.toString(temp);
			if (isAlpha(temp)) {
				postfix.push(sym);
			} else if (isOperator(temp)) {
				String opt1 = postfix.pop();
				String opt2 = postfix.pop();
				sym = opt1 + opt2 + sym;
				postfix.push(sym);
			}
		}
		return postfix.pop();
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
		if ((temp >= 'A' && temp <= 'Z') || (temp >= 'a' && temp <= 'z')) {
			return true;
		} else {
			return false;
		}
	}
}
