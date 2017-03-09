import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int numbers[], j = 0;
		boolean flag = true, set = false;
		Scanner sc = new Scanner(System.in);
		try {
			/* Radheshyam - Why ask for size of array separately? Let the user provide all the array elements one shot, 
			   while running the program from console itself. 
			 * DARSHAN : Ok,I am getting string from console &  put into the array.
			   since array elements may be change, result will be change.
			*/
			System.out.println("Enter the string is :");
			String given_data = sc.next();
			// this size is used to creation of array as well as iterate the for
			// loop
			int size = given_data.length();
			numbers = new int[size];
			for (int i = 0; i < size; i++) {
				char ch = given_data.charAt(i);
				// This Character class method return value into int
				int no = Character.getNumericValue(ch);
				if (no == 1 || no == 2 || no == 3 || no == 4 || no == 5
						|| no == 6 || no == 7 || no == 8 || no == 9 || no == 0
						|| ch == '-') {
					if (ch == '-' || set == true) {
						if (no == 1 || no == 2 || no == 3 || no == 4 || no == 5
								|| no == 6 || no == 7 || no == 8 || no == 9
								|| no == 0) {
							numbers[j] = -(no);
							j++;
							set = false;
						} else {
							set = true;
						}
					} else {
						numbers[j] = no;
						j++;
					}
				} else {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				TripletSum.findSumZero(numbers, j);	//j is new size of array
			} else {
				System.out.println("Not possible");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
	}
}
