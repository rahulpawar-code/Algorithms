// ??

#include <iostream>
#include <vector>
#include <stack>
#include <climits>


class Node
{
public:
    int key;
    Node* left;
    Node* right;

    Node() : key{0}, left{nullptr}, right{nullptr} { }
    Node(int k) : key{k}, left{nullptr}, right{nullptr} { }
};

class BinarySearchTree
{
private:
    Node* root;
    void destroyTree(Node* node);
    Node* insert(Node* node, int key);
    void inorder(Node* node);
    int kthLargestRec(Node* node, int& k);

public:
    BinarySearchTree();
    ~BinarySearchTree();
    BinarySearchTree(std::vector<int>& keys);
    void inorder();
    int kthLargestIter(int k);
    int kthLargestRec(int k);
};

BinarySearchTree::BinarySearchTree() : root{nullptr} { }

BinarySearchTree::~BinarySearchTree()
{
    if (root == nullptr) {
        return;
    }
    destroyTree(root);
}

void BinarySearchTree::destroyTree(Node* node)
{
    if (node != nullptr) {
        destroyTree(node->left);
        destroyTree(node->right);
        delete node;
    }
}

BinarySearchTree::BinarySearchTree(std::vector<int>& keys) : root {nullptr}
{
    for (auto key : keys) {
        root = insert(root, key);
    }
}

Node* BinarySearchTree::insert(Node* node, int key)
{
    if (node == nullptr) {
        node = new Node(key);
    } else if (key < node->key) {
        node->left = insert(node->left, key);
    } else {
        node->right = insert(node->right, key);
    }
    return node;
}

void BinarySearchTree::inorder(Node* node)
{
    if (node!= nullptr) {
        inorder(node->left);
        std::cout << node->key << " ";
        inorder(node->right);
    }
}

void BinarySearchTree::inorder()
{
    inorder(root);
    std::cout << "\n";
}

int BinarySearchTree::kthLargestIter(int k)
{
    if (root == nullptr) {
        return INT_MIN;
    }

    Node* current = root;
    std::stack<Node*> stack;

    while (!stack.empty() || current != nullptr) {
        if (current != nullptr) {
            stack.push(current);
            current = current->right;
        } else {
            current = stack.top();
            stack.pop();
            k--;
            if (k == 0) {
                return current->key;
            }
            current = current->left;
        }
    }
    return INT_MIN;
}

int BinarySearchTree::kthLargestRec(Node* node, int& k)
{
    if (node == nullptr) {
        return INT_MIN;
    }
    int val = kthLargestRec(node->right, k);
    if (val != INT_MIN) {
        return val;
    }

    k--;
    if (k == 0) {
        return node->key;
    }
    return kthLargestRec(node->left, k);
}

int BinarySearchTree::kthLargestRec(int k)
{
    return kthLargestRec(root, k);
}

int main()
{
    std::vector<int> keys {3,9,20,15,7,1,8,10,5,2};
    BinarySearchTree tree(keys);
    std::cout << "Inorder traversal : ";
    tree.inorder();
    std::cout << "==========================================\n";

    int k = 5;
    std::cout << k << "th largest element in BST (iterative): " << tree.kthLargestIter(k) << "\n";
    std::cout << "==========================================\n";
    std::cout << k << "th largest element in BST (recursive): " << tree.kthLargestRec(k) << "\n";

    k = 1000;
    std::cout << "==========================================\n";
    std::cout << k << "th largest element in BST (iterative): " << tree.kthLargestIter(k) << "\n";
    std::cout << "==========================================\n";
    std::cout << k << "th largest element in BST (recursive): " << tree.kthLargestRec(k) << "\n";

    return 0;
}
