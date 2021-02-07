// Number of Islands https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/792/

#include <iostream>
#include <vector>

constexpr static int numNext = 4;
constexpr static int rowNext[numNext] = {0, 0, -1, 1};
constexpr static int colNext[numNext] = {-1, 1, 0, 0};

bool isSafe(const int row, const int col, const int rows, const int cols)
{
    return row >= 0 && col >= 0 && row < rows && col < cols;
}

void visitNeighbours(const int r, const int c, const int rows, const int cols,
    std::vector<std::vector<char>>& grid, std::vector<std::vector<bool>>& visited)
{
    visited[r][c] = true;

    for (int i = 0; i < numNext; ++i) {
        int rNext = r + rowNext[i];
        int cNext = c + colNext[i];

        if (isSafe(rNext, cNext, rows, cols) && grid[rNext][cNext] == '1' && !visited[rNext][cNext]) {
            visitNeighbours(rNext, cNext, rows, cols, grid, visited);
        }
    }
}

int numIslands(std::vector<std::vector<char>>& grid) {
    const int rows = grid.size();
    const int cols = grid[0].size();
    std::vector<std::vector<bool>> visited(rows, std::vector<bool>(cols, false));

    int count = 0;
    for (int r = 0; r < rows; ++r) {
        for (int c = 0; c < cols; ++c) {
            if (grid[r][c] == '1' && !visited[r][c]) {
                visitNeighbours(r, c, rows, cols, grid, visited);
                ++count;
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
    std::cout << "Number of islands in grid1 : " << numIslands(grid1) << "\n";

    std::vector<std::vector<char>> grid2 {{'1','1','0','0','0'},
                                         {'1','1','0','0','0'},
                                         {'0','0','1','0','0'},
                                         {'0','0','0','1','1'}};
    std::cout << "Number of islands in grid2 : " << numIslands(grid2) << "\n";

    return 0;
}

