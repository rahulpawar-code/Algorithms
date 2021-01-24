// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/

#include <iostream>


bool isAnagram(std::string s, std::string t) {
    if (s.size() != t.size()) {
        return false;
    }
    
    int table[256] {0};
    
    for (int i {0}; i < s.size(); ++i) {
        table[s[i]]++;
    }
    
    for (int i {0}; i < s.size(); ++i) {
        if (--table[t[i]] < 0) {
            return false;
        }
    }
        
    return true;    
}

int main()
{
    std::string s = "anagram";
    std::string t = "nagaram";
    std::cout << s << " and " << t << " : " << std::boolalpha << isAnagram(s, t) << std::endl;
    
    s = "rat";
    t = "car";
    std::cout << s << " and " << t << " : " << std::boolalpha << isAnagram(s, t) << std::endl;
    
    return 0;
}
