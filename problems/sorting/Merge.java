public class Merge {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        for (int k = low; k <= high; ++k) {
            aux[k] = a[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (less(a[j], a[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, high);
        merge(a, aux, low, mid, high);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void print(Object[] array) {
        for (Object a: array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        String[] array = {"Hope", "Eve", "Alice", "Charlie", "Tom", "Bob"};
        Merge.print(array);
        Merge.sort(array);
        Merge.print(array);
    }
}
