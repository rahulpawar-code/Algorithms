package Graph;

/*
 * Problem Statement:
 * Given a weighted directed graph, find the least cost path from given source to destination that have exactly m edges
 * 
 * Link:
 * http://www.techiedelight.com/least-cost-path-digraph-source-destination-m-edges/ 
 */


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;


public class LeastCostPath {
	public static int leastCostPath(Graph graph, int source, int destination, int m) {
		if (graph == null || source < -1 || destination < -1 || m <= 0) {
			throw new IllegalArgumentException("Illegal argument for least cost problem");
		}
		
		int leastCost = Integer.MAX_VALUE;			// Least cost to destination
		Queue<BFSNode> queue = new ArrayDeque<>();	// BFS queue
		queue.add(new BFSNode(source, 0, 0));		// Add source node
		
		while (!queue.isEmpty()) {
			BFSNode current = queue.poll();
			
			// Check if destination is reached
			if (current.vertex == destination && current.distance == m) {
				leastCost = Math.min(current.weight, leastCost);				
			}
			
			// Now all nodes in queue are at a distance more than m
			if (current.distance > m) {
				break;
			}
			
			// Process all adjacent of this vertex
			for (Edge egde: graph.adjacencyList.get(current.vertex)) {
				queue.add(new BFSNode(egde.destination, egde.weight + current.weight, current.distance + 1));
			}
		}
		
		return leastCost;
	}
	
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(
                new Edge(0, 6, -1), new Edge(0, 1, 5), new Edge(1, 6, 3),
                new Edge(1, 5, 5), new Edge(1, 2, 7), new Edge(2, 3, 8),
                new Edge(3, 4, 10), new Edge(5, 2, -1), new Edge(5, 3, 9),
                new Edge(5, 4, 1), new Edge(6, 5, 2), new Edge(7, 6, 9),
                new Edge(7, 1, 6)
        );
		
		final int N = 8;
		Graph graph = new Graph(edges, N);
		
		int source = 0;
		int destination = 3;
		int m = 4;
		int leastCost = leastCostPath(graph, source, destination, m);
		
		System.out.println("Least cost path: " + leastCost);		
	}
}
