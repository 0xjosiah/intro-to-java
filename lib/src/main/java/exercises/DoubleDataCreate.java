package exercises;

public class DoubleDataCreate {
	
	/**
	 * Creates an double data type
	 * @param none
	 * @return a double
	 */
	public double createDouble() {
		double num = 5.505050505050505;
		return num;
	}
	
	/**
	 * prints double created in createDouble()
	 * @param double 
	 * @return 
	 */
	public void printDouble(double num) {
		System.out.println(num);
	}
	
	/**
	 * Creates, stores, and prints an double data type
	 * @param none
	 * @return an integer
	 */
	public static void main(String args[]) {
		DoubleDataCreate doub = new DoubleDataCreate();
		doub.printDouble(5.505050505050505);
	}
}