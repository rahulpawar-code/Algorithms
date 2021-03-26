public class Quick {
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

    private static void sort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = partition(a, low, high);
        sort(a, low, mid - 1);
        sort(a, mid + 1, high);
    }

    private static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    public static void print(Object[] array) {
        for (Object a : array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        String[] array = {"Eve", "Charlie", "Bob", "Hope", "Alice", "Tom"};
        Quick.print(array);
        Quick.sort(array);
        Quick.print(array);
    }
}
