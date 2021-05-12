// GeeksforGeeks https://www.geeksforgeeks.org/remove-characters-from-the-first-string-which-are-present-in-the-second-string/

#include <iostream>
#include <string>
#include <array>

const int SIZE = 256;

std::array<int, SIZE> getCharacterFrequency(const std::string& str)
{
    std::array<int, SIZE> count {};

    for (int i = 0; i < str.size(); ++i) {
        count[str[i]]++;
    }

    return count;
}

std::string removeMaskedCharacters(const std::string& str, const std::string& mask)
{
    std::array<int, SIZE> count = getCharacterFrequency(mask);
    std::string result = "";

    for (int i = 0; i < str.size(); ++i) {
        if (count[str[i]] == 0) {
            result.push_back(str[i]);
        }
    }

    return result;
}

void test(const std::string& str, const std::string& mask)
{
    std::cout << "String : " << str << "\nmask string : " << mask << "\n";
    std::cout << "After removing masked charcters : " <<
        removeMaskedCharacters(str, mask) << "\n";
}

int main()
{
    std::string str = "Hello World!! This is a C++ program";
    std::string mask = "odsam";
    test(str, mask);
    return 0;
}
