public class Selection {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length; ++i) {
            int min = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (less(array[j], array[min])) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    public static void print(String[] array) {
        for (String a : array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        String[] array = {"Bob", "Eve", "Alice", "Charlie", "Hope"};
        print(array);
        Selection.sort(array);
        print(array);
    }
}
