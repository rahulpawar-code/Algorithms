// https://www.geeksforgeeks.org/spell-checker-using-trie/

#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>

const int ALPHA = 256;

class Trie
{
private:
    class TrieNode
    {
    public:
        TrieNode* child[ALPHA];
        bool isEnd;

        TrieNode() : isEnd(false)
        {
            for (int i = 0; i < ALPHA; ++i) {
                child[i] = nullptr;
            }
        }
    };

    TrieNode* root;

    bool isTerminalNode(TrieNode* node)
    {
        for (int i = 0; i < ALPHA; ++i) {
            if (node->child[i] != nullptr) {
                return false;
            }
        }
        return true;
    }

    void searchRec(TrieNode* node, std::string prefix, std::vector<std::string>& list)
    {
        if (node->isEnd) {
            list.push_back(prefix);
        }

        if (isTerminalNode(node)) {
            return;
        }

        for (int i = 0; i < ALPHA; ++i) {
            if (node->child[i] != nullptr) {
                char c = static_cast<char>(i);
                searchRec(node->child[i], prefix + c, list);
            }
        }
    }

public:
    Trie() : root(nullptr) { }

    void insert(std::string key)
    {
        if (key.size() == 0) {
            return;
        }

        if (root == nullptr) {
            root = new TrieNode();
        }

        TrieNode* temp = root;

        for (int i = 0; i < key.size(); ++i) {
            char c = key[i];
            if (temp->child[c] == nullptr) {
                temp->child[c] = new TrieNode();
            }
            temp = temp->child[c];
        }

        temp->isEnd = true;
    }

    bool search(std::string key)
    {
        if (key.size() == 0 || root == nullptr) {
            return false;
        }

        TrieNode* temp = root;
        for (int i = 0; i < key.size(); ++i) {
            char c = key[i];
            if (temp->child[c] == nullptr) {
                return false;
            }
            temp = temp->child[c];
        }
        return temp->isEnd;
    }

    std::vector<std::string> suggestions(std::string key)
    {
        if (key.size() == 0 || root == nullptr) {
            return {};
        }

        TrieNode* temp = root;
        for (int i = 0; i < key.size(); ++i) {
            char c = key[i];
            if (temp->child[c] == nullptr) {
                return {};
            }
            temp = temp->child[c];
        }

        std::vector<std::string> list;

        if (temp->isEnd || isTerminalNode(temp)) {
            list.push_back(key);
        } else {
            std::string prefix = key;
            searchRec(temp, key, list);
        }
        return list;
    }

    void construct(std::vector<std::string> words)
    {
        for (auto word : words) {
            insert(word);
        }
    }
};


void print(std::vector<std::string>& words)
{
    for (auto word : words) {
        std::cout << word << " ";
    }
    std::cout << "\n";
}

int main()
{
    std::vector<std::string> words { "gee", "geeks", "ape",
                           "apple", "geeksforgeeks" };

    Trie trie;
    trie.construct(words);
    std::string key = "geeks";
    bool present = trie.search(key);
    std::cout << "Is " << key << " present ? " << std::boolalpha << present << "\n";

    if (!present) {
        std::vector<std::string> suggest = trie.suggestions(key);
        if (suggest.size() != 0) {
            std::cout << "Suggestions for " << key << ": ";
            print(suggest);
        } else {
            std::cout << "No suggestions found for " << key << "\n";
        }
    }

    std::cout << "=======================================\n";
    key = "geek";
    present = trie.search(key);
    std::cout << "Is " << key << " present ? " << std::boolalpha << present << "\n";

    if (!present) {
        std::vector<std::string> suggest = trie.suggestions(key);
        if (suggest.size() != 0) {
            std::cout << "Suggestions for " << key << ": ";
            print(suggest);
        } else {
            std::cout << "No suggestions found for " << key << "\n";
        }
    }

    return 0;
}