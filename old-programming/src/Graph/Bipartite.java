package Graph;

/*
 * Problem Statement:
 * Given a graph, check if given graph is bipartite graph or not.
 * 
 * Link:
 * http://www.techiedelight.com/bipartite-graph/
 */


// TODO: Method 2: Check bipartite graph using BFS traversal and 2-coloring
// TODO: Method 3: Check bipartite graph using DFS traversal and odd cycle
// TODO: Method 4: Check bipartite graph using DFS traversal and 2-coloring

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Bipartite {
	// Method 1: Check bipartite graph using BFS traversal and odd cycle
	private static boolean isBipartiteBFSOddCycle(Graph graph, int source, int vertices) {
		boolean visited[] = new boolean[vertices];
		visited[source] = true;
				
		int level[] = new int[vertices];
		level[source] = 0;
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(source);
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			for (Edge edge: graph.adjacencyList.get(current)) {
				int neighbour = edge.destination;
				if (!visited[neighbour]) {
					queue.add(neighbour);
					visited[neighbour] = true;
					level[neighbour] = level[current] + 1;
				} else if (level[neighbour] == level[current]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// vector of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                            new Edge(1, 2), new Edge(2, 3), new Edge(2, 8), 
                            new Edge(3, 4), new Edge(4, 6), new Edge(5, 7),
                            new Edge(5, 9), new Edge(8, 9), new Edge(2, 4)
                            // if we add 2->4 edge, graph is becomes non-Bipartite
                        );

        // Set number of vertices in the graph
        final int N = 10;

        // create a graph from edges
        Graph graph = new Graph(edges, N);

        // Do BFS traversal starting from vertex 1
        if (isBipartiteBFSOddCycle(graph, 1, N))
            System.out.println("Bipartite Graph");
        else
            System.out.println("Not a Bipartite Graph");
	}	
}