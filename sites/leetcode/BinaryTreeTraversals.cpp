// Level Order https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/
// Inorder iterative and recursive https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/786/
// Zigzag spiral level order https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/787/

#include <iostream>
#include <vector>
#include <climits>
#include <deque>
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
    std::vector<std::vector<int>> levelOrder();
    std::vector<int> inorderRec();
    std::vector<int> inorderIter();

private:
    void inorderRec(Node* node, std::vector<int>& order);
    void destroyTree(Node* node);
    Node* insert(int key, Node* node);
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

std::vector<int> BinaryTree::inorderIter()
{
    std::vector<int> order;
    if (root == nullptr) {
        return order;
    }
    
    Node* current = root;
    std::stack<Node*> stack;
    
    while (current != nullptr || !stack.empty()) {
        while (current != nullptr) {
            stack.push(current);
            current = current->left;
        }
        current = stack.top();
        stack.pop();
        order.push_back(current->key);
        current = current->right;
    }
    return order;
}

std::vector<int> BinaryTree::inorderRec()
{
    std::vector<int> order;
    inorderRec(root, order);
    return order;
}

void BinaryTree::inorderRec(Node* node, std::vector<int>& order)
{
    if (node == nullptr) {
        return;
    }
    inorderRec(node->left, order);
    order.push_back(node->key);
    inorderRec(node->right, order);
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

void printVector(std::vector<int>& order)
{
    for (auto v : order) {
        std::cout << v << " ";
    }
    std::cout << "\n";
}

int main()
{
    std::vector<int> keys {3,9,20,15,7,1};
    BinaryTree tree;
    tree.insertKeys(keys);
    
    std::cout << "==========================================\n";
    std::cout << "Level order of tree: \n";
    printVector(tree.levelOrder());
    
    std::cout << "==========================================\n";
    std::cout << "Inorder (recursive) traversal of tree: ";
    std::vector<int> orderRec = tree.inorderRec();
    printVector(orderRec);
    
    std::cout << "==========================================\n";
    std::cout << "Inorder (iterative) traversal of tree: ";
    std::vector<int> orderIter = tree.inorderIter();
    printVector(orderIter);
    
    std::cout << "==========================================\n";
    return 0;
}
