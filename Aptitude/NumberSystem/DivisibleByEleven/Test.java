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

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the number is :");
			String input = sc.next();
			DivisibleByEleven diveleven = new DivisibleByEleven(input);
			diveleven.check();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}
}
