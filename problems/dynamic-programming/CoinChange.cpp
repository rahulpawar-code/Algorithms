// Minimum number of coins need to make up that amount
// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/809/

#include <vector>
#include <iostream>
#include <algorithm>
#include <climits>

void print(const std::vector<int>& coins)
{
    for (auto coin : coins) {
        std::cout << coin << " ";
    }
}

int minCoins(std::vector<int>& coins, const int amount)
{
    std::vector<int> nums(amount + 1, INT_MAX);
    nums[0] = 0;
    std::sort(coins.begin(), coins.end());

    for (int i = 1; i <= amount; ++i) {
        for (auto c : coins) {
            if (i - c < 0) {
                break;

            }
            if (nums[i - c] != INT_MAX) {
                nums[i] = std::min(nums[i], nums[i - c] + 1);
            }
        }
    }

    return ((nums[amount] == INT_MAX) ? -1 : nums[amount]);
}

void test(std::vector<int>& coins, const int amount)
{
    std::cout << "Coins : ";
    print(coins);
    std::cout << "\nMin num of coins to make " << amount << " : ";
    std::cout << minCoins(coins, amount);
    std::cout << "\n===================================\n";
}

int main()
{
    std::vector<int> coins1 {1,2,5};
    test(coins1, 11);
    std::vector<int> coins2 {6};
    test(coins2, 7);
    return 0;
}