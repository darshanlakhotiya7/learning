
import java.util.Scanner;
import java.util.Stack;

public class PostfixToPrefix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the Postfix Expression is :");
			String postfix_exp = sc.next();
			System.out.println("Prefix is :"
					+ PostfixToPrefix.convertPrefix(postfix_exp));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}

	private static String convertPrefix(String postfix_exp) {
		Stack<String> prefix = new Stack<String>();
		char temp;
		String sym;
		for (int i = 0; i < postfix_exp.length(); i++) {
			temp = postfix_exp.charAt(i);
			sym = Character.toString(temp);
			if (isAlpha(temp)) {
				prefix.push(sym);
			} else if (isOperator(temp)) {
				String operand1 = prefix.pop();
				String operand2 = prefix.pop();
				sym = sym + operand2 + operand1;
				prefix.push(sym);
			}
		}
		return prefix.pop();
	}

	private static boolean isAlpha(char temp) {
		if ((temp >= 'a' && temp >= 'z') || (temp >= 'A' && temp >= 'Z'))
			return true;
		else
			return false;
	}

	private static boolean isOperator(char temp) {
		if (temp == '+' || temp == '-' || temp == '*' || temp == '/'
				|| temp == '%' || temp == '^')
			return true;
		else
			return false;
	}
}
