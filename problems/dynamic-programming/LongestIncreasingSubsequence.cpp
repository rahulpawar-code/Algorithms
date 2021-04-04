// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/810/

#include <iostream>
#include <vector>
#include <algorithm>

void print(const std::vector<int>& nums)
{
    for (auto n : nums) {
        std::cout << n << " ";
    }
}

int lis(const std::vector<int>& nums)
{
    int n = nums.size();
    std::vector<int> length(n, 1);

    for (int i = 1; i < n; ++i) {
        for (int j = i; j >= 0; --j) {
            if (nums[j] < nums[i]) {
                length[i] = std::max(length[i], length[j] + 1);
            }
        }
    }

    return *std::max_element(length.begin(), length.end());
}

void test(const std::vector<std::vector<int>>& nums)
{
    for (auto num : nums) {
        std::cout << "Sequence : ";
        print(num);
        std::cout << "\nLongest increasing subsequence : " << lis(num);
        std::cout << "\n=====================================\n";
    }
}

int main()
{
    std::vector<std::vector<int>> nums {{0,3,1,6,2,2,7,1,3,8},
                            {10,9,2,5,3,7,101,18},
                            {0,1,0,3,2},
                            {7,7,7,7,7,7,7},
                            {1,3,6,7,9,4,10,5,6}};
    test(nums);
    return 0;
}
