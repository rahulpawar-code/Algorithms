public class MergeBU {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        for (int k = 0; k <= high; ++k) {
            aux[k] = a[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; ++k) {
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

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        int N = a.length;
        for (int size = 1; size < N; size = size + size) {
            for (int low = 0; low < N - size; low = low + size + size) {
                merge(a, aux, low, low - size + 1, Math.min(low + size + size - 1, N - 1));
            }
        }
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

