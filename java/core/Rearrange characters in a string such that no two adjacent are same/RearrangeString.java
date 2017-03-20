
public class RearrangeString {
	String str;
	int size;

	public RearrangeString(String str) {
		this.str = str;
		size = str.length(); // get length of String & store into size
	}

	public void rearrange() {
		int next = 1, prior = -1, cnt = 0;
		str = str.toLowerCase(); // convert given String to LowerCase
		char[] charray = str.toCharArray(); // convert String to array & stored
											// charray
		char current = charray[0]; // take first element of array & stored in
									// prev

		while (next < size) {
			if (charray[next] != current) {
				if (prior != -1) {
					char temp = charray[prior];
					charray[prior] = charray[next];
					charray[next] = temp;
					cnt--;
					prior = prior + 2;
					if (cnt == 0) {
						prior = -1;
					}
				}
				current = charray[next];
			} else {
				if (prior == -1) {
					prior = next;
				}
				cnt++;
			}
			next++;
		}
		if (cnt != 0) {
			System.out.println("NOT POSSIBLE");
		} else {
			System.out.println(charray);
		}
	}
}
