// leetcode https://null00.medium.com/leetcode-meeting-rooms-ii-67094c412b90

#include <iostream>
#include <vector>
#include <queue>
#include <utility>
#include <algorithm>

using pair_t = std::pair<int, int>;

void print(const std::vector<pair_t>& intervals)
{
    for (auto interval : intervals) {
        std::cout << "{" << interval.first << "," << interval.second << "}  ";
    }
}

int minMeetingRooms(std::vector<pair_t>& intervals)
{
    std::sort(intervals.begin(), intervals.end());
    auto cmp = [](const pair_t& a, const pair_t& b){
        return a.second > b.second;
    };

    std::priority_queue<pair_t, std::vector<pair_t>, decltype(cmp)> pq(cmp);

    int minRooms = 0;
    for (auto interval : intervals) {
        if (!pq.empty() && pq.top().second <= interval.first) {
            pq.pop();
        }
        pq.push(interval);
        minRooms = std::max(minRooms, static_cast<int>(pq.size()));
    }

    return minRooms;
}

void test(std::vector<pair_t>& intervals)
{
    std::cout << "Intervals : ";
    print(intervals);
    std::cout << "\n";
    std::cout << "Min meeting rooms required : " << minMeetingRooms(intervals) << "\n";
    std::cout << "============================================\n";
}

int main()
{
    std::vector<pair_t> intervals {{15, 19}, {0, 10}, {35, 40}, {0, 30}, {5, 10}, {15, 20}};
    test(intervals);
    std::vector<pair_t> intervals1{};
    test(intervals1);
    return 0;
}
