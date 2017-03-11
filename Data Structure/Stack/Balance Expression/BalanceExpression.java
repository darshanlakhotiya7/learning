import java.util.Stack;

public class BalanceExpression {

	int size;
	char stackarray[];

	public BalanceExpression(int size) {
		this.size = size;
		stackarray = new char[size];
	}

	public void check(String input) {
		boolean flag = true;
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < size; i++) {
			char ch = input.charAt(i);
			if (ch == '{' || ch == '(' || ch == '[') {
				st.push(ch);
			}
			if (ch == '}' || ch == ')' || ch == ']') {
				if (st.isEmpty()) {
					flag = false;
					break;
				} else {
					char temp = st.pop();
					if (temp == '[') {
						if (ch != ']') {
							flag = false;
							break;
						}
					}
					if (temp == '{') {
						if (ch != '}') {
							flag = false;
							break;
						}
					}
					if (temp == '(') {
						if (ch != ')') {
							flag = false;
							break;
						}
					}
				}
			}
		}
		if (flag == true && st.isEmpty()) {
			System.out.println("Given Expression is Balanced");
		} else {
			System.out.println("Given Expression is not Balanced");
		}
	}
}
