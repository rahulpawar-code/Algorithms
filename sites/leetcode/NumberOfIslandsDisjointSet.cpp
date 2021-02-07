// Number of Islands https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/792/
// Using disjoint set https://www.geeksforgeeks.org/find-the-number-of-islands-set-2-using-disjoint-set/?ref=rp

#include <iostream>
#include <vector>

static constexpr int numNext = 4;
static constexpr int rowNext[numNext] = {0, 0, -1, 1};
static constexpr int colNext[numNext] = {-1, 1, 0, 0};

class DisjointSet
{
private:
    std::vector<int> parent;
    std::vector<int> rank;
    const int n;

public:
    DisjointSet(int num) : n{num}
    {
        parent.resize(n);
        rank.resize(n);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int x)
    {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    void join(int x, int y)
    {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return;
        }
        if (rank[x] < rank[y]) {
            parent[xParent] = yParent;
        } else if (rank[x] > rank[y]) {
            parent[yParent] = xParent;
        } else {
            parent[yParent] = xParent;
            rank[xParent]++;
        }
    }
};

int toLinearIndex(const int r, const int c, const int rows, const int cols)
{
    return r * cols + c;
}

bool isSafe(const int row, const int col, const int rows, const int cols,
    std::vector<std::vector<char>>& grid)
{
    return row >= 0 && col >= 0 && row < rows && col < cols &&
            grid[row][col] == '1';
}

int numIslandsDisjointSet(std::vector<std::vector<char>>& grid)
{
    const int rows = grid.size();
    const int cols = grid[0].size();
    const int gridSize = rows * cols;
    DisjointSet set(gridSize);

    for (int r = 0; r < rows; ++r) {
        for (int c = 0; c < cols; ++c) {
            if (grid[r][c] == '1') {
                for (int i = 0; i < numNext; ++i) {
                    int rNext = r + rowNext[i];
                    int cNext = c + colNext[i];
                    if (isSafe(rNext, cNext, rows, cols, grid)) {
                        set.join(toLinearIndex(r, c, rows, cols),
                                 toLinearIndex(rNext, cNext, rows, cols));
                    }
                }
            }
        }
    }

    int frequency[gridSize] = {0};
    int count = 0;
    for (int r = 0; r < rows; ++r) {
        for (int c = 0; c < cols; ++c) {
            if (grid[r][c] == '1') {
                int parent = set.find(toLinearIndex(r, c, rows, cols));
                if (frequency[parent] == 0) {
                    count++;
                }
                frequency[parent]++;
            }
        }
    }

    return count;
}

int main()
{
    std::vector<std::vector<char>> grid1 {{'1','1','1','1','0'},
                                         {'1','1','0','1','0'},
                                         {'1','1','0','0','0'},
                                         {'0','0','0','0','0'}};
    std::cout << "Number of islands in grid1 (using disjoint set) : " << numIslandsDisjointSet(grid1) << "\n";
    std::cout << "should be 1\n";
    std::cout << "========================================================\n";
    std::vector<std::vector<char>> grid2 {{'1','1','0','0','0'},
                                         {'1','1','0','0','0'},
                                         {'0','0','1','0','0'},
                                         {'0','0','0','1','1'}};
    std::cout << "Number of islands in grid2 (using disjoint set) : " << numIslandsDisjointSet(grid2) << "\n";
    std::cout << "should be 3\n";

    return 0;
}