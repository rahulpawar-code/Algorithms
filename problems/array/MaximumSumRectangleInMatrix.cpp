// GeeksforGeeks https://www.geeksforgeeks.org/maximum-sum-rectangle-in-a-2d-matrix-dp-27/

#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>

struct Result
{
public:
    int maxSum {INT_MIN};
    int top {-1};
    int bottom {-1};
    int left {-1};
    int right {-1};

    void setValues(int sum, int t, int b, int l, int r) {
        maxSum = sum;
        top = t;
        bottom = b;
        left = l;
        right = r;
    }
};

int kadane(std::vector<int>& array, int& start, int& finish)
{
    int currentSum {0};
    int maxSum {INT_MIN};
    int lStart {0};
    finish = -1;

    for (int i = 0; i < array.size(); ++i) {
        currentSum += array[i];
        if (currentSum < 0) {
            currentSum = 0;
            lStart = i + 1;
        } else if (currentSum > maxSum) {
            maxSum = currentSum;
            finish = i;
            start = lStart;
        }
    }

    if (finish != - 1) {
        return maxSum;
    }

    maxSum = array[0];
    start = finish = 0;

    for (int i = 1; i < array.size(); ++i) {
        if (array[i] > maxSum) {
            maxSum = array[i];
            start = finish = i;
        }
    }

    return maxSum;
}

void maximumSumRectangle(std::vector<std::vector<int>>& matrix, Result& result)
{
    const int ROWS = matrix.size();
    const int COLS = matrix[0].size();
    int start {-1};
    int finish {-1};
    int sum {INT_MIN};
    int maxSum {INT_MIN};

    std::vector<int> temp(ROWS);
    for (int left = 0; left < COLS; ++left) {
        std::fill(temp.begin(), temp.end(), 0);

        for (int right = left; right < COLS; ++right) {
            // Find row sum of this vertical column at right index
            for (int i = 0; i < ROWS; ++i) {
                temp[i] = temp[i] + matrix[i][right];
            }

            // Run Kadane algorithm, get start and end indices
            sum = kadane(temp, start, finish);

            // Update bounds and max sum
            if (sum > maxSum) {
                maxSum = sum;
                result.setValues(maxSum, start, finish, left, right);
            }
        }
    }
}

void test(std::vector<std::vector<int>>& matrix)
{
    struct Result result;
    maximumSumRectangle(matrix, result);
    std::cout << "Maximum sum is : " << result.maxSum << "\n";
    std::cout << "(top, left) : " << "(" << result.top << "," << result.left << ")\n";
    std::cout << "(bottom, right) : " << "(" << result.bottom << "," << result.right << ")\n";
}

int main()
{
    std::vector<std::vector<int>> matrix = {{1, 2, -1, -4, 20},
                                            { -8, -3, 4, 2, 1},
                                            {3, 8, 10, 1, 3},
                                            {-4, -1, 1, 7, -6}};
    test(matrix);

    return 0;
}