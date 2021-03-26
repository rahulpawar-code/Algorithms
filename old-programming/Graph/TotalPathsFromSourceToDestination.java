package Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

/*
 * Problem Statement: 
 * Given a directed graph, find the total number of routes to reach the destination from given source that have exactly m edges.
 * 
 * Link:
 * http://www.techiedelight.com/total-paths-in-digraph-from-source-to-destination-m-edges/
 */


public class TotalPathsFromSourceToDestination {
	private static int totalPaths(Graph graph, int source, int destination, int m)
	{
		if (graph == null || source < 0 || destination < 0 || m <= 0) {
			throw new IllegalArgumentException("Illegal argument to total path problem");
		}
		
		int numPath = 0;
		ArrayDeque<BFSNode> queue = new ArrayDeque<>();
		queue.add(new  BFSNode(source, 0));
		
		while (!queue.isEmpty()) {
			BFSNode current = queue.poll();
			
			if (current.vertex == destination && current.distance == m) {
				numPath++;
			}
			
			// All nodes at distance less than or equal to m are explored
			if (current.distance > m) {
				break;
			}
			
			for (Edge edge : graph.adjacencyList.get(current.vertex)) {
				queue.add(new BFSNode(edge.destination, current.distance + 1));
			}
		}
		
		return numPath;
	}
	
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(
                new Edge(0, 6), new Edge(0, 1), new Edge(1, 6),
                new Edge(1, 5), new Edge(1, 2), new Edge(2, 3),
                new Edge(3, 4), new Edge(5, 2), new Edge(5, 3),
                new Edge(5, 4), new Edge(6, 5), new Edge(7, 6),
                new Edge(7, 1)
        );
		
		Graph graph = new Graph(edges, 8);
		
		int source = 0;
		int destination = 3;
		int m = 4;
		int leastCost = totalPaths(graph, source, destination, m);
		
		System.out.println("Least cost path: " + leastCost);

	}
}
