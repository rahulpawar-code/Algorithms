// Letter Combinations of a Phone Number https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/793/

#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>

static const std::string numpadMap[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

void letterCombinationsRec(const std::string digits, int digitIndex,
    int digitStringIndex, std::string tempString, std::vector<std::string> combination)
{
    if (digitIndex == digits.size()) {
        combination.push_back(tempString);
        return;
    }
    if (digitStringIndex == numpadMap[digitIndex].size()) {
        letterCombinationsRec(digits, digitIndex++, 0, tempString, combination);
        return;
    } else {
        int num = digits[digitIndex] - '0';
        tempString += numpadMap[num][digitIndex];
        letterCombinationsRec(digits, digitIndex, digitStringIndex++, tempString, combination);
        return;
    }        
}

std::vector<std::string> letterCombinations(const std::string digits)
{
    std::vector<std::string> combination;
    if (digits == "") {
        return combination;
    }

    letterCombinationsRec(digits, 0, 0, "", combination);
    return combination;
}

std::vector<std::string> letterCombinationsIterative(const std::string digits)
{
    if (digits.empty()) {
        return {};
    }
    
    std::vector<std::string> result;
    result.push_back("");
    
    for (auto digit : digits) {
        std::vector<std::string> temp;
        for (auto candidate : numpadMap[digit - '0']) {
            for (auto c : result) {
                temp.push_back(c + candidate);
            }
        }
        result.swap(temp);
    }
    return result;
}

void print(std::vector<std::string> combination)
{
    for (auto s : combination) {
        std::cout << s << " ";
    }
    std::cout << "\n";
}

int main()
{
    std::string digits("23");
    std::vector<std::string> combination = letterCombinationsIterative(digits);
    std::cout << "Letter combination for digits (iterative) " << digits << " : ";
    print(combination);
    return 0;
}