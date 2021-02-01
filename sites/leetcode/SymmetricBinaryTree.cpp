// Symmetric tree https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/

#include <iostream>
#include <vector>
#include <climits>
#include <deque>

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
    void inorder();
    bool isSymmetricTreeIterative();
    bool isSymmetricTreeRecursive();

private:
    void destroyTree(Node* node);
    Node* insert(int key, Node* node);
    void inorder(Node* node);
    bool isSymmetricTreeRecursive(Node* lnode, Node* rnode);
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

bool BinaryTree::isSymmetricTreeIterative()
{
    if (root == nullptr) {
        return true;
    }

    std::deque<Node*> lqueue;
    std::deque<Node*> rqueue;

    lqueue.push_back(root->left);
    rqueue.push_back(root->right);

    while (!lqueue.empty() && !rqueue.empty()) {
        Node* lnode = lqueue.front();
        lqueue.pop_front();
        Node* rnode = rqueue.front();
        rqueue.pop_front();

        if ((lnode != nullptr && rnode == nullptr) ||
           (lnode == nullptr && rnode != nullptr) ||
           ((lnode != nullptr && rnode != nullptr) && (lnode->key != rnode->key))) {
            return false;
        }
        if (lnode != nullptr) {
            lqueue.push_back(lnode->left);
            lqueue.push_back(lnode->right);
        }
        if (rnode != nullptr) {
            rqueue.push_back(rnode->right);
            rqueue.push_back(rnode->left);
        }
    }

    return lqueue.empty() && rqueue.empty();
}

bool BinaryTree::isSymmetricTreeRecursive(Node* lnode, Node* rnode)
{
    if (lnode == nullptr && rnode == nullptr) {
        return true;
    }
    if (lnode == nullptr || rnode == nullptr) {
        return false;
    }
    return (lnode->key == rnode->key) &&
            isSymmetricTreeRecursive(lnode->left, rnode->right) &&
            isSymmetricTreeRecursive(lnode->right, rnode->left);
}

bool BinaryTree::isSymmetricTreeRecursive()
{
    return isSymmetricTreeRecursive(root, root);
}

int main()
{
    std::vector<int> keys {3,9,20,15,7};

    BinaryTree tree;
    tree.insertKeys(keys);
    std::cout << "Inorder traversal of tree: ";
    tree.inorder();
    std::cout << "Is symmetric : " << std::boolalpha << tree.isSymmetricTreeIterative() << "\n";
    std::cout << "Is symmetric : " << std::boolalpha << tree.isSymmetricTreeRecursive() << "\n";

    return 0;
}
