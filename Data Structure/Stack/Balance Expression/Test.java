
/*
 * Find Given Expression is Balanced Or Not
 * 
 * Ex.1 Enter the expression :
 * 	(a+b)-(c-d)
 * Output: Given Expression is Balanced
 *  
 *  Ex.2 Enter the expression :
 * 	(a+b)-[c-d)
 * Output: Given Expression is not Balanced
 */
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the expression :");
			String input = sc.next();
			int size = input.length();
			BalanceExpression stk = new BalanceExpression(size);
			stk.check(input);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}

	}
}
