// Graph
// https://www.techiedelight.com/graph-implementation-using-stl/

#include <iostream>
#include <vector>
#include <queue>

class Edge
{
public:
    int source;
    int destination;

    Edge(int s, int d) : source(s), destination(d) { }
};

class Graph
{
private:
    std::vector<std::vector<int>> adjacenyList;
    int vertices;

    void print(std::vector<int>& sequence)
    {
        for (auto v : sequence) {
            std::cout << v << " -> ";
        }
        std::cout << "\n";
    }

    void dfs(int vertex, std::vector<bool>& visited, std::vector<int>& sequence)
    {
        visited[vertex] = true;
        sequence.push_back(vertex);

        for (int u : adjacenyList[vertex]) {
            if (visited[u] == false) {
                dfs(u, visited, sequence);
            }
        }
    }

    void bfs(int vertex, std::vector<bool>& visited, std::vector<int>& sequence)
    {
        std::queue<int> q;
        q.push(vertex);
        visited[vertex] = true;

        while (!q.empty()) {
            int v = q.front();
            q.pop();
            sequence.push_back(v);

            for (auto u : adjacenyList[v]) {
                if (!visited[u]) {
                    visited[u] = true;
                    q.push(u);
                }
            }
        }
    }

public:
    Graph(const std::vector<Edge>& edges, int N) : vertices(N)
    {
        adjacenyList.resize(vertices);

        for (auto edge : edges) {
            adjacenyList[edge.source].push_back(edge.destination);
        }
    }

    void dfs()
    {
        std::vector<bool> visited(vertices);
        std::vector<int> sequence;

        for (int i = 0; i < vertices; ++i) {
            if (visited[i] == false) {
                dfs(i, visited, sequence);
            }
        }
        print(sequence);
    }

    void bfs()
    {
        std::vector<bool> visited(vertices, false);
        std::vector<int> sequence;

        for (int i = 0; i < vertices; ++i) {
            if (visited[i] == false) {
                bfs(i, visited, sequence);
            }
        }
        print(sequence);
    }

    void print()
    {
        for (int i = 0; i < vertices; ++i) {
            std::cout << i << " --> ";
            for (auto v : adjacenyList[i]) {
                std::cout << v << " ";
            }
            std::cout << "\n";
        }
    }
};

int main()
{
    std::vector<Edge> edges { {0, 12}, {1, 2}, {1, 7}, {1, 8}, {2, 3}, {2, 6}, {3, 4},
        {3, 5}, {8, 9}, {8, 12}, {9, 10}, {9, 11} };

    Graph graph(edges, 13);
    graph.print();
    std::cout << "DFS : ";
    graph.dfs();
    std::cout << "BFS : ";
    graph.bfs();

    return 0;
}