// https://www.geeksforgeeks.org/maximum-length-possible-by-cutting-n-given-woods-into-at-least-k-pieces/

#include <iostream>
#include <algorithm>
#include <vector>


bool isValid(std::vector<int>& wood, const int K,
                const int len)
{
    int count = 0;

    for (int i = 0; i < wood.size(); ++i) {
        count += wood[i] / len;
    }

    return count >= K;
}

int findMaxLengthCut(std::vector<int>& wood, int K)
{
    if (wood.size() == 0) {
        return -1;
    }

    int left = 1;
    int right = *max_element(wood.begin(), wood.end());


    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (isValid(wood, K, mid)) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }


    return left;
}

int main()
{
    std::vector<int> wood {5, 9, 7, 10, 3, 8, 11, 6};
    int K = 5;

    int maxLength = findMaxLengthCut(wood, K);
    std::cout << "Max length cut would be : " << maxLength << "\n";

    return 0;
}
