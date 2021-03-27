// https://www.geeksforgeeks.org/find-the-nth-row-in-pascals-triangle/

#include <iostream>
#include <vector>

template <typename T>
void print(std::vector<T>& items)
{
    if (items.size() == 0) {
        return;
    }

    for (auto item : items) {
        std::cout << item << " ";
    }
    std::cout << "\n";
}

std::vector<int> generatePascalTriangleRec(int row)
{
    std::vector<int> currentRow;
    currentRow.push_back(1);

    if (row == 0) {
        return currentRow;
    }

    std::vector<int> previousRow = generatePascalTriangleRec(row - 1);

    for (int i = 1; i < previousRow.size(); ++i) {
        currentRow.push_back(previousRow[i - 1] + previousRow[i]);
    }

    currentRow.push_back(1);

    return currentRow;
}

std::vector<int> generatePascalTriangleIter(int row)
{
    int previous = 1;
    std::vector<int> currentRow;
    currentRow.push_back(1);

    for (int i = 1; i <= row; ++i) {
        int current = previous * (row - i + 1) / i;
        currentRow.push_back(current);
        previous = current;
    }
    return currentRow;
}

int main()
{
    int n = 10;

    std::cout << "Recursive\n";
    for (int i = 0; i < n; ++i) {
        std::cout << "Row " << i << " : ";
        std::vector<int> numbers = generatePascalTriangleRec(i);
        print(numbers);
    }

    std::cout << "===============================\n";
    std::cout << "Iterative\n";
    for (int i = 0; i < n; ++i) {
        std::cout << "Row " << i << " : ";
        std::vector<int> numbers = generatePascalTriangleIter(i);
        print(numbers);
    }
}