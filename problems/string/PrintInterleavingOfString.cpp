// Geeksforgeeks https://www.geeksforgeeks.org/print-all-interleavings-of-given-two-strings/

#include <iostream>
#include <string>

void printInterleavedStrings(const std::string& a, const std::string& b, std::string inter, int indexA, int indexB, int indexC)
{
    if (indexA > a.size() && indexB > b.size()) {
        return;
    }

    if (indexA == a.size() && indexB == b.size()) {
        std::cout << inter << "\n";
    }

    if (indexA < a.size()) {
        inter[indexC] = a[indexA];
        printInterleavedStrings(a, b, inter, indexA + 1, indexB, indexC + 1);
    }

    if (indexB < b.size()) {
        inter[indexC] = b[indexB];
        printInterleavedStrings(a, b, inter, indexA, indexB + 1, indexC + 1);
    }
}

void test(const std::string& a, const std::string& b)
{
    std::cout << "a : " << a << ", b : " << b;
    std::cout << "\nInterleaved string: \n";
    std::string inter (a + b);
    printInterleavedStrings(a, b, inter, 0, 0, 0);
    std::cout << "=============================\n";
}

int main()
{
    test("AB", "CD");
    return 0;
}