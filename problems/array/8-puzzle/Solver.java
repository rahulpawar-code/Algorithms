import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import  java.util.LinkedList;
import java.util.Comparator;

public class Solver {
    private class Node implements Comparator<Node> {
        private int manhattan;
        private int hamming;
        Board board;
        private int moves;
        private int priority;


        public Node(Board b, int moves) {
            board = b;
            manhattan = board.manhattan();
            hamming = board.hamming();
            this.moves = moves;
            priority = moves + manhattan;
        }

        public int compare(Node a, Node b) {
            if (a.priority < b.priority) {
                return -1;
            } else if (a.priority == b.priority) {
                return 0;
            } else {
                return 1;
            }
        }

        public boolean isGoalNode() {
            return board.isGoal();
        }

        public int getMoves() {
            return moves;
        }
    }

    private boolean solvable;
    private int moves;

    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        MinPQ<Node> queue = new MinPQ<>(10);
        Node node = new Node(initial, 0);
        queue.insert(node);

        solvable = false;
        moves = 0;

        while (!queue.isEmpty()) {
            Node current = queue.min();
            if (current.isGoalNode()) {
                solvable = true;
                moves = current.getMoves();
                break;
            }
            for (Board next : current.board.neighbours()) {
                // TODO if unseen
            }
        }
        moves = -1;
    }

    public boolean isSolvable() {
        return solvable;
    }

    public int moves() {
        return moves;
    }

    public Iterable<Board> solution() {
        LinkedList<Board> list = new LinkedList<>();
        return list;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
