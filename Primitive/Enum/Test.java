//Andrew McKeown
public class Test {

	public static void main(String[] args) {
		// printing the leap year constant
		System.out.println(Month.leapYear() + " days in a leap year");
		System.out.println("-----------------------------------------------");

		for (Month date : Month.values())
			System.out.println(
					date + " is month number " + date.getMthNum() + " and has " + date.getNumDays() + " days ");
		// Printing the days separately in groups according to the number of
		// days in the month
		System.out.println("-----------------------------------------------");
		for (Month date : Month.values()) {
			if (date.getNumDays() == 28) {
				System.out.println(date + " has " + date.getNumDays() + "days");
			}
		}
		System.out.println("-----------------------------------------------");
		for (Month date : Month.values()) {
			if (date.getNumDays() == 30) {
				System.out.println(date + " has " + date.getNumDays() + "days");
			}
		}
		System.out.println("-----------------------------------------------");
		for (Month date : Month.values()) {
			if (date.getNumDays() == 31) {
				System.out.println(date + " has " + date.getNumDays() + "days");
			}
		}
		// Getting the sum of the days in the year
		System.out.println("-----------------------------------------------");
		int sum = 0;
		for (Month date : Month.values()) {
			sum += date.getNumDays();
		}
		// testing that the number of days is correct
		System.out.println("sum of enum days = days in a year = " + sum);
		System.out.println("-----------------------------------------------");
		System.out.println("Now testing toString method (not in any particular order):\n");
		// using the toString method to print the name of the enums
		System.out.println(Month.APRIL.toString());
		System.out.println(Month.OCTOBER.toString());
		System.out.println(Month.JANUARY.toString());
		System.out.println(Month.MARCH.toString());
	}
}