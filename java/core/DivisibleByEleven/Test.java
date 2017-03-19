import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the number is :");
			int input = sc.nextInt();
			DivisibleByEleven diveleven = new DivisibleByEleven(input);
			diveleven.check();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}
}
