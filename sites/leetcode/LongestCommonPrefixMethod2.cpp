// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

std::string longestCommonPrefix(std::vector<std::string>& strs)
{
    int minLength = strs[0].length();
    
    for (int i = 1; i < strs.size(); ++i) {
        minLength = std::min(minLength, static_cast<int>(strs[i].length()));
    }
    
    std::string result;
    for (int j = 0; j < minLength; ++j) {
        char current = strs[0][j];
        for (int i = 1; i < strs.size(); ++i) {
            if (strs[i][j] != current) {
                return result;
            }
        }
        result.push_back(current);
    }        
    
    return result;    
}

int main()
{
    std::vector<std::string> strs {"flower","flow","flight"};
    std::cout << "Longest Common Prefix : " << longestCommonPrefix(strs) << std::endl; 
    
    std::vector<std::string> strs2 {"dog", "racecar", "car"};
    std::cout << "Longest Common Prefix : " << longestCommonPrefix(strs2) << std::endl;    
}