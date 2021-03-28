// https://www.geeksforgeeks.org/merge-transactions-in-bank-sheets-in-the-order-of-their-occurrence-such-that-their-sum-remains-positive/

#include <iostream>
#include <queue>
#include <vector>

class Node
{
public:
    int value;
    int i;
    int j;

    Node(int v, int a, int b) : value(v), i(a), j(b) {}
};

bool validate(std::vector<int>& transaction)
{
    if (transaction.size() == 0) {
        return false;
    }

    int sum = 0;
    for (auto t : transaction) {
        sum += t;
        if (sum < 0) {
            return false;
        }
    }

    return true;
}

void print(std::vector<int> transaction)
{
    for (auto t : transaction) {
        std::cout << t << " ";
    }
    std::cout << "\n";
}

std::vector<int> mergeSheet(std::vector<std::vector<int>>& transactions)
{
    std::vector<int> merged;
    int n = transactions.size();

    auto cmp = [](const Node& a, const Node& b) { return a.value < b.value; };
    std::priority_queue<Node, std::vector<Node>, decltype(cmp)> maxq(cmp);

    for (int i = 0; i < n; ++i) {
        Node node(transactions[i][0], i, 0);
        maxq.push(node);
    }

    while (!maxq.empty()) {
        Node current = maxq.top();
        maxq.pop();

        int value = current.value;
        int i = current.i;
        int j = current.j;

        merged.push_back(current.value);

        if (j < transactions[i].size() - 1) {
            Node node(transactions[i][j + 1], i, j + 1);
            maxq.push(node);
        }
    }

    return merged;
}

int main()
{
    // varying length transactions
    std::vector<std::vector<int>> transactions{{100, 400, -1000, -500},
                                               {-300, 2000, -500},
                                               { 823, 652, 580, -151, -866, -300, -460, 35, 677, 704, 282 },
                                               { -159, -402,  78, -58, 504, 836, 908, 665, -404, -633, -948 }
                                               };
    std::vector<int> mergedTransaction = mergeSheet(transactions);
    std::cout << "Are merged transaction valid : " << std::boolalpha
                << validate(mergedTransaction) <<"\n";
    print(mergedTransaction);

    return 0;
}
