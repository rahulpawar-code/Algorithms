// https://www.geeksforgeeks.org/stock-buy-sell/
// Max profit and 2nd max profit in stock buy and sell

#include <iostream>
#include <vector>
#include <queue>
#include <functional>
#include <climits>
#include <algorithm>

template <typename T>
void printQueue(T q)
{
    while(!q.empty()) {
        std::cout << q.top() << " ";
        q.pop();
    }
    std::cout << "\n";
}

void maxProfits(std::vector<int>& prices, const int topN)
{
    if (prices.size() < 2 || topN < 1) {
        return;
    }

    int n = prices.size();
    std::vector<int> profits(topN, INT_MIN);
    std::priority_queue<int, std::vector<int>, std::greater<int>> profitsQueue(profits.begin(), profits.end());

    int minCost = prices[0];
    int maxProfit = 0;
    int currentProfit = 0;

    for (int i = 0; i < n; ++i) {
        minCost = std::min(minCost, prices[i]);

        currentProfit = prices[i] - minCost;

        if (currentProfit > maxProfit) {
            maxProfit = currentProfit;
            if (currentProfit > profitsQueue.top()) {
                profitsQueue.pop();
                profitsQueue.push(currentProfit);
            }
        }
    }

    printQueue(profitsQueue);
}

int main()
{
    std::vector<int> prices {7, 1, 5, 3, 6, 4};
    int topN = 2;
    maxProfits(prices, 2);

    return 0;
}