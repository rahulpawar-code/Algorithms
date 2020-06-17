public class Shell {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; ++i) {
                for (int j = i; j >= h; j = j - h) {
                    if (less(a[j], a[j - h])) {
                        swap(a, j , j - h);
                    } else {
                        break;
                    }
                }
            }
            h = h / 3;
        }
    }

    public static void print(Object[] array) {
        for (Object a : array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        String[] array = {"Charlie", "Ivan", "Rupert", "Bob", "Eve", "Heidi"};
        Shell.print(array);
        Shell.sort(array);
        Shell.print(array);
    }
}
