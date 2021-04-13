// Techie Delight https://www.techiedelight.com/quicksort/

#include <iostream>
#include <vector>
#include <cstdlib>
#include <algorithm>
#include <ctime>

void print(const std::vector<int>& nums)
{
    for (auto n : nums) {
        std::cout << n << " ";
    }
}

std::vector<int> generateRandomNumbers(const int length, const int min, const int max)
{
    std::srand(std::time(nullptr));
    std::vector<int> nums;
    for (int i = 0; i < length; ++i) {
        int x = min + (rand() % max - min + 1);
        nums.push_back(x);
    }
    return nums;
}

int partition(std::vector<int>& nums, int low, int high)
{
    int pivot = nums[high];
    int index = low;
    for (int i = low; i <= high; ++i) {
        if (nums[i] < pivot) {
            std::swap(nums[index++], nums[i]);
        }
    }
    std::swap(nums[index], nums[high]);
    return index;
}

void quicksort(std::vector<int>& nums, int low, int high)
{
    if (low >= high) {
        return;
    }

    int pivot = partition(nums, low, high);
    quicksort(nums, low, pivot - 1);
    quicksort(nums, pivot + 1, high);
}

void quicksort(std::vector<int>& nums)
{
    quicksort(nums, 0, nums.size() - 1);
}

void test(std::vector<int>& nums)
{
    std::cout << "Numbers before sorting: ";
    print(nums);
    quicksort(nums);
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
