/*
 * Problem Link: https://www.careercup.com/question?id=5763748409638912
 */

package Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MatrixNode {
	int row;
	int column;
	int degree;
	
	public MatrixNode(int r, int c, int d) {
		row = r;
		column = c;
		degree = d;
	}
}

public class RemoveZerosInMatrix {
	private static void printMatrix(char[][] matrix) {
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	private static void printArrayList(ArrayList<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	
	private static void reduceDegreeList(ArrayList<MatrixNode> degreeList, ArrayList<Integer> rows[],
			ArrayList<Integer> columns[], char[][] matrix) {
		MatrixNode node = degreeList.get(0);
		System.out.println("Solver: " + node.row + " " + node.column + " " + node.degree);
		rows[node.row].remove(new Integer(node.column));
		columns[node.column].remove(new Integer(node.row));
		degreeList.remove(0);
		matrix[node.row][node.column] = 'X';
		
		for (int i = 0; i < rows[node.row].size(); ++i) {
			for (MatrixNode tmp : degreeList) {
				if (tmp.row == node.row) {
					tmp.degree--;
					if (tmp.degree == 0) {
						degreeList.remove(tmp);
					}
				}
			}
		}
		
		for (int j = 0; j < columns[node.column].size(); ++j) {
			for (MatrixNode tmp : degreeList) {
				if (tmp.column == node.column) {
					tmp.degree--;
					if (tmp.degree == 0) {
						degreeList.remove(tmp);
					}
				}
			}
		}		
	}
	
	private static void solver(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		
		// Create arrays
		int r = matrix.length;
		int c = matrix[0].length;
		
		ArrayList<Integer> rows[] = new ArrayList[r];
		ArrayList<Integer> columns[] = new ArrayList[c];
		
		for (int i = 0; i < r; ++i) {
			rows[i] = new ArrayList<>();
		}
		
		for (int j = 0; j < c; ++j) {
			columns[j] = new ArrayList<>();
		}
		
		// Create row & column arrays
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				if (matrix[i][j] == 'O') {
					rows[i].add(j);
					columns[j].add(i);
				} else if (matrix[i][j] != 'X'){
					throw new IllegalArgumentException("Unknown argument in input matrix");
				}
			}
		}
		
		
		System.out.println("rows");
		for (int i = 0; i < rows.length; ++i) {
			printArrayList(rows[i]);
		}
		
		System.out.println("columns");
		for (int j = 0; j < columns.length; ++j) {
			printArrayList(columns[j]);
		}
		
		
		// Create degree list
		ArrayList<MatrixNode> degreeList = new ArrayList<>();
		for (int i = 0; i < rows.length; ++i) {
			for (int j = 0; j < rows[i].size(); ++j) {
				int degree = rows[i].size() + columns[rows[i].get(j)].size() - 2;
				if (degree > 0) {
					degreeList.add(new MatrixNode(i, rows[i].get(j), degree));
				}
			}
		}
		
		// Sort degree list
		Collections.sort(degreeList, new Comparator<MatrixNode>() {
			@Override
			public int compare(MatrixNode o1, MatrixNode o2) {
				return o1.degree - o2.degree;
			}
			
		});
		
		// Process degree list and modify the matrix
		
		while (!degreeList.isEmpty()) {
			reduceDegreeList(degreeList, rows, columns, matrix);
		}
		
	}
	
	public static void main(String[] args) {
		char[][] matrix = {{'X', 'X', 'X', 'X', 'X', 'O'},
						   {'O', 'X', 'X', 'X', 'X', 'X'},
						   {'O', 'X', 'X', 'X', 'X', 'O'},
						   {'X', 'X', 'O', 'X', 'O', 'X'},
						   {'X', 'O', 'X', 'X', 'X', 'O'}};
		
		
		System.out.println("matrix");
		printMatrix(matrix);
		solver(matrix);
	}
}