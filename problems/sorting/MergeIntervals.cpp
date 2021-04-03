// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/803/

#include <iostream>
#include <vector>
#include <deque>
#include <algorithm>

void print(std::vector<std::vector<int>>& intervals)
{
    for (auto rows : intervals) {
        std::cout << rows[0] << "," << rows[1] << "\n";
    }
}

std::vector<std::vector<int>> merge(std::vector<std::vector<int>>& intervals)
{
    if (intervals.empty()) {
        return {};
    }

    std::sort(intervals.begin(), intervals.end(), [](std::vector<int> a, std::vector<int> b) {
        return a[0] < b[0];
    });

    std::vector<std::vector<int>> merged;
    merged.push_back(intervals[0]);
    for (int i = 1; i < intervals.size(); ++i) {
        if (merged.back()[1] < intervals[i][0]) {
            merged.push_back(intervals[i]);
        } else {
            merged.back()[1] = std::max(merged.back()[1], intervals[i][1]);
        }
    }

    return merged;
}

void test(std::vector<std::vector<int>>& intervals)
{
    std::cout << "Before merge : \n";
    print(intervals);
    std::vector<std::vector<int>> merged = merge(intervals);
    std::cout << "After merge : \n";
    print(merged);
    std::cout << "=================================\n";
}

int main()
{
    std::vector<std::vector<int>> intervals {{13,14},{15,18},{1,4},
                                {4,5},{1,3},{2,6},{8,10},{12,13}};
    test(intervals);
    return 0;
}
