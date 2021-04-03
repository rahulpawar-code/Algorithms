// Find kth smallest element in array, Quikselect algorithm
// Techie Delight https://www.techiedelight.com/quickselect-algorithm/
// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/800/

#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

void print(const std::vector<int> nums)
{
    for (auto n : nums) {
        std::cout << n << " ";
    }
}

int partition(std::vector<int>& nums, int left, int right, int pIndex)
{
    int pivot = nums[pIndex];
    std::swap(nums[right], nums[pIndex]);
    pIndex = left;

    for (int i = left; i < right; ++i) {
        if (nums[i] <= pivot) {
            std::swap(nums[i], nums[pIndex]);
            pIndex++;
        }
    }

    std::swap(nums[pIndex], nums[right]);
    return pIndex;
}

int quickselect(std::vector<int>& nums, const int k, int left, int right)
{
    if (left == right) {
        return nums[left];
    }

    int pIndex = left + rand() % (right - left + 1);
    pIndex = partition(nums, left, right, pIndex);

    if (pIndex + k == nums.size()) {
        return nums[pIndex];
    } else if (pIndex + k < nums.size()) {
        return quickselect(nums, k, pIndex + 1, right);
    } else {
        return quickselect(nums, k, left, pIndex - 1);
    }
}

int quickselect(std::vector<int>& nums, const int k)
{
    if (nums.empty() || k <= 0 || k > nums.size()) {
        return INT_MIN;
    }

    return quickselect(nums, k, 0, nums.size() - 1);
}

void test(std::vector<int>& nums, std::vector<int> kArray)
{
    std::cout << "Array : ";
    print(nums);
    std::cout << "\n";
    for (auto k : kArray) {
        std::cout << k << " th smallest using quick select algo : ";
        std::cout << quickselect(nums, k) << "\n";
    }
    std::cout << "=============================================\n";
}

int main()
{
    std::vector<int> nums {7, 4, 6, 3, 9, 1};
    std::vector<int> kArray {-1, 0, 1, 2, 5, 6, 7};
    test(nums, kArray);

    return 0;
}