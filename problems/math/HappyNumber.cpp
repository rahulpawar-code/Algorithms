// Happy number
// Leetcode : https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/815/

#include <unordered_set>
#include <iostream>

int sumOfSquares(int number, int base = 10)
{
    int sum = 0;
    while (number > 0) {
        int digit = number % base;
        sum = digit * digit + sum;
        number = number / base;
    }
    return sum;
}

bool isHappyNumber(int number)
{
    std::unordered_set<int> seen;
    while (number > 1 && (seen.find(number) == seen.end())) {
        seen.insert(number);
        number = sumOfSquares(number);
    }
    return (number == 1);
}

void test(const int number)
{
    std::cout << number << " is happy number : " << std::boolalpha << isHappyNumber(number) << "\n";
    std::cout << "===============================\n";
}

int main()
{
    test(19);
    test(2);
    test(998);

    return 0;
}