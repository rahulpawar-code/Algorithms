import edu.princeton.cs.algs4.StdOut;
import java.util.LinkedList;

public class Board {
    public static final int[] rowNext = {0, 0, 1, -1};
    public static final int[] colNext = {1, -1, 0, 0};

    public final int[][] board;
    public final int N;

    public Board(int[][] tiles) {
        if (tiles == null || tiles.length < 2 || tiles.length != tiles[0].length) {
            throw new IllegalArgumentException("Illegal argument to constructor");
        }
        N = tiles.length;
        board = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                board[i][j] = tiles[i][j];
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(N + "\n");
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                sb.append(" " + board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int dimension() {
        return N;
    }

    public int hamming() {
        int distance = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                int num = board[i][j];
                if ((num != 0) && ((i != ((num - 1) / N)) || (j != ((num - 1) % N)))) {
                    distance++;
                }
            }
        }
        return distance;
    }

    public int manhattan() {
        int distance = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                int num = board[i][j];
                int diff = Math.abs(i - num / N);
                diff += Math.abs(j - (num - 1) % N);
                distance += (num != 0) ? diff : 0;
            }
        }
        return distance;
    }

    public boolean equals(Object y) {
        if (y == null) {
            return false;
        }

        Board that = (Board)y;
        boolean isEqual = (this.N == that.N);
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                isEqual &= (this.board[i][j] == that.board[i][j]);
            }
        }
        return isEqual;
    }

    public boolean isGoal() {
        int start = 1;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                int num = board[i][j];
                if (num != start) {
                    return false;
                }
                start = ((start + 1) % (N * N));
            }
        }
        return true;
    }

    public Board twin() {
        Board tw = new Board(this.board);
        int temp = tw.board[0][0];
        tw.board[0][0] = tw.board[0][1];
        tw.board[0][1] = temp;
        return tw;
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < N && col < N;
    }

    public Iterable<Board> neighbours() {
        LinkedList<Board> list = new LinkedList<>();
        int row = -1;
        int col = -1;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                }
            }
        }

        for (int i = 0; i < rowNext.length; ++i) {
            int nextRow = rowNext[i] + row;
            int nextCol = colNext[i] + col;
            if (isValid(nextRow, nextCol)) {
                Board neighbour = new Board(this.board);
                neighbour.board[row][col] = neighbour.board[nextRow][nextCol];
                neighbour.board[nextRow][nextCol] = 0;
                list.add(neighbour);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] tiles = {{1, 6, 4},
                        {2, 0, 5},
                        {3, 8, 7}};

        Board board = new Board(tiles);
        StdOut.println(board);
        StdOut.println("Hamming: " + board.hamming());
        StdOut.println("Manhattan: " + board.manhattan());
        StdOut.println("Equals : " + board.equals(board));
        StdOut.println("Is goal: " + board.isGoal());
        StdOut.println("====================");

        int[][] tiles2 = {{1 , 0, 14, 10},
                        {8, 6, 2, 12},
                        {13, 11, 3, 5},
                        {15, 4, 7, 9}};
        Board board2 = new Board(tiles2);
        StdOut.println(board2);
        StdOut.println(board2.hamming());
        StdOut.println(board2.hamming());

        StdOut.println("====================");

        int[][] tiles3 = {{8, 1, 3},
            {4, 0, 2},
            {7, 6, 5}};

        Board board3 = new Board(tiles3);
        StdOut.println(board3);
        StdOut.println(board3.hamming());
        StdOut.println(board3.manhattan());
        StdOut.println(board3.equals(board));
        StdOut.println("Twin : " + board3.twin());

        StdOut.println("====================");
        for (Board b : board3.neighbours()) {
            StdOut.println(b);
        }
    }
}
