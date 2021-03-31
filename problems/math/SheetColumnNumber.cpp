// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/817/

#include <iostream>
#include <string>
#include <vector>

const int BASE = 26;

int titleToNumber(const std::string& columnTitle)
{
    int number = 0;
    for (auto ch : columnTitle) {
        number = number * BASE + (ch - 'A' + 1);
    }
    return number;
}

void test(const std::string& columnTitle)
{
    std::cout << "Column title : " << columnTitle << " , number : " << titleToNumber(columnTitle) << "\n";
    std::cout << "=====================================\n";
}

int main()
{
    test("A");
    test("AB");
    test("ZY");
    test("FXSHRXW");

    return 0;
}
