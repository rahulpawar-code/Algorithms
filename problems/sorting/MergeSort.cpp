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

void merge(std::vector<int>& nums, std::vector<int>& aux, int low, int mid, int high)
{
    int i = low;
    int j = mid + 1;
    int k = low;

    while (i <= mid && j <= high) {
        if (nums[i] <= nums[j]) {
            aux[k++] = nums[i++];
        } else {
            aux[k++] = nums[j++];
        }
    }

    while (i <= mid) {
        aux[k++] = nums[i++];
    }


    while (j <= high) {
        aux[k++] = nums[j++];
    }

    for (int i = low; i <= high; ++i) {
        nums[i] = aux[i];
    }
}

void mergesort(std::vector<int>& nums, std::vector<int>& aux, int low, int high)
{
    if (low == high) {
        return;
    }

    int mid = low + (high - low) / 2;
    mergesort(nums, aux, low, mid);
    mergesort(nums, aux, mid + 1, high);
    merge(nums, aux, low, mid, high);
}

void mergesort(std::vector<int>& nums)
{
    std::vector<int> aux(nums.size());
    mergesort(nums, aux, 0, nums.size() - 1);
}

void test(std::vector<int>& nums)
{
    std::cout << "Numbers before sorting: ";
    print(nums);
    mergesort(nums);
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
