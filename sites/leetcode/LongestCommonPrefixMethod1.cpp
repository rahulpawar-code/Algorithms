// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/

#include <iostream>
#include <string>
#include <vector>

std::string commonprefix(const std::string& a, const std::string& b)
{
    int i = 0, j = 0;
    
    while (i < a.length() && j < b.length())
    {
        if (a[i] != b[j])
        {
            break;
        }
        
        i++;
        j++;
    }
    
    return a.substr(0, i);
}

std::string longestCommonPrefix(std::vector<std::string>& strs)
{
    std::string &prefix = strs[0];
    for (int i = 1; i < strs.size(); ++i)
    {
        prefix = commonprefix(prefix, strs[i]);
    }
    return prefix;    
}

int main()
{
    std::vector<std::string> strs {"flower","flow","flight"};
    std::cout << "Longest Common Prefix : " << longestCommonPrefix(strs) << std::endl; 
    
    std::vector<std::string> strs2 {"dog", "racecar", "car"};
    std::cout << "Longest Common Prefix : " << longestCommonPrefix(strs2) << std::endl;    
}