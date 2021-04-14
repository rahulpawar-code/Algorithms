// Techie delight https://www.techiedelight.com/longest-common-subsequence/

#include <string>
#include <iostream>
#include <unordered_map>
#include <vector>

const int maxM = 100;
const int maxN = 100;

std::string getLCSString(const std::string X, const std::string Y, int m, int n, int lookup[][maxN])
{
    if (m == 0 || n == 0) {
        return "";
    }

    if (X[m - 1] == Y[n - 1]) {
        return getLCSString(X, Y, m - 1, n - 1, lookup) + X[m - 1];
    }
    if (lookup[m - 1][n] > lookup[m][n - 1]) {
        return getLCSString(X, Y, m - 1, n, lookup);
    } else {
        return getLCSString(X, Y, m, n - 1, lookup);
    }
}

std::string getLCS(const std::string X, const std::string Y)
{
    int m = X.size();
    int n = Y.size();
    int lookup[maxM][maxN];

    for (int i = 0; i <= m; ++i) {
        for (int j = 0; j <= n; ++j) {
            if (i == 0 || j == 0) {
                lookup[i][j] = 0;
            } else if (X[i - 1] == Y[j - 1]) {
                lookup[i][j] = 1 + lookup[i - 1][j - 1];
            } else {
                lookup[i][j] = std::max(lookup[i][j - 1], lookup[i - 1][j]);
            }
        }
    }
    std::string lcs = getLCSString(X, Y, m, n, lookup);
    return lcs;
}

int spaceOptimizedHelp(const std::string X, const std::string Y)
{
    int m = X.size();
    int n = Y.size();
    int lookup[n + 1];

    for (int i = 0; i <= m; ++i) {
        int previous = lookup[0];
        for (int j = 0; j <= n; ++j) {
            int backup = lookup[j];
            if (i == 0 || j == 0) {
                lookup[j] = 0;
            } else if (X[i - 1] == Y[j - 1]) {
                lookup[j] = 1 + previous;
            } else {
                lookup[j] = std::max(lookup[j], lookup[j - 1]);
            }
            previous = backup;
        }
    }

    return lookup[n];
}

int spaceOptimized(const std::string X, const std::string Y)
{
    if (X.size() < Y.size()) {
        return spaceOptimizedHelp(X , Y);
    } else {
        return spaceOptimizedHelp(Y, X);
    }
}

int botomUp(const std::string X, const std::string Y)
{
    int m = X.size();
    int n = Y.size();
    int lookup[m + 1][n + 1];

    for (int i = 0; i <= m; ++i) {
        for (int j = 0; j <= n; ++j) {
            if (i == 0 || j == 0) {
                lookup[i][j] = 0;
            } else if (X[i - 1] == Y[j - 1]) {
                lookup[i][j] = 1 + lookup[i - 1][j - 1];
            } else {
                lookup[i][j] = std::max(lookup[i][j - 1], lookup[i - 1][j]);
            }
        }
    }

    return lookup[m][n];
}

int memoization(const std::string X, const std::string Y, int m, int n,
    std::unordered_map<std::string, int>& map)
{
    if (m == 0 || n == 0) {
        return 0;
    }

    std::string key = m + " | " + n;
    if (map.find(key) == map.end()) {
        if (X[m - 1] == Y[n - 1]) {
            map[key] = 1 + memoization(X, Y, m - 1, n - 1, map);
        } else {
            map[key] = std::max(memoization(X, Y, m - 1, n, map),
                                memoization(X, Y, m , n - 1, map));
        }
    }

    return map[key];
}


int memoization(const std::string X, const std::string Y)
{
    std::unordered_map<std::string, int> map;
    return memoization(X, Y, X.size(), Y.size(), map);
}

int kniveRecursion(const std::string X, const std::string Y, int m, int n)
{
    if (m == 0 || n == 0) {
        return 0;
    }

    if (X[m - 1] == Y[n - 1]) {
        return 1 + kniveRecursion(X, Y, m - 1, n - 1);
    }

    return std::max(kniveRecursion(X, Y, m - 1, n), kniveRecursion(X, Y, m, n - 1));
}

int kniveRecursion(const std::string X, const std::string Y)
{
    return kniveRecursion(X, Y, X.size(), Y.size());
}

void test(const std::string X, const std::string Y)
{
    std::cout << "X : " << X <<"\nY : " << Y;
    std::cout << "\nLength of LCS using knive recursion : " << kniveRecursion(X, Y);
    std::cout << "\nLength of LCS using using memozation : " << memoization(X, Y);
    std::cout << "\nLength of LCS using using bottom up : " << botomUp(X, Y);
    std::cout << "\nLength of LCS using space optimized : " << spaceOptimized(X, Y);
    std::cout << "\nLCS string : " << getLCS(X, Y);
    std::cout << "\n=======================================\n";
}

int main()
{
    std::string X = "ABCBDAB";
    std::string Y = "BDCABA";
    test(X, Y);

    return 0;
}
