public class DivisibleByEleven {
	String value;
	int length, sumeven = 0, sumodd = 0;

	public DivisibleByEleven(String value) {
		this.value = value;
		length = value.length();
	}

	public void check() {
		for (int i = 0; i < length; i++) {
			int number = Character.getNumericValue(value.charAt(i));
			if (i % 2 == 0) {
				sumeven = sumeven + number;
			} else {
				sumodd = sumodd + number;
			}
		}
		if ((sumodd - sumeven) % 11 == 0) {
			System.out.println(value + " is divisible for 11");
		} else {
			System.out.println(value + " not divisible for 11");
		}
	}
}
