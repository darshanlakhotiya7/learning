
/*
 * 
 Check if a large number is divisible by 11 or not

 Given a number, the task is that we divide number by 11. 
 The input number may be large and it may not be possible to store even if we use long long int.

 Examples:

 Input : n = 76945
 Output : Yes

 Input  : n = 1234567589333892
 Output : Yes

 Input  : n = 363588395960667043875487
 Output : No

 */

import java.util.Scanner;

public class DivisibleByEleven {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the number is :");
			String given_string = sc.next();
			DivisibleByEleven.caculate(given_string);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}

	public static void caculate(String given_string) {
		boolean flag = true;
		int sumeven = 0, sumodd = 0;
		for (int i = 0; i < given_string.length(); i++) {
			int number = Character.getNumericValue(given_string.charAt(i));
			if (number == 0 || number == 1 || number == 2 || number == 3
					|| number == 4 || number == 5 || number == 6 || number == 7
					|| number == 8 || number == 9) {
				if (i % 2 == 0) {
					sumeven = sumeven + number;
				} else {
					sumodd = sumodd + number;
				}
			} else {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			if ((sumodd - sumeven) % 11 == 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		} else {
			System.out.println("Illegel Input... Only digit is allowed");
		}
	}
}
