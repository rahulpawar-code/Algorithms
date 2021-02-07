// Number of Islands https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/792/

#include <iostream>
#include <vector>
#include <queue>

constexpr static int numNext = 4;
constexpr static int rowNext[numNext] = {0, 0, -1, 1};
constexpr static int colNext[numNext] = {-1, 1, 0, 0};

bool isSafe(const int row, const int col, const int rows, const int cols,
    std::vector<std::vector<char>>& grid, std::vector<std::vector<bool>>& visited)
{
    return row >= 0 && col >= 0 && row < rows && col < cols &&
            grid[row][col] == '1' && !visited[row][col];
}

void visitNeighboursDFS(const int r, const int c, const int rows, const int cols,
    std::vector<std::vector<char>>& grid, std::vector<std::vector<bool>>& visited)
{
    visited[r][c] = true;

    for (int i = 0; i < numNext; ++i) {
        int rNext = r + rowNext[i];
        int cNext = c + colNext[i];

        if (isSafe(rNext, cNext, rows, cols, grid, visited)) {
            visitNeighboursDFS(rNext, cNext, rows, cols, grid, visited);
        }
    }
}

int numIslandsDFS(std::vector<std::vector<char>>& grid) {
    const int rows = grid.size();
    const int cols = grid[0].size();
    std::vector<std::vector<bool>> visited(rows, std::vector<bool>(cols, false));

    int count = 0;
    for (int r = 0; r < rows; ++r) {
        for (int c = 0; c < cols; ++c) {
            if (grid[r][c] == '1' && !visited[r][c]) {
                visitNeighboursDFS(r, c, rows, cols, grid, visited);
                ++count;
            }
        }
    }

    return count;
}

void visitNeighboursBFS(const int r, const int c, const int rows, const int cols,
    std::vector<std::vector<char>>& grid, std::vector<std::vector<bool>>& visited)
{
    std::queue<std::pair<int, int>> queue;
    visited[r][c] = true;
    queue.push(std::make_pair(r, c));

    while (!queue.empty()) {
        int currentRow = queue.front().first;
        int currentCol = queue.front().second;
        queue.pop();

        for (int i = 0; i < numNext; ++i) {
            int rNext = currentRow + rowNext[i];
            int cNext = currentCol + colNext[i];

            if (isSafe(rNext, cNext, rows, cols, grid, visited)) {
                visited[rNext][cNext] = true;
                queue.push(std::make_pair(rNext, cNext));
            }
        }
    }
}

int numIslandsBFS(std::vector<std::vector<char>>& grid)
{
    const int rows = grid.size();
    const int cols = grid[0].size();
    std::vector<std::vector<bool>> visited(rows, std::vector<bool>(cols, false));
    int count = 0;

    for (int r = 0; r < rows; ++r) {
        for (int c = 0; c < cols; ++c) {
            if (grid[r][c] == '1' && !visited[r][c]) {
                visitNeighboursBFS(r, c, rows, cols, grid, visited);
                count++;
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
    std::cout << "Number of islands in grid1 (using DFS) : " << numIslandsDFS(grid1) << "\n";
    std::cout << "Number of islands in grid1 (using BFS) : " << numIslandsBFS(grid1) << "\n";
    std::cout << "========================================================\n";
    std::vector<std::vector<char>> grid2 {{'1','1','0','0','0'},
                                         {'1','1','0','0','0'},
                                         {'0','0','1','0','0'},
                                         {'0','0','0','1','1'}};
    std::cout << "Number of islands in grid2 (using DFS) : " << numIslandsDFS(grid2) << "\n";
    std::cout << "Number of islands in grid2 (using BFS) : " << numIslandsBFS(grid2) << "\n";

    return 0;
}

