package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	final static int progressR[] = {0, 0, -1, 1};
	final static int progressC[] = {-1, 1, 0, 0};
	
	static class Cell {
		int x;
		int y;
		
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}		
	}
	
	static boolean isValid(int r, int c, int R, int C) {
		return (r >= 0 && c>= 0 && r < R && c< C);   
	}
	
	static boolean isDelim(Cell cell) {
		return (cell.x == -1 && cell.y == -1);
	}
	
	static boolean checkAll(int arr[][]) {
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[i].length; ++j) {
				if (arr[i][j] == 1) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static int checkRottenOranges(int arr[][]) {
		if (arr == null) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		int R = arr.length;
		int C = arr[0].length;
		Queue<Cell> queue = new LinkedList<>();
		for (int r = 0; r < arr.length; ++r) {
			for (int c = 0; c < arr[r].length; ++c) {
				if (arr[r][c] == 2) {
					queue.add(new Cell(r, c));
				}
			}
		}

		queue.add(new Cell(-1, -1));
		
		int time = 0;
		while (!queue.isEmpty()) {
			boolean flag = false;
			while(!isDelim(queue.peek())) {
				Cell current = queue.peek();
				for (int i = 0; i < progressC.length; ++i) {
					int r = current.x + progressR[i] ;
					int c = current.y + progressC[i];
					if (isValid(r, c, R, C) && arr[r][c] == 1) {
						if (!flag) {
							flag = true;
							time++;
						}
						arr[r][c] = 2;
						queue.add(new Cell(r, c));
					}
				}
				
				queue.remove();
			}
			// delim
			queue.remove();
			if (!queue.isEmpty()) {
				queue.add(new Cell(-1, -1));
			}
		}
		
		return (checkAll(arr) ? -1 : time);
	}
	
	public static void main(String[] args) {
		int arr[][] = { {2, 1, 0, 2, 1}, 
                {1, 0, 1, 2, 1}, 
                {1, 0, 0, 2, 1}}; 
		int time = checkRottenOranges(arr);
		System.out.println(time);
	}

}
