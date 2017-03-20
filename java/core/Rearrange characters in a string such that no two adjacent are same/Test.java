import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the String :");
			String input = sc.next(); // Take string from user
			RearrangeString rs = new RearrangeString(input); // pass string to
																// The
																// Constructor
			rs.rearrange(); // call method
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}

}
