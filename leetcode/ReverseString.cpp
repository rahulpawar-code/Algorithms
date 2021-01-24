// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/

#include <iostream>
#include <vector>
#include <algorithm>

void reverseString(std::vector<char>& s)
{
    int n = s.size();
    for(int i = 0; i < n/2; i++) {
        std::swap(s[i], s[n - 1 - i]);
    }
}

void printVector(std::vector<char>& s)
{
    for (char c : s) {
        std::cout << c << " ";
    }
    std::cout << "\n"; 
}

int main()
{
    std::vector<char> s {'h', 'e', 'l', 'l', 'o'};
    printVector(s);
    reverseString(s);
    printVector(s);
    return 0;
}
