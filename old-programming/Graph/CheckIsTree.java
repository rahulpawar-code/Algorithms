/*
 * Problem statement:
 * Given an undirected graph, check if is is a tree or not. In other words,
 * check if given undirected graph is a Acyclic Connected Graph or not. 
 * 
 * Problem link:
 * https://www.techiedelight.com/determine-undirected-graph-tree-acyclic-connected-graph/ 
 */


package Graph;

import java.util.Arrays;
import java.util.List;

public class CheckIsTree {
	private static boolean DFSUtil(Graph graph, int source, int parent, boolean[] visited) {
		visited[source] = true;
		
		for (Edge edge : graph.adjacencyList.get(source)) {
			int destination = edge.destination;
			
			if (!visited[destination]) {
				if (!DFSUtil(graph, destination, source, visited)) {
					return false;
				}
			} else if (destination != parent) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		List<Edge> edges = Arrays.asList(
				new Edge(0, 1), new Edge(1, 2), new Edge(2, 3),
				new Edge(3, 4), new Edge(4, 5), new Edge(5, 0)
				// edge (5->0) introduces a cycle in the graph
		);

		// Number of vertices in the graph
		final int N = 6;

		// construct graph
		Graph graph = new Graph(edges, N);
		
		boolean[] visited = new boolean[N];
		
		boolean isTree = DFSUtil(graph, 0, -1, visited);
				
		for (int i = 0; i < N; ++i) {
			if (!visited[i]) {
				isTree = false;
			}
		}
		
		if (isTree) {
			System.out.println("Graph is tree");
		} else {
			System.out.println("Graph is not a tree");
		}
		
		
	}

}
