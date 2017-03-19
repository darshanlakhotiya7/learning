
public class DivisibleByEleven {
	int number = 0, rem = 0, sumeven = 0, sumodd = 0;
	boolean flag = true;

	public DivisibleByEleven(int number) {
		this.number = number;
	}

	public void check() {
		int org = number;
		while (number > 0) {
			rem = number % 10;
			if (flag == true) {
				sumeven = sumeven + rem;
				flag = false;
			} else {
				sumodd = sumodd + rem;
				flag = true;
			}
			number = number / 10;
		}
		if (sumodd - sumeven % 11 == 0) {
			System.out.println(org + " is Divisible for 11.");
		} else {
			System.out.println(org + " is not Divisible for 11.");
		}
	}
}
