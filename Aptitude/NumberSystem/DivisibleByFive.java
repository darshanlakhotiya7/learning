import java.util.Scanner;

public class DivisibleByFive {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the number is :");
			String given_string = sc.next();
			DivisibleByFive.caculate(given_string);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}

	public static void caculate(String given_string) {
		boolean flag = true;
		for (int i = given_string.length() - 1; i < given_string.length(); i++) {
			int number = Character.getNumericValue(given_string.charAt(i));
			if (number == 0 || number == 1 || number == 2 || number == 3
					|| number == 4 || number == 5 || number == 6 || number == 7
					|| number == 8 || number == 9) {
				if (number == 5 || number == 0) {
					System.out.println(given_string + " is divisible by 5");
				} else {
					System.out.println(given_string + " is NOT divisible by 5");
				}

			} else {
				flag = false;
				break;
			}
		}
		if (flag == false) {
			System.out.println("Illegel Input... Only digit is allowed");
		}
	}
}
