// Combination sum
// https://leetcode.com/problems/combination-sum/
// https://leetcode.com/problems/combination-sum-ii/

#include <iostream>
#include <vector>
#include <unordered_set>
#include <algorithm>


void backtrack(std::vector<std::vector<int>>& result, const std::vector<int>& nums,
    std::vector<int>& current, int remaining, int start)
{
    if (remaining == 0) {
        result.push_back(current);
        return;
    }
    for (int i = start; i < nums.size() && remaining >= nums[i]; ++i) {
        current.push_back(nums[i]);
        backtrack(result, nums, current, remaining - nums[i], i);
        current.pop_back();
    }

}

std::vector<std::vector<int>> combinationSum(std::vector<int>& nums, const int target) {
    std::vector<std::vector<int>> result;
    std::vector<int> current;
    std::sort(nums.begin(), nums.end());
    backtrack(result, nums, current, target, 0);
    return result;
}

void backtrackWithoutDuplicate(std::vector<std::vector<int>>& result, const std::vector<int>& nums,
    std::vector<int>& current, int remaining, int start, std::unordered_set<int>& processed)
{
    if (remaining < 0) {
        return;
    } else if(remaining == 0) {
        result.push_back(current);
        return;
    } else {
        for (int i = start; i < nums.size(); ++i) {
            if (processed.find(nums[i]) != processed.end()) {
                continue;
            }
            current.push_back(nums[i]);
            processed.emplace(nums[i]);
            backtrackWithoutDuplicate(result, nums, current, remaining - nums[i], i, processed);
            current.pop_back();
            processed.erase(nums[i]);
        }
    }
}

std::vector<std::vector<int>> combinationSumWithoutDuplicates(const std::vector<int>& nums, int target)
{
    std::vector<std::vector<int>> result;
    std::vector<int> current;
    std::unordered_set<int> processed;
    backtrackWithoutDuplicate(result, nums, current, target, 0, processed);
    return result;
}

void print(const std::vector<std::vector<int>>& result)
{
    for (auto res : result) {
        if (res.size() == 0) {
            std::cout << "[ ]";
        } else {
            for (auto r : res) {
                std::cout << r << " ";
            }
        }
        std::cout << "\n";
    }
}

int main()
{
    std::vector<int> nums {2,3,5};
    int target = 8;

    std::cout << "============================================\n";
    std::vector<std::vector<int>> result1;
    result1 = combinationSum(nums, target);
    print(result1);

    std::cout << "============================================\n";
    std::vector<std::vector<int>> result2;
    result2 = combinationSumWithoutDuplicates(nums, target);
    print(result2);

    return 0;
}
