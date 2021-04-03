// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/802/

#include <iostream>
#include <vector>

void print(const std::vector<int>& nums)
{
    for (auto n : nums) {
        std::cout << n << " ";
    }
}

int search(const std::vector<int>& nums, const int target, const bool firstIndex)
{
    int left = 0;
    int right = nums.size() - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            if (firstIndex) {
                if (mid == left || nums[mid - 1] != target) {
                    return mid;
                }
                right = mid - 1;
            } else {
                if (mid == right || nums[mid + 1] != target) {
                    return mid;
                }
                left = mid + 1;
            }
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1;
}

std::vector<int> searchRange(const std::vector<int>& nums, int target)
{
    if (nums.empty() || target < nums[0] || target > nums.back()) {
        return {-1, -1};
    }

    int startIndex = search(nums, target, true);
    if (startIndex == -1) {
        return {-1,-1};
    }
    int endIndex = search(nums, target, false);

    return {startIndex, endIndex};
}

void test(const std::vector<int>& nums, const int target)
{
    std::cout << "Array : ";
    print(nums);
    std::cout << ", searching " << target << "\n";
    std::vector<int> index = searchRange(nums, target);
    std::cout << "Found at " << "[" << index[0] << ", " << index[1] << "]\n";
    std::cout << "===============================================\n";
}

int main()
{
    std::vector<int> nums {5,5,7,7,8,8,10,10,10};
    test(nums, 5);
    test(nums, 8);
    test(nums, 10);
    test(nums, 6);
    test(nums, 12);
    test(nums, 0);
    return 0;
}
