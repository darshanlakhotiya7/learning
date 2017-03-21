import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfTwoStringUsingRegularExpression {
	public static void main(String[] args) {
		long first = 0, second = 0, addition = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the First String is :");
			String first_string = sc.next();
			System.out.println("Enter the Second String is :");
			String second_string = sc.next();
			Pattern p = Pattern.compile("[0-9]+");
			Matcher m = p.matcher(first_string);
			while (m.find()) {
				first = first + Integer.parseInt(m.group());
			}
			Matcher m1 = p.matcher(second_string);
			while (m1.find()) {
				second = second + Integer.parseInt(m1.group());
			}
			addition = first + second;
			System.out.println("All digit addition is :" + addition);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}
}
