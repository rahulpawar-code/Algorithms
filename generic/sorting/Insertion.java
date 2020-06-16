public class Insertion {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; ++i) {
            for (int j = i; j > 0; --j) {
                if (less(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void print(Object[] array) {
        for (Object o : array) {
            System.out.print(o + " ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        String[] array = {"Bob", "Eve", "Alice", "Charlie", "Hope"};
        print(array);
        Insertion.sort(array);
        print(array);
    }
}
