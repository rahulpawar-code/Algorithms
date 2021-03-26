/*
 * Problem Statement:
 * Minimum number of throws required to win Snake and Ladder game.
 * 
 * Link:
 * http://www.techiedelight.com/min-throws-required-to-win-snake-and-ladder-game/
 * 
 * Assumptions for this program:
 * 1. Cell #0 is the starting point which is out of the board. 
 * 2. A die roll of 6 will start the game and will place the coin at cell #1.   
 * 3. There can't be a snake originating at cell #1. This is rather an implicit assumption. 
 */

package Miscellaneous;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class QNode {
	int cell;
	int throwCount;	
	
	public QNode(int c, int t) {
		cell = c;
		throwCount = t;
	}
}

public class SnakeAndLadder {
	private static int calculateMinimumThrows(int start, int size, Map<Integer, Integer> snake, Map<Integer, Integer> ladder,
											  int parent[]) {
		int throwCountArray[] = new int[size + 1];
		Arrays.fill(throwCountArray, Integer.MAX_VALUE);
		
		Arrays.fill(parent, -1);
		parent[1] = 0; // There is only 1 way to reach cell #1 which is from cell #0
		
		ArrayDeque<QNode> queue = new ArrayDeque<>();		
		queue.add(new QNode(start, 0)); // Cell #0 is the home and starting point. The number of throws is 0.
		
		while (!queue.isEmpty()) {
			QNode current = queue.poll();
			
			if (current.cell > size) {
				continue;
			}
			
			// Calculate the destination cell from this cell for each roll of die 
			for (int i = 1; i <= 6; ++i) {
				QNode destination = new QNode(current.cell + i, current.throwCount + 1);
				
				// For starting cell and to handle 2nd assumption
				if (current.cell == start) {
					destination.cell = 1;
				}
				
				// Check if a snake or ladder originate at at this cell
				if (snake.containsKey(destination.cell)) {
					destination.cell = snake.get(destination.cell);
				} else if(ladder.containsKey(destination.cell)) {
					destination.cell = ladder.get(destination.cell);
				}
				
				// Check if destination cell is out of board. This logic also prevent infinite loop and
				// traversing same cell again and again
				// Update the throwCountArray with minimum value and add new destination node in queue.
				if (destination.cell <= size && destination.throwCount < throwCountArray[destination.cell]) {
					throwCountArray[destination.cell] = destination.throwCount;
					queue.add(destination);
					parent[destination.cell] = current.cell;
				}	
			}			
		}
		
		return throwCountArray[size];
	}
	

	public static void main(String[] args) {
		// Representing snake and ladder using a map. The <key,value> pair will represent <source cell, destination cell>
		// of snake and ladder.
        Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();
        Map<Integer, Integer> snake = new HashMap<Integer, Integer>();

        // Insert ladders into the map
        ladder.put(4, 14);
        ladder.put(9, 31);
        ladder.put(21, 42);
        ladder.put(28, 84);
        ladder.put(51, 67);
        ladder.put(72, 91);
        ladder.put(80, 99);
        
        // Insert snakes into the map
        snake.put(17, 7);
        snake.put(54, 34);
        snake.put(62, 19);
        snake.put(64, 60);
        snake.put(87, 36);
        snake.put(93, 73);
        snake.put(95, 75);
        snake.put(98, 79);
        snake.put(99, 3);
        
        // Number of cells in board
        final int size = 100;
        final int start = 0;
        
        int parent[] = new int[size + 1];
        
        int minimumThrows = calculateMinimumThrows(start, size, snake, ladder, parent);
        System.out.println("Minimum number of throws required: " + minimumThrows);
        
        // Uncomment to print the path
        // System.out.print("Path: 0");
        // printShortestPath(parent, size);        
	}
}
