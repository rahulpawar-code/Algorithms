public class MinQueue <Key extends Comparable<Key>> {
    private int N;
    private Key[] pq;

    public MinQueue(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key deleteMin() {
        Key temp = pq[1];
        swap(1, N);
        N--;
        sink(1);
        pq[N + 1] = null;
        return temp;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1)) {
                j = j + 1;
            }
            if (!greater(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args) {
        String[] names = {"Charlie", "Tom", "Alice", "Hope", "Eve", "Hank", "Bob"};
        MinQueue<String> queue =  new MinQueue<>(10);
        for (String s : names) {
            queue.insert(s);
        }

        while(!queue.isEmpty()) {
            System.out.println(queue.deleteMin());
        }
    }
}

