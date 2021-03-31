// Majority Element Brute Force, Using Map, Boyer-Moore Voting
// Techie Delight https://www.techiedelight.com/find-majority-element-in-an-array-boyer-moore-majority-vote-algorithm/
// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/824/

#include <iostream>
#include <vector>
#include <climits>
#include <unordered_map>

void print(std::vector<int> const& numbers)
{
    for (auto n : numbers) {
        std::cout << n << " ";
    }
}

int bruteForceMethod(std::vector<int> const& numbers)
{
    int n = numbers.size();

    for (int i = 0; i <= n / 2; ++i) {
        int count = 1;
        for (int j = i + 1; j < n; ++j) {
            if (numbers[j] == numbers[i]) {
                count++;
            }
        }
        if (count > n / 2) {
            return numbers[i];
        }
    }

    return INT_MIN;
}

int hashmapMethod(std::vector<int> const& numbers)
{
    int n = numbers.size();
    std::unordered_map<int, int> map;

    for (auto num : numbers) {
        map[num]++;
    }

    for (auto pair : map) {
        if (pair.second > n / 2) {
            return pair.first;
        }
    }

    return INT_MIN;
}

int votingMethod(std::vector<int> const& numbers)
{
    int majority = INT_MIN;
    int counter = 0;

    for (int i = 0 ; i < numbers.size(); ++i) {
        if (counter == 0) {
            majority = numbers[i];
            counter = 1;
        } else if (majority == numbers[i]) {
            counter++;
        } else {
            counter--;
        }
    }

    return majority;
}

void test(std::vector<int> const& num)
{
    std::cout << "Numbers : ";
    print(num);
    std::cout << "\nMajority Element: " << "\n";
    std::cout << "Brute force method : " << bruteForceMethod(num) << "\n";
    std::cout << "Using hashamp : " << hashmapMethod(num) << "\n";
    std::cout << "Using Boyer-Moore voting method : " << votingMethod(num) << "\n";
}

int main()
{
    std::vector<int> num1 {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
    test(num1);
    std::cout << "\n======================================\n";

    std::vector<int> num2 {1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2};
    test(num2);
    std::cout << "\n======================================\n";

    std::vector<int> num3 {2, 2, 1, 1, 1, 2, 2, 1, 1, 1};
    test(num3);
    std::cout << "\n======================================\n";

    return 0;
}