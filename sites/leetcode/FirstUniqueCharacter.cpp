// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/

#include <iostream>
#include <unordered_map>

int firstUniqueCharMethod1(std::string s)
{
    std::unordered_map<char, int> map;
    for (auto &c: s) {
        map[c]++;
    }
    
    for (int i = 0 ; i < s.size(); ++i) {
        if (map[s[i]] == 1) {
            return i;
        }
    }
    
    return -1;
}    

int firstUniqueCharMethod2(std::string s)
{
    std::unordered_map<char, std::pair<int, int>> map;
    int index = s.size();
    for (int i = 0; i < s.size(); ++i) {
        map[s[i]].first++;
        map[s[i]].second = i;
    }
    
    for (auto &p : map) {
        if (p.second.first == 1) {
            index = std::min(index, p.second.second);
        }
    }
    
    return (index == s.size()) ? -1 : index;
}

int main()
{
    std::string s = "leetcode";
    std::cout << firstUniqueCharMethod1(s) << std::endl;
    std::cout << firstUniqueCharMethod2(s) << std::endl;
    
    s = "loveleetcode";
    std::cout << firstUniqueCharMethod1(s) << std::endl;
    std::cout << firstUniqueCharMethod2(s) << std::endl;
    
    return 0;
}