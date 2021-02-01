// Sorted Array to Binary Search Tree
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/

#include <iostream>
#include <vector>

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
    void destroyTree();
    void inorder();
    void sortedArrayToBST(std::vector<int>& nums);

private:
    void destroyTree(Node* node);
    Node* sortedArrayToBST(std::vector<int>& nums, int start, int end);
    void inorder(Node* node);
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

void BinaryTree::inorder()
{
    inorder(root);

    if (root != nullptr) {
        std::cout << "\n";
    }
}

void BinaryTree::inorder(Node* node)
{
    if (node == nullptr) {
        return;
    }
    inorder(node->left);
    std::cout << node->key << " ";
    inorder(node->right);
}

Node* BinaryTree::sortedArrayToBST(std::vector<int>& nums, int start, int end)
{
    if (start > end || start < 0 || end > nums.size() - 1) {
        return nullptr;
    }

    int mid = (start + end) / 2;
    Node* node = new Node(nums[mid]);
    node->left = sortedArrayToBST(nums, start, mid - 1);
    node->right = sortedArrayToBST(nums, mid + 1, end);
    return node;
}

void BinaryTree::sortedArrayToBST(std::vector<int>& nums)
{
    root = sortedArrayToBST(nums, 0, nums.size() - 1);
}

int main()
{
    std::vector<int> keys {1, 2, 3, 4, 5, 6, 7};

    BinaryTree tree;
    tree.sortedArrayToBST(keys);
    std::cout << "Inorder traversal of tree: ";
    tree.inorder();

    return 0;
}
