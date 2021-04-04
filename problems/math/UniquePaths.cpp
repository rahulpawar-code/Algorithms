// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/808/
// https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/808/discuss/22958/Math-solution-O(1)-space

#include <iostream>

int uniquePaths(int m, int n)
{
    if (m == 1 || n == 1) {
        return 1;
    }

    m--; n--;
    if (m < n) {
        std::swap(m, n);
    }

    long res = 1;
    int j = 1;
    for (int i = m + 1; i <= m + n; ++i, ++j) {
        res = (res * i) / j;
    }

    return static_cast<int>(res);
}

void test(int m, int n)
{
    std::cout << "m : " << m << ", n : " << n;
    std::cout << ", Unique paths : " << uniquePaths(m , n) << "\n";
}

int main()
{
    test(3, 7);
    test(7, 3);
    test(3, 3);
    return 0;
}
