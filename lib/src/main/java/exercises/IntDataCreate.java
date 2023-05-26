package exercises;

public class IntDataCreate {
	
	/**
	 * Creates an Int data type
	 * @param none
	 * @return an integer, in this case 5
	 */
	public int createInt() {
		int num = 5;
		return num;
	}
	
	/**
	 * prints int created in createInt()
	 * @param int 
	 * @return 
	 */
	public void printInt(int num) {
		System.out.println(num);
	}
	
	/**
	 * Creates, stores, and prints an Int data type
	 * @param none
	 * @return an integer
	 */
	public static void main(String args[]) {
		IntDataCreate idc = new IntDataCreate();
		idc.printInt(5);
	}
}
