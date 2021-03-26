// https://www.techiedelight.com/find-first-non-repeating-character-string-one-traversal/

#include <iostream>
#include <string>
#include <unordered_map>

int findFirstUniqueChar(std::string& str)
{
    if (str.size() <= 1) {
        return str.size() - 1;
    }

    std::unordered_map<char, std::pair<int, int>> map;
    int n = str.size();

    for (int i = 0; i < n; ++i) {
        map[str[i]].first++;
        map[str[i]].second = i;
    }

    int minIndex = str.size();

    for (auto it : map) {
        int frequency = it.second.first;
        int index = it.second.second;

        if (frequency == 1 && index < minIndex) {
            minIndex = index;
        }
    }

    return minIndex;
}

int main()
{
    std::string str = "ABCDBAGHCDG";
    int index = findFirstUniqueChar(str);

    if (index < 0 || index == str.size()) {
        std::cout << "No unique charachter found\n";
    } else {
        std::cout << "The first non-repeating character in the string is : " << str[index] << "\n";
    }

    return 0;
}
