package Graph;

public class Edge {
	int source;
	int destination;
	int weight;
	
	public Edge(int s, int d) {
		source = s;
		destination = d;
	}
	
	public Edge(int s, int d, int w) {
		source = s;
		destination = d;
		weight = w;
	}
}
