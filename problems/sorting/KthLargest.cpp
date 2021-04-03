// Find kth largest element in array
// Techie Delight https://www.techiedelight.com/find-kth-largest-element-array/
// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/800/

#include <iostream>
#include <vector>
#include <queue>
#include <climits>
#include <algorithm>

void print(const std::vector<int>& nums)
{
    for (auto n : nums) {
        std::cout << n << " ";
    }
}

// Using min heap
int method1(std::vector<int> nums, const int k)
{
    if (nums.size() == 0 || k <= 0 || k > nums.size()) {
        return INT_MIN;
    }

    std::priority_queue<int, std::vector<int>, std::greater<int>>
        minq(nums.begin(), nums.begin() + k);

    for (int i = k; i < nums.size(); ++i) {
        if (nums[i] > minq.top()) {
            minq.pop();
            minq.push(nums[i]);
        }
    }

    return minq.top();
}

// Using max heap
int method2(std::vector<int> nums, int k)
{
    if (nums.size() == 0 || k <= 0 || k > nums.size()) {
        return INT_MIN;
    }

    std::priority_queue<int, std::vector<int>> pq(std::less<int>(), nums);
    while (--k) {
        pq.pop();
    }

    return pq.top();
}

// Using STL iterators
int method3(std::vector<int> nums, const int k)
{
    if (nums.size() == 0 || k <= 0 || k > nums.size()) {
        return INT_MIN;
    }
    std::nth_element(nums.begin(), nums.begin() + k - 1, nums.end(), std::greater<int>());
    return nums[k - 1];
}

void test(std::vector<int>& nums, const int k)
{
    std::cout << "Array : ";
    print(nums);
    std::cout << "\n";
    std::cout << k << " th largest using min heap " << method1(nums, k) << "\n";
    std::cout << k << " th largest using max heap " << method2(nums, k) << "\n";
    std::cout << k << " th largest using iterators and algorithm " << method3(nums, k) << "\n";
    std::cout << "====================================\n";
}

int main()
{
    std::vector<int> nums {7, 4, 6, 3, 9, 1};
    test(nums, -1);
    test(nums, 0);
    test(nums, 1);
    test(nums, 2);
    test(nums, 5);
    test(nums, 6);
    test(nums, 7);

    return 0;
}