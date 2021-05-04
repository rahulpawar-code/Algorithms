// Running Sum of 1d Array https://leetcode.com/problems/running-sum-of-1d-array/

#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <numeric>

void print(std::vector<int>& numbers)
{
    for (auto num : numbers) {
        std::cout << num << " ";
    }
}

std::vector<int> getRandomNumbers(int min, int max, int nums)
{
    std::srand(static_cast<unsigned>(std::time(nullptr)));
    std::rand();
    std::vector<int> numbers(nums);

    for (int i = 1; i <= nums; ++i) {
        numbers[i - 1] = min + (std::rand() % (max - min + 1));
    }

    return numbers;
}

std::vector<int> runningSum1(std::vector<int>& numbers)
{
    std::vector<int> rSum(numbers.size());
    rSum[0] = numbers[0];

    for (int i = 1; i < numbers.size(); i++) {
        rSum[i] = rSum[i - 1] + numbers[i];
    }

    return rSum;
}

std::vector<int> runningSum2(std::vector<int>& numbers)
{
    std::vector<int> rSum(numbers.size());
    std::partial_sum(numbers.begin(), numbers.end(), rSum.begin());

    return rSum;
}

std::vector<int> runningSum3(std::vector<int>& numbers)
{
    std::vector<int> rSum(numbers.size());
    rSum[0] = numbers[0];

    for (int i = 1; i < numbers.size(); i++) {
        rSum[i] = std::accumulate(numbers.begin(), numbers.begin() + i + 1, 0);
    }

    return rSum;
}

void test(std::vector<int>& numbers)
{
    std::cout << "Numbers : ";
    print(numbers);
    std::vector<int> rSum1 = runningSum1(numbers);
    std::cout << "\nRunning sums : \n";
    std::cout << "Using loop: \t    ";
    print(rSum1);
    std::cout << "\nUsing partial sum: ";
    std::vector<int> rSum2 = runningSum2(numbers);
    print(rSum2);
    std::cout << "\nUsing accumulate: ";
    std::vector<int> rSum3 = runningSum3(numbers);
    print(rSum3);
    std::cout << "\n==============================================\n";
}

int main()
{
    std::vector<int> numbers = getRandomNumbers(1, 100, 15);
    test(numbers);

    return 0;
}