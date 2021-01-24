// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/

#include <iostream>
#include <string>

bool isPalindrome(std::string s) {
    int i = 0;
    int j = s.size();
    
    while (i < j) {
        if (!std::isalnum(s[i])) {
            i++;
        } else if (!std::isalnum(s[j])) {
            j--;
        } else if (std::tolower(s[i++]) != std::tolower(s[j--])) {
            return false;
        } 
    }
    
    return true;    
}

int main()
{
    std::string s = "A man, a plan, a canal: Panama";
    std::cout << s << " : " << std::boolalpha << isPalindrome(s) << std::endl;
    
    s = "race a car";
    std::cout << s << " : " << std::boolalpha << isPalindrome(s) << std::endl;
    
    s = "0P";
    std::cout << s << " : " << std::boolalpha << isPalindrome(s) << std::endl;
    
    return 0;
}
