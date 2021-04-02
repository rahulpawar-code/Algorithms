// Sort Color Dutch National Flag problem
// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/798/
// https://en.wikipedia.org/wiki/Dutch_national_flag_problem

#include <vector>
#include <iostream>
#include <algorithm>

void print(const std::vector<int>& v)
{
    for (auto i : v) {
        std::cout << i << " ";
    }
}

void sort(std::vector<int>& nums)
{
    int end = nums.size() - 1;
    int start = 0;
    int mid = 0;

    while (mid <= end) {
        if (nums[mid] < 1) {
            std::swap(nums[mid], nums[start]);
            start++;
            mid++;
        } else if (nums[mid] > 1) {
            std::swap(nums[mid], nums[end]);
            end--;
        } else {
            mid++;
        }
    }
}

void test(std::vector<int>& nums)
{
    std::cout << "Before sorting : ";
    print(nums);
    std::cout << "\n";
    sort(nums);
    std::cout << "After sorting : ";
    print(nums);
    std::cout << "\n";
    std::cout << "============================\n";
}

int main()
{
    std::vector<int> nums {2,0,2,1,1,0};
    test(nums);
    std::vector<int> nums1 {0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };
    test(nums1);
    std::vector<int> nums2 {};
    test(nums2);
    std::vector<int> nums3 {1,1,2,1,2,1,2,2,1,2,1};
    test(nums3);
    std::vector<int> nums4 {0,2,2,0,2};
    test(nums4);
    return 0;
}