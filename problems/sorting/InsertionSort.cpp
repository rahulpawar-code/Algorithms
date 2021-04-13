// Techie Delight https://www.techiedelight.com/merge-sort/

#include <iostream>
#include <vector>
#include <cstdlib>
#include <algorithm>

void print(const std::vector<int>& nums)
{
    for (auto n : nums) {
        std::cout << n << " ";
    }
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

void insertionSort(std::vector<int>& nums)
{
    for (int i = 1; i < nums.size(); ++i) {
        int value = nums[i];
        int j = i;
        while (j > 0 && nums[j - 1] > value) {
            nums[j] = nums[j - 1];
            j--;
        }
        nums[j] = value;
    }
}

void test(std::vector<int>& nums)
{
    std::cout << "Numbers before sorting: ";
    print(nums);
    insertionSort(nums);
    std::cout << "\nNumbers after sorting: ";
    print(nums);
    std::cout << "\nIs sorted: " << std::boolalpha << std::is_sorted(nums.begin(), nums.end());
    std::cout << "\n";
}

int main()
{
    std::vector<int> nums = generateRandomNumbers(20, -1000, 1000);
    test(nums);

    return 0;
}
