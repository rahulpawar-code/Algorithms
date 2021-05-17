// Check if two string are interleaving of third https://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings/

#include <iostream>
#include <string>

bool isInterleaving(const std::string& a, const std::string& b, const std::string& c)
{
    if (a.size() + b.size() != c.size()) {
        return false;
    }

    int indexA = 0;
    int indexB = 0;
    int indexC = 0;

    while (indexC < c.size()) {
        if (indexA < a.size() && a[indexA] == c[indexC]) {
            indexA++;
        } else if (indexB < b.size() && b[indexB] == c[indexC]) {
            indexB++;
        } else {
            return false;
        }

        indexC++;
    }

    return true;
}

void test(const std::string& a, const std::string& b, const std::string& c)
{
    std::cout << c << " interleaved of " << a << " & " << b << " : ";
    std::cout << std::boolalpha << isInterleaving(a, b, c) << "\n";
}

int main()
{
    test("AB", "CD", "ACBG");
    test("AB", "CD", "ACBD");
    test("A", "CD", "ACBD");
    test("AB", "C", "ACBD");
    test("AB", "CD", "ACBDE");
    test("AAB", "AAC", "AACAAB");

    return 0;
}