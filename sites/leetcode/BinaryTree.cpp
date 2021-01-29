// Binary tree in C++  : https://www.cprogramming.com/tutorial/lesson18.html
// Max depth of tree  : https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
// Validate binary search tree, check if binary search tree : https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/

#include <iostream>
#include <vector>
#include <climits>

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
    Node* search(int key);
    void destroyTree();
    void insertKeys(std::vector<int> keys);
    void inorder();
    int depth();
    bool validateBST();

private:
    void destroyTree(Node* node);
    Node* insert(int key, Node* node);
    Node* search(int key, Node* node);
    void inorder(Node* node);
    int depth(Node* node);
    bool validateBST(Node* node, int min, int max);
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

Node* BinaryTree::search(int key)
{
    return search(key, root);
}

Node* BinaryTree::search(int key, Node* node)
{
    if (node == nullptr) {
        return nullptr;
    }

    if (key == node->key) {
        return node;
    } else if (key < node->key) {
        return search(key, node->left);
    } else {
        return search(key, node->right);
    }
}

int BinaryTree::depth()
{
    return depth(root);
}

int BinaryTree::depth(Node* node)
{
    if (node == nullptr) {
        return 0;
    }

    return 1 + std::max(depth(node->left), depth(node->right));
}

bool BinaryTree::validateBST()
{
    return validateBST(root, INT_MIN, INT_MAX);
}

bool BinaryTree::validateBST(Node* node, int min, int max)
{
    return (node == nullptr) ||
           ( (node->key <= max && node->key >= min) &&
             validateBST(node->left, min, node->key) &&
             validateBST(node->right, node->key, max)) ;
}

int main()
{
    std::vector<int> keys {3,9,20,15,7};

    BinaryTree tree;
    tree.insertKeys(keys);
    std::cout << "Inorder traversal of tree: ";
    tree.inorder();
    std::cout << "Depth of tree : " << tree.depth() << "\n";
    std::cout << "Validate binary tree : " << std::boolalpha << tree.validateBST() << "\n";

    return 0;
}
