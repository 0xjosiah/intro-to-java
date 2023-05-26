package exercises;

public class OneThruTen {
	/**
	 * method prints all ints 1-10
	 * @param n/a
	 * @return n/a
	 */
	public void printNums() {
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
	
	// create main fn to call printNums fn
	public static void main(String[] args) {
		OneThruTen printed = new OneThruTen();
		printed.printNums();
		printed.printReverse();
	}
}
