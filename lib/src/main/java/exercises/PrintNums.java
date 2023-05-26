package exercises;

public class PrintNums {
	/**
	 * method prints all ints 1-10
	 * @param n/a
	 * @return n/a
	 */
	public void printToTen() {
		// init int var of one
		int i = 1;
		// while i is less than 11
		while(i < 11) {
			// print i
			System.out.println(i);
			// increment i
			i++;
		}
	}
	
	/**
	 * prints ints 1-10 in reverse order
	 * @param n/a
	 * @return n/a
	 */
	public void printReverse() {
		// loop thru nums from 10 to 1
		for (int i = 10; i > 0; i--) {
			// print i
			System.out.println(i);
		}
	}
	
	/**
	 * prints evens to 20
	 * @param n/a
	 * @return
	 */
	public void printEvens() {
		// loop thru ints 1-20
		for (int i = 1; i < 21; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
	
	// create main fn to call printNums fn
	public static void main(String[] args) {
		PrintNums printed = new PrintNums();
		printed.printToTen();
		printed.printReverse();
		printed.printEvens();
	}
}
