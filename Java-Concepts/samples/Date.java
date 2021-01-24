/**
  * This program demonstrate the concept of generics.
  *
  * @author  Rahul Pawar
  * @version 1.0
  * @since   2020-06-29
  */

// Class for storing Date
public class Date {
    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return new String(day + "/" + month + "/" + year);
    }

    // Overriding base method to check for equality of values in 2 objects
    public boolean equals(Object other) {
        // equality against null
        if (other == null) {
            return false;
        }

        // equality against itself
        if (this == other) {
            return true;
        }

        Date that = (Date)other;

        // 2 Data objects are considered equal if
        // they have same day, month and year
        return (this.day == that.day) &&
                (this.month == that.month) &&
                (this.year == that.year);
    }

    public static void main(String[] args) {
        Date d1 = new Date(14, 12, 2020);
        System.out.println("d1 = " + d1);

        Date d2 = d1;
        System.out.println("d2 = " + d2);

        Date d3 = new Date(14, 12, 2020);
        System.out.println("d3 = " + d3);

        Date d4 = new Date(15, 12, 2020);
        System.out.println("d4 = " + d4);

        System.out.println("d1 equals null ? " + d1.equals(null));
        System.out.println("d1 equals itself ? " + d1.equals(d1));
        System.out.println("d1 equals d2 ? " + d1.equals(d2));
        System.out.println("d1 equals d3 ? " + d1.equals(d3));
        System.out.println("d1 equals d4 ? " + d1.equals(d4));
    }
}
