// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/

#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>

class TrieNode
{
public:
    bool isLeaf;
    std::unordered_map<char, TrieNode*> next;
    
    TrieNode() {
        isLeaf = false;
    }
};

class Trie
{
private:
    TrieNode* root;

public:    
    Trie() : root { nullptr }
    { }
    
    void insert(std::string const& str) {
        if (root == nullptr) {
            root = new TrieNode();
        }
        
        TrieNode* current = root;
        
        for (char ch : str) {
            if (current->next.find(ch) == current->next.end()) {
                current->next[ch] = new TrieNode();
            }                
            
            current = current->next[ch];
        }
        current->isLeaf = true;
    }
    
    std::string findPrefix() {
        if (root == nullptr) {
            return "";
        }
        TrieNode* current = root;
        std::string lcp;
        while (current != nullptr && current->isLeaf != true && current->next.size() == 1) {
            auto it = current->next.begin();
            lcp += it->first;
            current = it->second;
        }
        return lcp;
    }
};

std::string longestCommonPrefix(std::vector<std::string>& strs)
{
    Trie trie;
    
    for (auto& str : strs) {
        trie.insert(str);
    }
    
     
    std::string result = trie.findPrefix();
    return result;    
}

int main()
{
    std::vector<std::string> strs {"flower","flow","flight"};
    std::cout << "Longest Common Prefix : " << longestCommonPrefix(strs) << std::endl; 
    
    std::vector<std::string> strs2 {"code", "coder", "coding", "codable", "codec", "codecs", "coded",
		"codeless", "codependence", "codependency", "codependent",
		"codependents", "codes", "codesign", "codesigned", "codeveloped",
		"codeveloper", "codex", "codify", "codiscovered", "codrive"};
    std::cout << "Longest Common Prefix : " << longestCommonPrefix(strs2) << std::endl;    
}