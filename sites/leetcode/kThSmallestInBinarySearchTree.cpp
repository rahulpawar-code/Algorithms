// Kth Smallest Element in a BST  https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/790/

#include <iostream>
#include <vector>
#include <climits>
#include <stack>

class Node
{
public:
    int key;
    Node* left;
    Node* right;

    Node() : key{0}, left {nullptr}, right{nullptr} {}
    Node(int x) : key {x}, left {nullptr}, right {nullptr} {}
};

class BinaryTree
{
private:
    Node* root;

public:
    BinaryTree();
    ~BinaryTree();
    void insert(int key);
    void destroyTree();
    void insertKeys(std::vector<int> keys);
    int kthSmallestIter(int k);
    int kthSmallestRec(int k);

private:
    void destroyTree(Node* node);
    Node* insert(int key, Node* node);
    int kthSmallestRec(Node* node, int& k);
};

BinaryTree::BinaryTree() : root {nullptr}
{}

BinaryTree::~BinaryTree()
{
    destroyTree(root);
}

void BinaryTree::destroyTree(Node* node)
{
    if (node != nullptr) {
        destroyTree(node->left);
        destroyTree(node->right);
        delete node;
    }
}

void BinaryTree::insertKeys(std::vector<int> keys)
{
    for (auto key : keys) {
        root = insert(key, root);
    }
}

void BinaryTree::insert(int key) {
    root = insert(key, root);
}

Node* BinaryTree::insert(int key, Node* node)
{
    if (node == nullptr) {
        node = new Node(key);
    } else if (key < node->key) {
        node->left = insert(key, node->left);
    } else {
        node->right = insert(key, node->right);
    }
    return node;
}

int BinaryTree::kthSmallestIter(int k)
{
    if (root == nullptr) {
        return INT_MIN;
    }

    std::stack<Node*> stack;
    Node* current = root;

    while (!stack.empty() || current != nullptr) {
        if (current != nullptr) {
            stack.push(current);
            current = current->left;
        } else {
            current = stack.top();
            stack.pop();
            if (--k == 0) {
                return current->key;
            }

            current = current->right;
        }
    }
    return INT_MIN;
}

int BinaryTree::kthSmallestRec(int k)
{
    return kthSmallestRec(root, k);
}

int BinaryTree::kthSmallestRec(Node* node, int& k)
{
    if (node == nullptr) {
        return INT_MIN;
    }

    int val = kthSmallestRec(node->left, k);
    if (val != INT_MIN) {
        return val;
    }

    k--;
    if (k == 0) {
        return node->key;
    }
    return kthSmallestRec(node->right, k);
}


int main()
{
    std::vector<int> keys {3,9,20,15,7,1,8,10,5,2};
    BinaryTree tree;
    tree.insertKeys(keys);

    int k = 5;
    std::cout << k << "th smallest element in BST (iterative): " << tree.kthSmallestIter(k) << "\n";
    std::cout << "==========================================\n";
    std::cout << k << "th smallest element in BST (recursive): " << tree.kthSmallestRec(k) << "\n";

    k = 1000;
    std::cout << "==========================================\n";
    std::cout << k << "th smallest element in BST (iterative): " << tree.kthSmallestIter(k) << "\n";
    std::cout << "==========================================\n";
    std::cout << k << "th smallest element in BST (recursive): " << tree.kthSmallestRec(k) << "\n";

    return 0;
}
