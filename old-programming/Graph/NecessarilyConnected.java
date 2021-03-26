/*
 * Problem Link: https://www.careercup.com/question?id=5713002834165760
 */
package Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NecessarilyConnected {
	private static boolean isNecessarilyConnected(Graph graph, int node, int end, boolean visited[], HashSet<Integer> set) {
		if (node == end || set.contains(node)) 
			return true;
		if (graph.adjacencyList.get(node).size() == 0) {
			return false;
		}
		
		visited[node] = true;
		for (Edge edge : graph.adjacencyList.get(node)) {
			int destination = edge.destination;
			if (!visited[destination]) {
				if (!isNecessarilyConnected(graph, destination, end, visited, set)) {
					return false;
				} else {
					set.add(destination);
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 3), new Edge(3, 4), new Edge(2, 4),
                new Edge(3, 5), new Edge(5, 6), new Edge(6, 5)
				);
		 final int N = 7;
		 
		 Graph graph = new Graph(edges, N);
		 int source = 1;
		 int end = 3;
		 HashSet<Integer> set = new HashSet<>();
		 boolean[] visited = new boolean[graph.numVertices];
		 
		 System.out.println("Is necessarliy connected: " + (isNecessarilyConnected(graph, source, end, visited, set) ? "true" : "false"));

	}

}
