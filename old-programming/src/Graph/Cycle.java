/*
 * Problem:
 * Given an connected undirected graph, find if it contains any cycle or not using BFS and DFS.
 * 
 * Link:
 * http://www.techiedelight.com/check-undirected-graph-contains-cycle-not/ 
 */

package Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class BFSNodeC {
	int vertex;
	int parent;
	
	public BFSNodeC(int v, int p) {
		vertex = v;
		parent = p;
	}
}

public class Cycle {
	private static boolean HasCycleUsingDFSRec(Graph graph, int N, int source, boolean[] visited) {
		visited[source] = true;
		
		for (Edge edge: graph.adjacencyList.get(source)) {
			if (!visited[edge.destination]) {
				if (HasCycleUsingDFSRec(graph, N, edge.destination, visited))
					return true;				
			} else {
				return true;
			}
		}
		
		return false;		
	}
	
	private static boolean HasCycleUsingDFS(Graph graph, int N, int source) {		
		boolean visited[] = new boolean[N];
		boolean hasVisited = false;
		for (int i = 0; i < N; ++i) {
			if (!visited[i]) {
				hasVisited = hasVisited || HasCycleUsingDFSRec(graph, N, source, visited);
			}
		}
		return hasVisited;
	}
	
	private static boolean HasCycleUsingBFS(Graph graph, int N, int source) {
		boolean visited[] = new boolean[N];
		Queue<BFSNodeC> queue = new ArrayDeque<>();
		
		queue.add(new BFSNodeC(source, -1));
		visited[source] = true;
		
		while (!queue.isEmpty()) {
			BFSNodeC current = queue.poll();
			
			for (Edge edge: graph.adjacencyList.get(current.vertex)) {
				if (!visited[edge.destination]) {
					queue.add(new BFSNodeC(edge.destination, current.vertex));
					visited[edge.destination] = true;
				} else { //if(edge.destination != current.parent) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		 List<Edge> edges = Arrays.asList(
                 new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
                 new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
                 new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
                 new Edge(7, 11), new Edge(7, 12), new Edge(6, 10)
                 // edge (6->10) introduces a cycle in the graph
				);
		 final int N = 13;
		 
		 Graph graph = new Graph(edges, N);
		 int source = 1;
		 
		 System.out.println("HasCycleUsingBFS: " + (HasCycleUsingBFS(graph, N, source) ? "true" : "false"));
		 
		 System.out.println("HasCycleUsingDFS: " + (HasCycleUsingDFS(graph, N, source) ? "true" : "false"));
	}

}
