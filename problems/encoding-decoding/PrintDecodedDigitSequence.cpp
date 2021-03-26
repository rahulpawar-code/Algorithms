// https://www.geeksforgeeks.org/print-all-possible-decodings-of-a-given-digit-sequence/

#include <iostream>
#include <string>
#include <vector>


void printVector(std::vector<std::string>& vector)
{
    for (auto str : vector) {
        std::cout << str << " ";
    }
    std::cout << "\n";
}

char getChar(int digit)
{
    return static_cast<char>(digit + 97);
}

std::vector<std::string> getDecoded(std::string str)
{
    if (str.size() == 0) {
        std::vector<std::string> res;
        res.push_back("");
        return res;
    }

    std::vector<std::string> output1 = getDecoded(str.substr(1));
    std::vector<std::string> output2 (0);

    int firstDigit = (str[0] - '0');
    int firstTwoDigits = 0;

    if (str.size() >= 2) {
        firstTwoDigits = (str[0] - '0') * 10 + str[1] - '0';
        if (firstTwoDigits >= 10 && firstTwoDigits <= 26) {
            output2 = getDecoded(str.substr(2));
        }
    }

    std::vector<std::string> output (output1.size() + output2.size());
    int k = 0;

    char ch = getChar(firstDigit);
    for (int i = 0; i < output1.size(); ++i) {
        output[i] = ch + output1[i];
        k++;
    }

    ch = getChar(firstTwoDigits);
    for (int i = 0; i < output2.size(); ++i) {
        output[k] = ch + output2[i];
        k++;
    }

    return output;
}

int main()
{
    std::string str = "1234";
    std::cout << "str : " << str << "\n";
    std::vector<std::string> output = getDecoded(str);
    printVector(output);

    std::cout << "=========================\n";

    str = "12121";
    std::cout << "str : " << str << "\n";
    output = getDecoded(str);
    printVector(output);

    std::cout << "=========================\n";

    str = "101";
    std::cout << "str : " << str << "\n";
    output = getDecoded(str);
    printVector(output);


    return 0;
}