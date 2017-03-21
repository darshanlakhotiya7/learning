package numbersystem_divisibleby4;

import java.util.Scanner;

public class DivisibleByFour {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the number is :");
			String given_string = sc.next();
			DivisibleByFour.caculate(given_string);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}

	public static void caculate(String given_string) {
		int sum = 0, number = 0, i = 0;
		boolean flag = true;
		int length = given_string.length();
		if (length > 2) {
			for (i = length - 2; i < length; i++) {
				number = Character.getNumericValue(given_string.charAt(i));
				if (number == 0 || number == 1 || number == 2 || number == 3
						|| number == 4 || number == 5 || number == 6
						|| number == 7 || number == 8 || number == 9) {
					sum = sum * 10 + number;
				} else {
					flag = false;
					break;
				}
			}
		} else {
			number = Character.getNumericValue(given_string.charAt(i));
			if (number == 0 || number == 1 || number == 2 || number == 3
					|| number == 4 || number == 5 || number == 6 || number == 7
					|| number == 8 || number == 9) {
				sum = Integer.parseInt(given_string);
			} else {
				flag = false;
			}
		}
		if (flag == true) {
			if (sum % 4 == 0) {
				System.out.println(given_string + " is Divisible by 4");
			} else {
				System.out.println(given_string + " is NOT Divisible by 4");
			}
		} else {
			System.out.println("Illegel Input... Only digit is allowed");
		}
	}
}
