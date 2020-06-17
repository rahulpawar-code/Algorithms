import java.util.Random;

public class Shuffling {
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void shuffle(Comparable[] a) {
        Random rand = new Random();
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            int j = rand.nextInt(i + 1);
            swap(a, i, j);
        }
    }

    public static void print(Object[] array) {
        for (Object a : array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        String[] array = {"Alice", "Bob", "Charlie", "Eve", "Hope"};
        Shuffling.print(array);
        Shuffling.shuffle(array);
        Shuffling.print(array);
    }
}
