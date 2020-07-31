package Graph;

import java.util.Arrays;
import java.util.List;

/*
 * Problem statement:
 * Given a graph, find arrival &amp; departure time of its vertices in DFS.
 * Arrival Time is the time at which the vertex was explored for the first
 * time in the DFS and Departure Time is the time at which we have explored
 * all the neighbors of the vertex and we are ready to backtrack.
 * 
 * Link:
 * http://www.techiedelight.com/arrival-departure-time-vertices-dfs/
 */

public class ArrivalDepartureTimeInDFS {
	private static void measureTime(Graph graph, int source, boolean visited[], int arrival[], int departure[], int time) {
		visited[source] = true;
		arrival[source] = time;
		time = time + 1;
		
		for (Edge egde: graph.adjacencyList.get(source)) {
			int current = egde.destination;
			if (!visited[current]) {
				measureTime(graph, current, visited, arrival, departure, time);
			}
		}
		
		departure[source] = time;
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
		
		int arrivalTime[] = new int[N];
		int departureTime[] = new int[N];
		boolean visited[] = new boolean[N];
		
		for (int i = 0; i < N; ++i) {
			if(!visited[i]) {
				measureTime(graph, i, visited, arrivalTime, departureTime, 0);
			}
		}
		
		for(int i = 0; i < N; ++i) {
			System.out.println(i + " (" + arrivalTime[i] + "," + departureTime[i] + ")");
		}
	}
}
