// pow(x, n), which calculates x raised to the power n
// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/818/

#include <iostream>
#include <climits>
#include <vector>

double myPow(const double x, const int n)
{
    if (n == INT_MIN) {
        return 0;
    }
    if (n < 0) {
        return myPow(1 / x, -n);
    }
    if (n == 0) {
        return 1;
    }

    double pow = myPow(x, n / 2);

    if (n & 1 == 1) {
        return x * pow * pow;
    }

    return pow * pow;
}

void test(const double x, const int n)
{
    std::cout << "pow("<< x << "," << n << ") : " << myPow(x, n) << "\n";
}

int main()
{
    std::vector<double> xvalue{-100.0, -11.0, -2.0, -1.0, 0, 1.0, 2.0, 9.0, 100.0};
    std::vector<int> nvalues{INT_MIN, -298, -2, -1, 0, 1, 2, 13, INT_MAX};

    for (auto x : xvalue) {
        for (auto n : nvalues) {
            test(x, n);
        }
    }

    return 0;
}
