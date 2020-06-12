import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.NoSuchElementException;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Deque<String> deque = new Deque<>();

        while (!StdIn.isEmpty()) {
            String word = "";
            try {
                word = StdIn.readString();
                deque.addFirst(word);
            } catch (NoSuchElementException e) {
                break;
            }
        }

        for (int i = 0; i < k; ++i) {
            if (StdRandom.bernoulli()) {
                StdOut.println(deque.removeFirst());
            } else {
                StdOut.println(deque.removeLast());
            }
        }
    }
}
