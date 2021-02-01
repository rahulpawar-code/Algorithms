// Level Order https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/

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
    std::vector<std::vector<int>> levelOrder();

private:
    void destroyTree(Node* node);
    Node* insert(int key, Node* node);
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

std::vector<std::vector<int>> BinaryTree::levelOrder()
{
    std::vector<std::vector<int>> order;
    if (root == nullptr) {
        return order;
    }

    std::deque<Node*> queue;
    queue.push_back(root);

    while (!queue.empty()) {
        std::vector<int> currentlevel;
        int qsize = queue.size();
        for (int i = 0; i < qsize; ++i) {
            Node* node = queue.front();
            queue.pop_front();
            if (node != nullptr) {
                currentlevel.push_back(node->key);
                if (node->left != nullptr) {
                        queue.push_back(node->left);
                }
                if (node->right != nullptr) {
                    queue.push_back(node->right);
                }
            }
        }
        if (qsize != 0) {
            order.push_back(currentlevel);
        }
    }

    return order;
}

void printVector(std::vector<std::vector<int>> order)
{
    for (auto v : order) {
        for (auto l : v) {
            std::cout << l << " ";
        }
        std::cout << "\n";
    }
}

int main()
{
    std::vector<int> keys {3,9,20,15,7,1};

    BinaryTree tree;
    tree.insertKeys(keys);
    std::cout << "Inorder traversal of tree: ";
    tree.inorder();
    std::cout << "Level order of tree: \n";
    printVector(tree.levelOrder());

    return 0;
}
