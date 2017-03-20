import java.util.Scanner;


public class DivisibleByTwo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the number is :");
			String given_string = sc.next();
			DivisibleByTwo.caculate(given_string);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}

	public static void caculate(String given_string) {
		boolean flag = true;
		int sum = 0;
		for (int i = 0; i < given_string.length(); i++) {
			int number = Character.getNumericValue(given_string.charAt(i));
			if (number == 0 || number == 1 || number == 2 || number == 3
					|| number == 4 || number == 5 || number == 6 || number == 7
					|| number == 8 || number == 9) {
				sum = sum + number;
			} else {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			if (sum % 2 == 0) {
				System.out.println(given_string + " is divisible by 2");
			} else {
				System.out.println(given_string + " is NOT Divisible by 2");
			}
		} else {
			System.out.println("Illegel Input... Only digit is allowed");
		}
	}
}
