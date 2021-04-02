// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/801/
// https://leetcode.com/problems/find-peak-element/solution/

#include <iostream>
#include <vector>

void print(const std::vector<int>& nums)
{
    for (auto n : nums) {
        std::cout << n << " ";
    }
}

int findPeakElement(const std::vector<int>& nums)
{
    for (int i = 0; i < nums.size() - 1; ++i) {
        if (nums[i] > nums[i + 1]) {
            return i;
        }
    }

    return nums.size() - 1;
}

void test(const std::vector<int>& nums)
{
    print(nums);
    std::cout << "\nPeak element index : " << findPeakElement(nums) << "\n";
}

int main()
{
    std::vector<int> nums {1,2,3,1};
    test(nums);
    std::vector<int> nums2 {1,2,1,3,5,6,4};
    test(nums2);
    std::vector<int> nums3 {5,4,3,2,1};
    test(nums3);
    std::vector<int> nums4 {1,2,3,5,6};
    test(nums4);
    std::vector<int> nums5 {1,1,1,1,1,1};
    test(nums5);
    return 0;
}