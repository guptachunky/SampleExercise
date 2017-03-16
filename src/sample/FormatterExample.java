package sample;

import java.util.Date;

public class FormatterExample {
	public static void main(String args[]) {

		String formattedString = String.format("Order with OrdId : %d and Amount: %d is missing", 40021, 3000);

		System.out.println(formattedString);

		System.out.printf("Order with OrdId : %d  and Amount: %d is missing \n", 40021, 3000);

		String str = String.format("Hello %s", "Raj");
		System.out.println(str);

		// Formatting date in String format method - date in MM/dd/yy
		str = String.format("Today is %tD", new Date());
		System.out.println(str);

		Date today = new Date();
		System.out.printf("Date in dd/mm/yy format %td/%tm/%ty %n", today, today, today);

		System.out.printf("Today is %tB %te, %tY %n", today, today, today, today);

		System.out.printf("Amount : %08d %n", 221);

		System.out.printf("positive number : +%d %n", 1534632142);
		System.out.printf("negative number : -%d %n", 989899);

		// printing floating point number with System.format()
		System.out.printf("%f %n", Math.E);

		// 3 digit after decimal point
		System.out.printf("%.3f %n", Math.E);

		// 8 charcter in width and 3 digit after decimal point
		System.out.printf("%8.3f %n", Math.E);

		// adding comma into long numbers
		System.out.printf("Total %,d messages processed today", 10000000);
	}

}
