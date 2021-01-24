// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/

#include <iostream>
#include <climits>

int reverse(int x)
{
    int reverse = 0;
    
    while (x != 0) {
        int pop = x % 10;
        
        if (reverse > INT_MAX / 10 || (reverse == INT_MAX / 10 && pop  > 7)) {
            return 0;
        }
        
        if (reverse < INT_MIN / 10 || (reverse == INT_MIN / 10 && pop < - 8)) {
            return 0;
        }
        
        reverse = reverse * 10 + pop;
        x = x / 10;
    }
    return reverse;
}


int main()
{
    std::cout << reverse(123) << std::endl;
    std::cout << reverse(-123) << std::endl;
    std::cout << reverse(120) << std::endl;
    std::cout << reverse(0) << std::endl;
    std::cout << reverse(100) << std::endl;
    std::cout << reverse(1534236469) << std::endl;
    
    return 0;
}