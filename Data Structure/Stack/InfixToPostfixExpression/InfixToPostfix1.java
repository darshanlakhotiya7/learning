
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the Infix Expression :");
			String infix_exp = sc.next();
			if (isBalanced(infix_exp)) {
				System.out.println("Postfix Expression is :"
						+ InfixToPostfix1.convertPostfix(infix_exp));
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

	private static String convertPostfix(String infix_exp) {
		int i = 0;
		char sym;
		StringBuffer postfix = new StringBuffer();
		Stack<Character> st = new Stack<Character>();
		for (i = 0; i < infix_exp.length(); i++) {
			sym = infix_exp.charAt(i);
			switch (sym) {
			case '(':
				st.push(sym);
				break;
			case ')':
				while (!st.isEmpty() && st.peek() != '(') {
					postfix.append(st.pop());
				}
				if (!st.isEmpty() && st.peek() != '(')
					return null;
				else if (!st.isEmpty()) {
					st.pop();
				}
				break;
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
			case '^':
				while (getPriority(sym) <= getPriority(st.peek())) {
					postfix.append(st.pop());
				}
				st.push(sym);
				break;
			default:
				postfix.append(sym);
				break;
			}
		}
		while (!st.isEmpty()) {
			postfix.append(st.pop());
		}
		return postfix.toString();
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
		boolean flag = true;
		Stack<Character> stk = new Stack<Character>();
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
					if (temp == '(') {
						if (sym != ')') {
							flag = false;
							break;
						}
					}
					if (temp == '[') {
						if (sym != ']') {
							flag = false;
							break;
						}
					}
					if (temp == '{') {
						if (sym != '}') {
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
