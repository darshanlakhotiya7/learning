
/*
 * Given two numbers as strings. The numbers may be very large, the task is to find sum of these two numbers.

 Examples:

 Input  : str1 = "3333311111111111", 
 str2 =   "44422222221111"
 Output : 3377733333332222

 Input  : str1 = "7777555511111111", 
 str2 =    "3332222221111"
 Output : 7780887733332222

 */

import java.util.Scanner;

public class SumOfTwoString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter The First String is :");
			String first_string = sc.next();
			System.out.println("Enter The Second String is :");
			String second_string = sc.next();
			SumOfTwoString.add(first_string, second_string);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}

	private static void add(String first_string, String second_string) {
		int flen = 0, slen = 0, first = 0, second = 0, carry = 0, sum = 0, rem = 0;
		long add = 0;
		boolean flag = true;
		flen = first_string.length() - 1;
		slen = second_string.length() - 1;
		if (flen >= slen) {
			while (flen >= 0) {
				first = Character.getNumericValue(first_string.charAt(flen));
				if (slen != -1) {
					second = Character.getNumericValue(second_string
							.charAt(slen));
				} else {
					second = 0;
					slen = 0;
				}
				if (check(first, second)) {
					sum = first + second + carry;
					rem = sum % 10;
					add = add * 10 + rem;
					carry = sum / 10;
					flen--;
					slen--;
				} else {
					flag = false;
					break;
				}
			}
		} else {
			while (slen >= 0) {
				if (flen != -1) {
					first = Character
							.getNumericValue(first_string.charAt(flen));
				} else {
					first = 0;
					flen = 0;
				}
				second = Character.getNumericValue(second_string.charAt(slen));
				if (check(first, second)) {
					sum = first + second + carry;
					rem = sum % 10;
					add = add * 10 + rem;
					carry = sum / 10;
					flen--;
					slen--;
				} else {
					flag = false;
					break;
				}
			}
		}
		if (flag == false) {
			System.out.println("NOT Possible...Invalid Input");
		} else {
			long reverse = 0;
			int rem1 = 0;
			while (add > 0) {
				rem1 = (int) (add % 10);
				reverse = reverse * 10 + rem1;
				add = add / 10;
			}
			System.out.println("Addition of Two String is :" + reverse);
		}
	}

	private static boolean check(int para1, int para2) {
		if ((para1 == 0 || para1 == 1 || para1 == 2 || para1 == 3 || para1 == 4
				|| para1 == 5 || para1 == 6 || para1 == 7 || para1 == 8 || para1 == 9)
				&& (para2 == 0 || para2 == 1 || para2 == 2 || para2 == 3
						|| para2 == 4 || para2 == 5 || para2 == 6 || para2 == 7
						|| para2 == 8 || para2 == 9)) {
			return true;

		} else {
			return false;
		}
	}
}
