/**
 * This program demonstrate the string representation of objects.
 *
 * @author  Rahul Pawar
 * @version 1.0
 * @since   2020-06-29
 */

public class Employee {
    private final String name;
    private final int ID;
    private final String department;

    public Employee(String name, int ID, String department) {
        this.name = name;
        this.ID = ID;
        this.department = department;
    }

    public String toString() {
        return new String(name + ", " + ID + ", " + department);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", 1, "Management");
        Employee e2 = new Employee("Bob", 1, "Sales");

        System.out.println(e1);
        System.out.println(e2);
    }
}
