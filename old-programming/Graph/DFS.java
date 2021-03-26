package Graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * Problem statement:
 * Depth first search in a graph, iterative and recursive manner
 * 
 * Link:
 * http://www.techiedelight.com/depth-first-search/ 
 */

public class DFS {
	private static void DFSIterative(Graph graph, int source, boolean visited[]) {
		Stack<Integer> stack = new Stack<>();
		
		stack.add(source);
		visited[source] = true;
		
		while (!stack.isEmpty()) {
			int current = stack.pop();
			visited[current] = true;
			System.out.print(current + " ");
			
			for (Edge edge : graph.adjacencyList.get(current)) {
				int neighbour = edge.destination;
				if (!visited[neighbour]) {
					stack.push(neighbour);					
				}
			}
		}
	}
	
	
	private static void DFSRecursive(Graph graph, int source, boolean visited[]) {
		visited[source] = true;
		System.out.print(source + " ");
		
		for (Edge edge: graph.adjacencyList.get(source)) {
			int current = edge.destination;
			if (!visited[current]) {
				DFSRecursive(graph, current, visited);
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
		
		System.out.print("\nDFS (recursive manner): ");
		boolean visited[] = new boolean[graph.numVertices];
		for (int i = 0; i < N; ++i) {
			if (!visited[i]) {
				DFSRecursive(graph, i, visited);
			}
		}
		
		Arrays.fill(visited, false);
		System.out.print("\nDFS (recursive manner): ");
		for (int i = 0; i < N; ++i) {
			if (!visited[i]) {
				DFSIterative(graph, i, visited);
			}
		}
	}
}
