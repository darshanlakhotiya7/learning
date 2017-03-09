public class TripletSum {

	public static void findSumZero(int[] numbers, int size) {
		boolean found = false;

		/*
		 * Radheshyam - Here, you are doing sorting. Can you please use a better
		 * algorithm? Also mention a comment here that you are sorting the
		 * array. DARSHAN : Ok, I am using here Another type sorting technique.
		 * I think that, It is better than last algorithm. because, This sorting
		 * technique order for best case is O(n) & worst case is O(n^2)
		 * 
		 * ex. Without Sorting 1.Enter size of Array is : 5 Enter array elements
		 * : 1 3 -3 2 -3 No Triplet Found........
		 * 
		 * Actually in that case result is -3 1 2 -3 1 2 Since, declaring
		 * next(l),last(r) & current(x) variable. & check(while(next<last)) if
		 * it is true then loop entry is possible. otherwise i value incremented
		 * by 1.
		 */
		for (int k = 1; k <= size - 1; k++) {
			for (int j = 0; j < size - k - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < size - 2; i++) {
			int next = i + 1;
			int last = size - 1;
			int current = numbers[i];
			while (next < last) {
				if (current + numbers[next] + numbers[last] == 0) {
					System.out.println(current + " " + numbers[next] + " "
							+ numbers[last]);
					next++;
					last--;
					found = true;
				} else if (current + numbers[next] + numbers[last] < 0) {
					next++;
				} else {
					last--;
				}
			}
		}
		if (found == false)
			System.out.println(" No Triplet Found........");
	}
}

