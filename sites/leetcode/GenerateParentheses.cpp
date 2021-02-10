// Generate Balanced Parentheses https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/794/

#include <iostream>
#include <string>
#include <vector>

void generateParenthesesRec(std::vector<std::string>& parentheses, const int& n, int open, int close, std::string& current)
{
    if (current.length() == 2 * n) {
        parentheses.push_back(current);
        return;
    }
    if (open < n) {
        current.push_back('(');
        generateParenthesesRec(parentheses, n, open + 1, close, current);
        current.pop_back();
    }
    if (close < open) {
        current.push_back(')');
        generateParenthesesRec(parentheses, n, open, close + 1, current);
        current.pop_back();
    }
}

std::vector<std::string> generateParentheses(const int& n)
{
    std::vector<std::string> parentheses;
    std::string current;
    generateParenthesesRec(parentheses, n, 0, 0, current);
    return parentheses;
}

void print(std::vector<std::string>& parentheses)
{
    for (auto p : parentheses) {
        std::cout << p << "\n";
    }
}

int main()
{
    int n = 3;
    std::vector<std::string> parentheses = generateParentheses(n);
    std::cout << "Balanced parentheses of length " << n << " : \n";
    print(parentheses);
    return 0;
}
