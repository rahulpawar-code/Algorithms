package Graph;

public class BFSNode {
	int vertex;
	int weight;
	int distance; // Edge distance of vertex from BFS source node

	public BFSNode(int v, int d) {
		vertex = v;
		distance = d;
	}
	
	public BFSNode(int v, int w, int d) {
		vertex = v;
		weight = w;
		distance = d;
	}
}