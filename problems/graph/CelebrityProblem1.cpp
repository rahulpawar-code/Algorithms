// https://www.geeksforgeeks.org/the-celebrity-problem/

#include <vector>
#include <iostream>

bool knows(std::vector<std::vector<int>>& matrix, int i, int j)
{
    return matrix[i][j];
}

int findCelebrity(std::vector<std::vector<int>>& matrix)
{
    int celebrityId = -1;

    int n = matrix.size();
    std::vector<int> indegree(n, 0);
    std::vector<int> outdegree(n, 0);

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (knows(matrix, i, j)) {
                outdegree[i]++;
                indegree[j]++;
            }
        }
    }

    for (int i = 0; i < n; ++i) {
        if (indegree[i] == n - 1 && outdegree[i] == 0) {
            return i;
        }
    }

    return celebrityId;
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
