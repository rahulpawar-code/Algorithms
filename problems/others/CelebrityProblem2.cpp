// https://www.geeksforgeeks.org/the-celebrity-problem/

#include <vector>
#include <iostream>

bool knows(std::vector<std::vector<int>>& matrix, int i, int j)
{
    return matrix[i][j];
}

int findCelebrity(std::vector<std::vector<int>>& matrix)
{
    int first = 0;
    int last = matrix.size() - 1;

    while (first < last) {
        if (knows(matrix, first, last)) {
            first++;
        } else {
            last--;
        }
    }

    for (int i = 0; i < matrix.size(); ++i) {
        if ((i != first) && knows(matrix, i, first) &&
                        !knows(matrix, i, first)) {
            return -1;
        }
    }

    return first;
}

int main()
{
    std::vector<std::vector<int>> matrix {{0, 0, 1, 0},
                                            {0, 0, 1, 0},
                                            {0, 0, 0, 0},
                                            {0, 0, 1, 0}};
    int id = findCelebrity(matrix);
    std::cout << "Celebrity index : " << id << "\n";

    return 0;
}