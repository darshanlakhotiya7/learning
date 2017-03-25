import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the Innfix Expression is :");
			String infix_exp = sc.next();
			if (isBalanced(infix_exp)) {
				System.out.println("Postfix Expression is : "
						+ InfixToPostfix.convertPost(infix_exp));
			} else {
				System.out.println("Given Expression is not infix Type");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}

	private static String convertPost(String infix_exp) {
		char[] postfix = new char[infix_exp.length()];
		int i = 0, pos = 0;
		Stack<Character> stk = new Stack<Character>();
		char sym;
		for (i = 0; i < infix_exp.length(); i++) {
			sym = infix_exp.charAt(i);
			if (isOperand(sym)) {
				postfix[pos] = sym;
				pos++;
			} else if (sym == '(') {
				stk.push(sym);
			} else if (sym == ')') {
				while (!stk.isEmpty() && stk.peek() != '(') {
					postfix[pos] = stk.pop();
					pos++;
				}
				if (stk.isEmpty() && stk.peek() != '(') {
					return null;
				} else if (stk.isEmpty()) {
					stk.pop();
				}
			} else if (isOperator(sym)) {
				if (!stk.isEmpty()
						&& getPriority(sym) <= getPriority(stk.peek())) {
					postfix[pos] = stk.pop();
					pos++;
				}
				stk.push(sym);
			}
		}
		while (!stk.isEmpty()) {
			postfix[pos] = stk.pop();
			pos++;
		}
		return new String(postfix);
	}

	private static int getPriority(char sym) {
		switch (sym) {
		case '^':
		case '%':
			return 1;
		case '/':
		case '*':
			return 2;
		case '+':
		case '-':
			return 3;
		}
		return -1;
	}

	private static boolean isOperator(char sym) {
		return sym == '^' || sym == '%' || sym == '+' || sym == '-'
				|| sym == '*' || sym == '/';
	}

	private static boolean isOperand(char sym) {
		return ((sym >= 'a' && sym <= 'z') || (sym >= 'A' && sym <= 'Z'));
	}

	private static boolean isBalanced(String infix_exp) {
		Stack<Character> st = new Stack<Character>();
		boolean flag = true;
		for (int i = 0; i < infix_exp.length(); i++) {
			char sym = infix_exp.charAt(i);
			if (sym == '(' || sym == '{' || sym == '[') {
				st.push(sym);
			} else if (sym == ')' || sym == '}' || sym == ']') {
				if (st.isEmpty()) {
					flag = false;
					break;
				} else {
					char temp = st.pop();
					if (temp == '(') {
						if (sym != ')') {
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
					if (temp == '[') {
						if (sym != ']') {
							flag = false;
							break;
						}
					}
				}
			}
		}
		if (flag == true && st.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
