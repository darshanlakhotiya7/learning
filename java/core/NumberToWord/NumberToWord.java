public class NumberToWord {
	static String temp = "used";
	// static int temp=0;
	int input;

	public NumberToWord(int input) {
		this.input = input;
	}

	public void convertToWord() {
		int rem = 0, cnt = 0, number = 0;
		String word = "";

		/*
		 * Reverse number & count digits
		 */
		while (input > 0) {
			rem = input % 10;
			cnt++;
			number = number * 10 + rem;
			input = input / 10;
		}

		rem = 0;

		/*
		 * Logic of the program
		 */
		while (cnt > 0) {
			rem = number % 10;
			String word1 = "";
			switch (rem) {
			case 1:
				word1 = " One";
				word = word + NumberToWord.abc(cnt, word1);
				break;
			case 2:
				word1 = " Two";
				word = word + NumberToWord.abc(cnt, word1);
				break;
			case 3:
				word1 = " Three";
				word = word + NumberToWord.abc(cnt, word1);
				break;
			case 4:
				word1 = " Four";
				word = word + NumberToWord.abc(cnt, word1);
				break;
			case 5:
				word1 = " Five";
				word = word + NumberToWord.abc(cnt, word1);
				break;
			case 6:
				word1 = " Six";
				word = word + NumberToWord.abc(cnt, word1);
				break;
			case 7:
				word1 = " Seven";
				word = word + NumberToWord.abc(cnt, word1);
				break;
			case 8:
				word1 = " Eight";
				word = word + NumberToWord.abc(cnt, word1);
				break;
			case 9:
				word1 = " Nine";
				word = word + NumberToWord.abc(cnt, word1);
				break;
			case 0:
				word1 = " Zero";
				word = word + NumberToWord.abc(cnt, word1);
				break;
			default:
			}
			cnt--;
			number = number / 10;
		}
		System.out
				.println("-------------------------------------------------------------");
		System.out.println(word);
		System.out
				.println("_____________________________________________________________");
	}

	private static String abc(int cnt, String word1) {
		String value = "";
		if (cnt == 1) {
			if (cnt == 1 && temp == " Ten") {
				if (word1 == " One" && temp == " Ten") {
					value = " Eleven";
				} else if (word1 == " Two" && temp == " Ten") {
					value = " Twelve";
				} else if (word1 == " Three" && temp == " Ten") {
					value = " Thirteen";
				} else if (word1 == " Four" && temp == " Ten") {
					value = " Fourteen";
				} else if (word1 == " Five" && temp == " Ten") {
					value = " Fifteen";
				} else if (word1 == " Six" && temp == " Ten") {
					value = " Sixteen";
				} else if (word1 == " Seven" && temp == " Ten") {
					value = " Seventeen";
				} else if (word1 == " Eight" && temp == " Ten") {
					value = " Eighteen";
				} else if (word1 == " Nine" && temp == " Ten") {
					value = " Nineteen";
				}
			} else if (cnt == 1 && temp == "used") {
				if (word1 == " One" && temp == "used") {
					value = " One";
				} else if (word1 == " Two" && temp == "used") {
					value = " Two";
				} else if (word1 == " Three" && temp == "used") {
					value = " Three";
				} else if (word1 == " Four" && temp == "used") {
					value = " Four";
				} else if (word1 == " Five" && temp == "used") {
					value = " Five";
				} else if (word1 == " Six" && temp == "used") {
					value = " Six";
				} else if (word1 == " Seven" && temp == "used") {
					value = " Seven";
				} else if (word1 == " Eight" && temp == "used") {
					value = " Eight";
				} else if (word1 == " Nine" && temp == "used") {
					value = " Nine";
				}
			} else if (cnt == 1 && word1 == " Zero") {
				value = " Ten";
			}
		}
		if (cnt == 2) {
			if (cnt == 2 && word1 == " One") {
				temp = " Ten";
			} else if (cnt == 2 && word1 == " Two") {
				value = " Twenty";
			} else if (cnt == 2 && word1 == " Three") {
				value = " Thirty";
			} else if (cnt == 2 && word1 == " Four") {
				value = " Fourty";
			} else if (cnt == 2 && word1 == " Five") {
				value = " Fifty";
			} else if (cnt == 2 && word1 == " Six") {
				value = " Sixty";
			} else if (cnt == 2 && word1 == " Seven") {
				value = " Seventy";
			} else if (cnt == 2 && word1 == " Eight") {
				value = " Eighty";
			} else if (cnt == 2 && word1 == " Nine") {
				value = " Ninety";
			}
		}
		if (cnt == 3) {
			if (word1 != " Zero") {
				value = word1 + " Hundred";
			}
		}
		if (cnt == 4) {
			value = word1 + " Thousand";
		}
		return value;
	}
}
