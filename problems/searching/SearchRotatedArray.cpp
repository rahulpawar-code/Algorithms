// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/804/

#include <iostream>
#include <vector>

void print(const std::vector<int>& nums)
{
    for (auto n : nums) {
        std::cout << n << " ";
    }
}

int search(const std::vector<int>& nums, const int target)
{
    if (nums.empty()) {
        return -1;
    }

    int left = 0;
    int right = nums.size() - 1;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else {
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
    }

    return nums[left] == target ? left : -1;
}

void test(const std::vector<int>& nums, const int target)
{
    std::cout << "Numbers : ";
    print(nums);
    std::cout << "\n";
    std::cout << "Target : " << target << "\n";
    std::cout << "Target found at index : " << search(nums, target);
    std::cout << "\n======================================\n";
}

int main()
{
    std::vector<int> nums {4,5,6,7,0,1,2};
    int target = 0;
    test(nums, target);
    target = 3;
    test(nums, target);
    target = 7;
    test(nums, target);

    return 0;
}
