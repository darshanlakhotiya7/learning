import java.util.Stack;
public class InfixToPostfix {

	String infix_exp;
	int size;
	char stackarr[];

	public InfixToPostfix(String infix_exp) {
		this.infix_exp = infix_exp;
		size = infix_exp.length();
		stackarr = new char[size];
	}

	public boolean isBalanced() {
		boolean flag = true;
		Stack<Character> stk = new Stack<Character>();
		char sym;
		for (int i = 0; i < size; i++) {
			sym = infix_exp.charAt(i);
			if (sym == '(') {
				stk.push(sym);
			}
			if (sym == ')') {
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
				}
			}
		}
		if (flag == true && stk.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public String convertPostfix() {
		char postfix[] = new char[size];
		char sym, temp;
		Stack<Character> st = new Stack<Character>();
		st.push('#');
		int i = 0, pos = 0;
		for (i = 0; i < size; i++) {
			sym = infix_exp.charAt(i);
			switch (sym) {
			case '(':
				st.push(sym);
				break;
			case ')':
				temp = st.pop();
				while (temp != '(') {
					postfix[pos++] = temp;
					temp = st.pop();
				}
				break;
			case '^':
			case '%':
			case '/':
			case '*':
			case '+':
			case '-':
				while (priority(st.peek()) <= priority(sym)) {
					temp = st.pop();
					postfix[pos++] = temp;
				}
				st.push(sym);
				break;

			default:
				postfix[pos++] = sym;
				break;
			}
		}
		temp = st.pop();
		while (temp != '#') {
			postfix[pos++] = temp;
			temp = st.pop();
		}
		return new String(postfix);
	}

	private int priority(Character peek) {
		if (peek == '^' || peek == '%') {
			return 3;
		} else if (peek == '*' || peek == '/') {
			return 2;
		} else if (peek == '+' || peek == '-') {
			return 1;
		} else {
			return 0;
		}
	}

}
