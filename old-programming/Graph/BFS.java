package Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/*
 * Problem Statement:
 * Breadth first search in a graph, iterative and recursive manner
 * 
 * Link:
 * http://www.techiedelight.com/breadth-first-search/
 */

public class BFS {
	private static void BFSReccursive(Graph graph, boolean visited[], Queue<Integer> queue) {
		if (queue.isEmpty()) {
			return;
		}
		
		int current = queue.poll();
		System.out.print(" " + current);
		
		for (Edge edge : graph.adjacencyList.get(current)) {
			int neighbour = edge.destination;
			if (!visited[neighbour]) {
				queue.add(neighbour);
				visited[neighbour] = true;
			}
		}
		
		BFSReccursive(graph, visited, queue);
	}
	
	private static void BFSIterative(Graph graph, int source, boolean visited[]) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(source);
		visited[source] = true;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(" " + current);
			
			for (Edge edge : graph.adjacencyList.get(current)) {
				int neighbour = edge.destination;
				if (!visited[neighbour]) {
					queue.add(neighbour);
					visited[neighbour] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
                new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
                new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
                new Edge(7, 11), new Edge(7, 12)                
        );
		
		final int N = 15; 
		Graph graph = new Graph(edges, N);
		
		
		System.out.print("\nBFS (iterative manner): ");
		boolean visited[] = new boolean[graph.numVertices];
		for (int i = 0; i < N; ++i) {
			if (!visited[i]) {
				BFSIterative(graph, i, visited);
			}
		}
		
		Arrays.fill(visited, false);		
		Queue<Integer> queue = new ArrayDeque<>();
		System.out.print("\nBFS (recursive manner): ");
		for (int i = 0; i < N; ++i) {
			if (!visited[i]) {
				queue.add(i);
				visited[i] = true;
				BFSReccursive(graph, visited, queue);
			}
		}
	}
}
