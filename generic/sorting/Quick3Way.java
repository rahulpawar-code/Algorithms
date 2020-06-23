public class Quick3Way {
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void sort(Comparable[] array, int low, int high) {
        if (low > high) {
            return;
        }

        int lt = low;
        int gt = high;
        int i = low;
        Comparable v = array[low];

        while (i <= gt) {
            int cmp = array[i].compareTo(array[gt]);
            if (cmp < 0) {
                swap(array, lt, i);
                lt++;
                i++;
            } else if (cmp > 0) {
                swap(array, i, gt);
                gt--;
            } else {
                i++;
            }
        }

        sort(array, low, lt - 1);
        sort(array, gt + 1, high);
    }

    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void print(Object[] array) {
        for (Object a : array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        String[] names = {"Bob", "Tom", "Alice", "Charlie", "Eve", "Hank"};
        Quick3Way.print(names);
        Quick3Way.sort(names);
        Quick3Way.print(names);
    }
}
