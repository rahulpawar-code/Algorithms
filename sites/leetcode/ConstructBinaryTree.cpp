// Construct Binary Tree from Preorder and Inorder Traversal
// https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/788/

#include <iostream>
#include <unordered_map>
#include <vector>

struct Node
{
public:
    int key;
    Node* left;
    Node* right;

    Node() : key{0}, left{nullptr}, right{right} { }
    Node(int k) : key{k}, left{nullptr}, right{nullptr} { }
};

class Tree
{
private:
    Node* root;
    void destroyTree(Node* node);
    void inorder(Node* node, std::vector<int>& traversal);
    void preorder(Node* node, std::vector<int>& traversal);
    Node* constructTree(std::vector<int>& inorder, std::vector<int>& preorder,
                        int start, int end, int& index, std::unordered_map<int,int>& indexMap);

public:
    Tree();
    ~Tree();
    std::vector<int> inorder();
    std::vector<int> preorder();
    void constructTree(std::vector<int>& inorder, std::vector<int>& preorder);
};

Tree::Tree() : root{nullptr} { }

Tree::~Tree()
{
    if (root == nullptr) {
        return;
    }
    destroyTree(root);
}

void Tree::destroyTree(Node* node)
{
    if (node != nullptr) {
        destroyTree(node->left);
        destroyTree(node->right);
        delete node;
    }
}

void Tree::inorder(Node* node, std::vector<int>& traversal)
{
    if (node == nullptr) {
        return;
    }
    inorder(node->left, traversal);
    traversal.push_back(node->key);
    inorder(node->right, traversal);
}

void Tree::preorder(Node* node, std::vector<int>& traversal)
{
    if (node == nullptr) {
        return;
    }
    traversal.push_back(node->key);
    preorder(node->left, traversal);
    preorder(node->right, traversal);
}

std::vector<int> Tree::inorder()
{
    std::vector<int> traversal;
    inorder(root, traversal);
    return traversal;
}

std::vector<int> Tree::preorder()
{
    std::vector<int> traversal;
    preorder(root, traversal);
    return traversal;
}

Node* Tree::constructTree(std::vector<int>& inorder, std::vector<int>& preorder,
    int start, int end, int& index, std::unordered_map<int,int>& indexMap)
{
    if (start > end) {
        return nullptr;
    }

    Node* node = new Node(preorder[index++]);
    int iIndex = indexMap[node->key];
    node->left = constructTree(inorder, preorder, start, iIndex - 1, index, indexMap);
    node->right = constructTree(inorder, preorder, iIndex + 1, end, index, indexMap);

    return node;
}

void Tree::constructTree(std::vector<int>& inorder, std::vector<int>& preorder)
{
    std::unordered_map<int,int> indexMap;
    for (int i = 0; i < inorder.size(); ++i) {
        indexMap[inorder[i]] = i;
    }

    int index = 0;
    root = constructTree(inorder, preorder, 0, static_cast<int>(inorder.size()) - 1, index, indexMap);
}

void printVector(std::vector<int>& vec)
{
    for (auto i : vec) {
        std::cout << i << " ";
    }
    std::cout << "\n";
}

int main()
{
    std::vector<int> preorder {3,9,20,15,7};
    std::vector<int> inorder {9,3,15,20,7};

    Tree tree;
    tree.constructTree(inorder, preorder);

    std::cout << "================================\n";
    std::vector<int> preTraversal = tree.preorder();
    std::cout << "Preorder traversal : ";
    printVector(preTraversal);

    std::cout << "================================\n";
    std::vector<int> inTraversal = tree.inorder();
    std::cout << "Inorder traversal : ";
    printVector(inTraversal);

    return 0;
}