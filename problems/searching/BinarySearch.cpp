// Binary search recursive and iterative
// Techie delight https://www.techiedelight.com/binary-search/

#include <iostream>
#include <vector>
#include <cstdlib>
#include <algorithm>

void print(const std::vector<int>& nums)
{
    for (auto n : nums) {
        std::cout << n << " ";
    }
    std::cout << "\n";
}

std::vector<int> generateRandomNumbers(const int length, const int min, const int max)
{
    std::vector<int> nums;
    for (int i = 0; i < length; ++i) {
        int x = min + (rand() % max - min + 1);
        nums.push_back(x);
    }
    return nums;
}

int searchIterative(std::vector<int>& nums, const int target)
{
    int low = 0;
    int high = nums.size() - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return -1;
}

int searchRecursive(std::vector<int>& nums, const int target, int low, int high)
{
    if (low > high) {
        return -1;
    }
    int mid = low + (high - low) / 2;
    if (nums[mid] == target) {
        return mid;
    } else if (target < nums[mid]) {
        return searchRecursive(nums, target, low, mid - 1);
    } else {
        return searchRecursive(nums, target, mid + 1, high);
    }
}

int searchRecursive(std::vector<int>& nums, const int target)
{
    return searchRecursive(nums, target, 0, nums.size() - 1);
}

void test(std::vector<int>& nums, const int target)
{
    std::cout << "Numbers : ";
    print(nums);
    std::sort(nums.begin(), nums.end(), std::less<int>());
    std::cout << "\nSearching "<< target << " using iterative : Found at " << searchIterative(nums, target);
    std::cout << "\nSearching "<< target << " using recursive : Found at " << searchRecursive(nums, target);
    std::cout << "\nSearching "<< target << " using STL : Found? " << std::boolalpha
                << std::binary_search(nums.begin(), nums.end(), target);
    std::cout << "\n";
}

int main()
{
    std::vector<int> nums = generateRandomNumbers(50, 1, 50);
    test(nums, 5);

    return 0;
}