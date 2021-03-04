// Word Search
// https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/797/

#include <iostream>
#include <vector>
#include <string>

bool isInvalid(std::vector<std::vector<char>>& board, const std::string word, int r, int c, 
    const int m, const int n, std::vector<std::vector<bool>>& visited, int index)
{
    return r < 0 || c < 0 || r >= m || c >= n || 
            (board[r][c] != word[index]);
            //&& (visited[r][c] == false);
}

bool dfs(std::vector<std::vector<char>>& board, const std::string word, int r, int c,
    const int m, const int n, std::vector<std::vector<bool>>& visited, int index)
{
    if (index == word.size()) {
        return true;
    }
    
    if (r < 0 || c < 0 || r >= m || c >= n || 
            (board[r][c] != word[index])) {
        return false;
    }
    
    board[r][c] = '*';
    bool result = dfs(board, word, r + 1, c, m, n, visited, index + 1) ||
                  dfs(board, word, r - 1, c, m, n, visited, index + 1) ||
                  dfs(board, word, r, c - 1, m, n, visited, index + 1) ||
                  dfs(board, word, r, c + 1, m, n, visited, index + 1);
    std::cout << word[index] << " ";
    board[r][c] = word[index];
    
    return result;
}

bool recursive(std::vector<std::vector<char>>& board, const std::string word)
{
    if (board.size() == 0 || board[0].size() == 0 || word.empty()) {
        return false;
    }
    
    int m = board.size();
    int n = board[0].size();
    std::vector<std::vector<bool>> visited (m , std::vector<bool>(n, false));
    
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            std::cout << "====  " << board[i][j] << "\n";
            if (dfs(board, word, 0, 0, m, n, visited, 0)) {
                return true;
            }
        }
    }
    
    return false;
}

bool iterative(std::vector<std::vector<char>>& board, const std::string word)
{
    if (board.size() == 0 || board[0].size() == 0 || word.empty()) {
        return false;
    }
    
    int m = board.size();
    int n = board[0].size();
    std::vector<std::vector<bool>> visited (m , std::vector<bool>(n, false));
    
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            // Match forst char 
            if (board[i][j] == word[0]) {
                // bfs
                
            }
        }
    }
    
    return false;
}

void printBoard(std::vector<std::vector<char>>& board)
{
    for (auto row : board) {
        for (auto cell : row) {
            std::cout << cell << " ";
        }
        std::cout << "\n";
    }
}

int main() 
{
    std::vector<std::vector<char>> board {{'A','B','C','E'},
                                          {'S','F','C','S'},
                                          {'A','D','E','E'}};
    
    std::cout << "Board : \n";
    printBoard(board);
    
    std::cout << "=================================\n";
    std::string word = "SEE";
    std::cout << word << " present in board ?\n";
    std::cout << "Recursive : " << std::boolalpha << recursive(board, word) << "\n";
    std::cout << "Iterative : " << std::boolalpha << iterative(board, word) << "\n";
    
    /*
    std::cout << "=================================\n";
    std::string word = "ABCCED";
    std::cout << word << " present in board ?\n";
    std::cout << "Recursive : " << std::boolalpha << recursive(board, word) << "\n";
    std::cout << "Iterative : " << std::boolalpha << iterative(board, word) << "\n";
    
    
    
    std::cout << "=================================\n";
    word = "ABCB";
    std::cout << word << " present in board ?\n";
    std::cout << "Recursive : " << std::boolalpha << recursive(board, word) << "\n";
    std::cout << "Iterative : " << std::boolalpha << iterative(board, word) << "\n";
    */
    
    return 0;
}

