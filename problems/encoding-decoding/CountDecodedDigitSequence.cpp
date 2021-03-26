// https://www.geeksforgeeks.org/print-all-possible-decodings-of-a-given-digit-sequence/

#include <iostream>
#include <string>

int countDecoding(std::string digits, int n)
{
    if (n == 0 || n == 1) {
        return 1;
    }

    int count = 0;

    if (digits[n - 1] > '0') {
        count = countDecoding(digits, n - 1);
    }

    if ((digits[n - 2] == '1') || (digits[n - 2] == '2' && digits[n - 1] < '7')) {
        count += countDecoding(digits, n - 2);
    }

    return count;
}

int countDecodingDP(std::string digits)
{
    int n = digits.size();
    int count[n + 1];
    count[0] = 1;
    count[1] = 1;

    for (int i = 2; i <= n; ++i) {
        count[i] = 0;

        if (digits[i - 1] > '0') {
            count[i] = count[i - 1];
        }

        if ((digits[n - 2] == '1') || (digits[n - 2] == '2' && digits[n - 1] < '7')) {
            count[i] += count[i - 2];
        }
    }

    return count[n];
}

int main()
{
    std::string str = "1234";
    std::cout << "str : " << str << "\n";
    std::cout << "Recursive : " << countDecoding(str, str.size()) << "\n";
    std::cout << "DP : " << countDecodingDP(str) << "\n";

    std::cout << "=======================================\n";

    str = "12121";
    std::cout << "str : " << str << "\n";
    std::cout << "Recursive : " << countDecoding(str, str.size()) << "\n";
    std::cout << "DP : " << countDecodingDP(str) << "\n";

    return 0;
}