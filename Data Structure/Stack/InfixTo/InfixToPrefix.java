import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the Infix Expression :");
			String infix_exp = sc.next();
			if (isBalanced(infix_exp)) {
				System.out.println("Prefix is :"
						+ InfixToPrefix.convertPre(infix_exp));
			} else {
				System.out.println("This expression is not Balanaced");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}

	private static String convertPre(String infix_exp) {
		int i = 0;
		char sym;
		StringBuffer prefix = new StringBuffer();
		Stack<Character> st = new Stack<Character>();
		st.push('#');
		for (i = infix_exp.length() - 1; i >= 0; i--) {
			sym = infix_exp.charAt(i);
			switch (sym) {
			case ')':
				st.push(sym);
				break;
			case '(':
				while (!st.isEmpty() && st.peek() != ')') {
					prefix.append(st.pop());
				}
				break;
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
			case '^':
				while (getPriority(sym) <= getPriority(st.peek())) {
					prefix.append(st.pop());
				}
				st.push(sym);
				break;
			default:
				prefix.append(sym);
				break;
			}
		}
		while (!st.isEmpty() && st.peek() != '#') {
			char temp = st.pop();
			if (temp != ')')
				prefix.append(temp);
		}
		prefix = prefix.reverse();
		return prefix.toString();
	}

	private static int getPriority(char sym) {
		if (sym == '^' || sym == '%')
			return 1;
		else if (sym == '*' || sym == '/')
			return 2;
		else if (sym == '+' || sym == '-')
			return 3;
		else
			return -1;
	}

	private static boolean isBalanced(String infix_exp) {
		Stack<Character> stk = new Stack<Character>();
		boolean flag = true;
		for (int i = 0; i < infix_exp.length(); i++) {
			char sym = infix_exp.charAt(i);
			if (sym == '(' || sym == '{' || sym == '[') {
				stk.push(sym);
			} else if (sym == ')' || sym == '}' || sym == ']') {
				if (stk.isEmpty()) {
					flag = false;
					break;
				} else {
					char temp = stk.pop();
					if (temp == ')') {
						if (sym != '(') {
							flag = false;
							break;
						}
					}
					if (temp == '}') {
						if (sym != '{') {
							flag = false;
							break;
						}
					}
					if (temp == ']') {
						if (sym != '[') {
							flag = false;
							break;
						}
					}
				}
			}
		}
		if (flag == true && stk.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
