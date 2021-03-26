public class QuickSelect {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;

        while (true) {
            while (less(a[i++], a[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(a[low], a[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (j <= i) {
                break;
            }
            exchange(a, i, j);
        }

        exchange(a, low, j);
        return j;
    }

    private static Comparable select(Comparable[] a, int k) {
        int low = 0;
        int high = a.length - 1;
        while (high > low) {
            int j = partition(a, low, high);
            if (j < k) {
                low = j + 1;
            } else if (k < j) {
                high = j - 1;
            } else {
                break;
            }
        }
        return a[k];
    }

    public static void print(Object[] array) {
        for (Object a : array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        String[] array = {"Eve", "Charlie", "Bob", "Hope", "Alice", "Tom"};
        QuickSelect.print(array);
        String median = (String)QuickSelect.select(array, 1);
        System.out.println(median);
    }
}
