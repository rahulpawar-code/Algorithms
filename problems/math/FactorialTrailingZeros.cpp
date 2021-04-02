// number of trailing zeroes in n!
// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/816/

#include <iostream>
#include <climits>

int trailingZeroes(const int n)
{
    int result = 0;
    for (long i = 5; i <= n; i = i * 5) {
        result = result + n / i;
    }
    return result;
}

void test(const int n)
{
    std::cout << "Number of trailing zeros in " << n << "! : " << trailingZeroes(n) << "\n";
}

int main()
{
    test(INT_MIN);
    test(-1);
    test(0);
    test(1);
    test(5);
    test(10);
    test(125);
    test(200);
    test(INT_MAX);
    return 0;
}