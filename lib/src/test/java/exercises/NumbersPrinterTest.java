package exercises;

/****************************************************************************
 * <b>Title:</b> NumbersPrinterTest.java
 * <b>Project:</b> lib
 * <b>Description:</b> test class for NumbersPrinter
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Jun 12, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class NumbersPrinterTest {
	/**
	 * test for PrimDataCreator
	 * @param n/a
	 * @return n/a
	 */
	public static void main(String[] args) {
		NumbersPrinter printer = new NumbersPrinter();
		printer.printToTen();
		printer.printReverse();
		printer.printEvens();
	}
}
