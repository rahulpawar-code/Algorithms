// https://www.techiedelight.com/isomorphic-strings/
// https://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/

#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>

bool isIsomorphic(std::string X, std::string Y)
{
    if (X.size() != Y.size()) {
        return false;
    }

    std::unordered_map<char, char> map;
    std::unordered_set<char> set;

    for (int i = 0; i < X.size(); ++i) {
        char x = X[i];
        char y = Y[i];

        if (map.find(x) != map.end()) {
            if (map[x] != y) {
                return false;
            }
        } else {
            if (set.find(y) != set.end()) {
                return false;
            }

            set.insert(y);
            map[x] = y;
        }
    }

    return true;
}

int main()
{
    std::string X = "ACAB";
    std::string Y = "XCXY";

    std::cout << X << " and " << Y << " are isomorphic? " << std::boolalpha << isIsomorphic(X, Y) << "\n";

    X = "banana";
    Y = "cololo";
    std::cout << X << " and " << Y << " are isomorphic? " << std::boolalpha << isIsomorphic(X, Y) << "\n";

    return 0;
}