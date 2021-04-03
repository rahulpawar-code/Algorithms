// https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/806/
// https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/

#include <iostream>
#include <vector>

bool search(std::vector<std::vector<int>>& mat, const int target,
    int& row, int& col)
{
    int rows = mat.size();
    int cols = mat[0].size();
    int r = 0;
    int c = cols - 1;

    while (r < rows && c >= 0) {
        int element = mat[r][c];

        if (element == target) {
            row = r;
            col = c;
            return true;
        }
        if (element < target) {
            r++;
        } else {
            c--;
        }
    }

    return false;
}

void test(std::vector<std::vector<int>>& mat, const int target)
{
    std::cout << "searching " << target << ". ";
    int row = -1;
    int col = -1;
    if (search(mat, target, row, col)) {
        std::cout << "Found at row : " << row << " , col " << col;
    } else {
        std::cout << "Not found";
    }
    std::cout <<"\n==================================================\n";
}

int main()
{
    std::vector<std::vector<int>> mat = {{ 10, 20, 30, 40 },
                      { 15, 25, 35, 45 },
                      { 27, 29, 37, 48 },
                      { 32, 33, 39, 50 }};
    test(mat, 29);
    test(mat, 5);
    test(mat, 55);
    test(mat, 10);
    test(mat, 50);

    return 0;
}
