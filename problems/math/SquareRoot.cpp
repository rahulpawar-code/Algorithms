// compute and return the square root of x
// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/819/
// Techie delight https://www.techiedelight.com/find-square-root-using-binary-search-algorithm/

#include <iostream>
#include <climits>
#include <vector>

int mySqrt(const int x)
{
    if (x <= 1) {
        return x;
    }

    int low = 1;
    int high = x / 2;
    int result;

    while (low <= high) {
        int mid = low + (high - low) / 2;
        long square = mid * mid;
        if (square == x) {
            return mid;
        } else if (square < x) {
            low = mid + 1;
            result = mid;
        } else {
            high = mid - 1;
        }
    }

    return result;
}

void test(const int x)
{
    std::cout << "Sqaure root of " << x << " : " << mySqrt(x) << "\n";
}

int main()
{
    std::vector<int> xvalue {0, 1, 2, 3, 4, 5, 8, 23, 1000, 1024, INT_MAX};
    for (auto x : xvalue) {
        test(x);
    }

    return 0;
}