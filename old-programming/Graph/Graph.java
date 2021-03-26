package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	List<List<Edge>> adjacencyList;
	int numVertices;
	
	public Graph(List<Edge> list, int vertices) {
		if (list.isEmpty()) {
			throw new IllegalArgumentException("Null list of edges");
		}
		if (vertices < 0) {
			throw new IllegalArgumentException("Number of vertices is -ve");
		}
		
		numVertices = vertices;
		adjacencyList = new ArrayList<>(numVertices);
		
		for (int i = 0; i < numVertices; ++i) {
			adjacencyList.add(i, new ArrayList<>());
		}
		
		for (int i = 0; i < list.size(); ++i) {
			Edge edge = list.get(i);
			adjacencyList.get(edge.source).add(new Edge(edge.source, edge.destination, edge.weight));
		}
	}
}
