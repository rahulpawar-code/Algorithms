// Top K frequent elements
// https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/799/

#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <cstdlib>

void print(const std::vector<int>& numbers)
{
    if (numbers.empty()) {
        return;
    }
    for (auto num : numbers) {
        std::cout << num << " ";
    }
    std::cout << "\n";
}

int partition(const int left, const int right, const int kSmallest,
    std::vector<int>& uniqueKeys, std::unordered_map<int, int>& freqMap)
{
    int pivotFrequency = freqMap[uniqueKeys[kSmallest]];
    std::swap(uniqueKeys[kSmallest], uniqueKeys[right]);

    int storeIndex = left;
    for (int i = left; i <= right; ++i) {
        if (freqMap[uniqueKeys[i]] < pivotFrequency) {
            std::swap(uniqueKeys[i], uniqueKeys[storeIndex]);
            storeIndex += 1;
        }
    }
    std::swap(uniqueKeys[right], uniqueKeys[storeIndex]);
    return storeIndex;
}

void quickselect(const int left, const int right, const int kSmallest,
    std::vector<int>& uniqueKeys, std::unordered_map<int, int>& freqMap)
{
    if (left == right) {
        return;
    }

    int pivotIndex = left + std::rand() % (right - left + 1);
    pivotIndex = partition(left, right, pivotIndex, uniqueKeys, freqMap);
    if (pivotIndex == kSmallest) {
        return;
    } else if (kSmallest < pivotIndex) {
        quickselect(left, pivotIndex - 1, kSmallest, uniqueKeys, freqMap);
    } else {
        quickselect(pivotIndex + 1, right, kSmallest, uniqueKeys, freqMap);
    }
}

std::vector<int> topKFrequent(std::vector<int>& numbers, const int k)
{
    std::unordered_map<int, int> freqMap;

    for (auto num : numbers) {
        freqMap[num]++;
    }

    size_t n = freqMap.size();
    std::vector<int> uniqueKeys {};
    for (auto p : freqMap) {
        uniqueKeys.push_back(p.first);
    }

    quickselect(0, n - 1, n - k, uniqueKeys, freqMap);
    std::vector<int> kFrequent(k);
    std::copy(uniqueKeys.begin() + n - k, uniqueKeys.end(), kFrequent.begin());

    return kFrequent;
}

int main()
{
    std::vector<int> numbers {3, 1, 4, 4, 5, 2, 6, 1};
    std::cout << "Numbers : ";
    print(numbers);

    std::cout << "---------------------------------------\n";
    int k = 2;
    std::cout << "Top "<< k << " frequent numbers : \n";

    std::vector<int> frequent = topKFrequent(numbers, k);
    print(frequent);

    std::cout << "=======================================\n";

    return 0;
}