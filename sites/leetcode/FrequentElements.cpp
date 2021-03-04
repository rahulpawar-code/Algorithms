// Top K frequent elements
// https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/799/

#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
#include <unordered_map>
#include <queue>

using my_pair_t = std::pair<int, int>;
using my_container_t = std::vector<my_pair_t>;

struct sCompare {
    bool operator()(std::pair<int, int> p1, std::pair<int, int> p2)
    {
        if (p1.second == p2.second)
            return p1.first < p2.first;

        return p1.second < p2.second;
    }
};

bool compare(std::pair<int, int> p1, std::pair<int, int> p2)
{
    if (p1.second == p2.second) {
        return p1.first > p2.first;
    }
    return p1.second > p2.second;
}

std::vector<int> topKFrequentUsingSorting(std::vector<int>& numbers, const int k)
{
    std::unordered_map<int, int> freqMap;

    for (auto num : numbers) {
        freqMap[num]++;
    }

    std::vector<std::pair<int, int>> freqVector (freqMap.begin(), freqMap.end());
    std::sort(freqVector.begin(), freqVector.end(), compare);
    std::vector<int> kFrequent {};

    for (int i = 0; i < k; ++i) {
        kFrequent.push_back(freqVector[i].first);
    }

    return kFrequent;
}

std::vector<int> topKFrequentUsingPriorityQueue(std::vector<int>& numbers, const int k)
{
    std::unordered_map<int, int> freqMap;

    for (auto num : numbers) {
        freqMap[num]++;
    }

    std::priority_queue<my_pair_t, my_container_t, sCompare>
        queue(freqMap.begin(), freqMap.end());
    std::vector<int> kFrequent {};

    for (int i = 0; i < k; ++i) {
        kFrequent.push_back(queue.top().first);
        queue.pop();
    }

    return kFrequent;
}

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

int main()
{
    std::vector<int> numbers {3, 1, 4, 4, 5, 2, 6, 1};
    std::cout << "Numbers : ";
    print(numbers);

    std::cout << "---------------------------------------\n";
    int k = 2;
    std::cout << "Top "<< k << " frequent numbers : \n";

    std::vector<int> frequent = topKFrequentUsingSorting(numbers, k);
    std::cout << "Using hashmap and sorting : ";
    print(frequent);

    frequent = topKFrequentUsingPriorityQueue(numbers, k);
    std::cout << "Using hashmap and priority queue : ";
    print(frequent);

    std::cout << "=======================================\n";

    return 0;
}