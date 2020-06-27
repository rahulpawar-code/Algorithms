public class MaxQueue<Key extends Comparable<Key>> {
    private int N;
    private Key[] queue;

    public MaxQueue(int capacity) {
        queue = (Key[])new Comparable[capacity + 1];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key key) {
        if (N == queue.length - 1) {
            throw new IllegalArgumentException("Memory overflow");
        }

        queue[++N] = key;
        swim(N);
    }

    public Key deleteMax() {
        Key max = queue[1];
        swap(1, N);
        N--;
        sink(1);
        queue[N + 1] = null;
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k , k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j = j + 1;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k , j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return queue[i].compareTo(queue[j]) < 0;
    }

    private void swap(int i, int j){
        Key temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    public static void main(String[] args) {
        String[] names = {"Bob", "Eve", "Tom", "Charlie", "Alice", "Hank"};
        MaxQueue<String> queue = new MaxQueue<>(8);

        for (String s : names) {
            queue.insert(s);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.deleteMax());
        }
    }
}
