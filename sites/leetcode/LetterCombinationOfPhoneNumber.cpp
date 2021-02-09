// Letter Combinations of a Phone Number https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/793/

#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>

static const std::string numpadMap[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

void letterCombinationsRec(const std::string& digits, std::string tempString,
    std::vector<std::string>& combination)
{
    if (digits.length() == 0) {
        combination.push_back(tempString);
    } else {
        char nextDigit = digits.front();
        std::string letters = numpadMap[nextDigit - '0'];
        for (int i = 0; i < letters.length(); ++i) {
            char letter = letters[i];
            letterCombinationsRec(digits.substr(1), tempString + letter, combination);
        }
    }
}

std::vector<std::string> letterCombinationsRec(const std::string& digits)
{
    if (digits.length() == 0) {
        return {};
    }

    std::vector<std::string> combination;
    letterCombinationsRec(digits, "" , combination);
    return combination;
}

std::vector<std::string> letterCombinationsIterative(const std::string& digits)
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

void print(std::vector<std::string>& combination)
{
    for (auto s : combination) {
        std::cout << s << " ";
    }
    std::cout << "\n";
}

int main()
{
    const std::string digits("29");
    std::vector<std::string> combinationIter = letterCombinationsIterative(digits);
    std::cout << "Letter combination for digits (iterative) " << digits << " : ";
    print(combinationIter);
    std::vector<std::string> combinationRec = letterCombinationsRec(digits);
    std::cout << "Letter combination for digits (recursive) " << digits << " : ";
    print(combinationRec);

    return 0;
}