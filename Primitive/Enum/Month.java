//Andrew McKeown
public enum Month {
	JANUARY(1, 31), FEBRUARY(2, 28), MARCH(3, 31), APRIL(4, 30), MAY(5, 31), JUNE(6, 30), JULY(7, 31), AUGUST(8,
			31), SEPTEMBER(9, 30), OCTOBER(10, 31), NOVEMBER(11, 30), DECEMBER(12, 31);

	private final int mthNum;
	private final int numDays;
	private final static int leapYr = 366;

	// constructor
	Month(int monthNum, int numberDays) {
		mthNum = monthNum;
		numDays = numberDays;
	}

	public int getMthNum() {
		return mthNum;
	}

	public int getNumDays() {
		return numDays;
	}

	public static int year() {
		return 365;
	}

	public static int leapYear() {
		return leapYr; // returns 366
	}

	/*
	 * returns the enum names,this method overides the name values of the enums,
	 * giving lowercase instead of uppercase
	 */
	public String toString() {
		return name().toLowerCase();
	}

}
