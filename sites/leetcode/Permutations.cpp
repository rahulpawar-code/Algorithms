// Permutations
// https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/

#include <iostream>
#include <vector>

void permutations(std::vector<std::vector<int>>& result, std::vector<int>& nums, int begin)
{
    if (begin >= nums.size()) {
        result.push_back(nums);
        return;
    }
    for (int i = begin; i < nums.size(); ++i) {
        std::swap(nums[begin], nums[i]);
        permutations(result, nums, begin + 1);
        std::swap(nums[begin], nums[i]);
    }
}

std::vector<std::vector<int>> permutation(std::vector<int>& nums)
{
    std::vector<std::vector<int>> result;
    permutations(result, nums, 0);
    return result;
}

void print(std::vector<std::vector<int>> result)
{
    if (result.size() == 0) {
        return;
    }

    for (auto res : result) {
        for (auto r : res) {
            std::cout << r << " ";
        }
        std::cout << "\n";
    }
}

int main()
{
    std::vector<int> nums {1};
    std::vector<std::vector<int>> result = permutation(nums);
    print(result);
    return 0;
}
