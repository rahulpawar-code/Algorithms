// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/807/

#include <iostream>
#include <vector>

void print(const std::vector<int>& jumps)
{
    for (auto j : jumps) {
        std::cout << j << " ";
    }
}

bool canJump(const std::vector<int>& jumps)
{
    int lastGoodIndex = jumps.size() - 1;

    for (int i = jumps.size() - 2; i >= 0; --i) {
        if (i + jumps[i] >= lastGoodIndex) {
            lastGoodIndex = i;
        }
    }
    return (lastGoodIndex == 0);
}

void test(const std::vector<int>& jumps)
{
    std::cout << "Jumps : ";
    print(jumps);
    std::cout << "\nGreedy method : " << std::boolalpha << canJump(jumps);
    std::cout << "\n===================================\n";
}

int main()
{
    std::vector<int> jumps1 {2,3,1,1,4};
    test(jumps1);
    std::vector<int> jumps2 {3,2,1,0,4};
    test(jumps2);
    return 0;
}
