// Generate subsets
// Problem - https://leetcode.com/problems/subsets/
// Problem - https://leetcode.com/problems/subsets-ii/

// Discussion
// https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)

#include <iostream>
#include <vector>
#include <unordered_set>

void backtrack(std::vector<std::vector<int>>& sets, const std::vector<int>& nums,
    int start, std::vector<int>& current)
{
    sets.push_back(current);
    for (int i = start; i < nums.size(); ++i) {
        current.push_back(nums[i]);
        backtrack(sets, nums, i + 1, current);
        current.pop_back();
    }
}

std::vector<std::vector<int>> subsets(const std::vector<int>& nums)
{
    std::vector<std::vector<int>> sets;
    std::vector<int> temp;
    backtrack(sets, nums, 0, temp);
    return sets;
}

void backtrackUnique(std::vector<std::vector<int>>& sets, const std::vector<int>& nums,
    int start, std::vector<int>& current, std::unordered_set<int>& processed)
{
    sets.push_back(current);
    for (int i = start; i < nums.size(); ++i) {
        if (processed.find(nums[i]) != processed.end()) {
            continue;
        }

        current.push_back(nums[i]);
        processed.emplace(nums[start]);
        backtrackUnique(sets, nums, i + 1, current, processed);
        processed.erase(nums[start]);
        current.pop_back();
    }

}

std::vector<std::vector<int>> subsetsUnique(const std::vector<int>& nums)
{
    std::vector<std::vector<int>> sets;
    std::vector<int> temp;
    std::unordered_set<int> processed;
    backtrackUnique(sets, nums, 0, temp, processed);
    return sets;
}

void print(std::vector<std::vector<int>> sets)
{
    for (auto set : sets) {
        for (auto s : set) {
            std::cout << s << " ";
        }
        std::cout << "\n";
    }
}

int main()
{
    std::vector<int> nums {1, 2, 3, 3};
    std::cout << "==========================================\n";
    std::vector<std::vector<int>> setsWithDuplicates = subsets(nums);
    print(setsWithDuplicates);
    std::cout << "==========================================\n";
    std::vector<std::vector<int>> setsWithoutDuplicates = subsetsUnique(nums);
    print(setsWithoutDuplicates);
    return 0;
}