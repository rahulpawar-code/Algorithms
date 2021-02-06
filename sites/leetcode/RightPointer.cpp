// Populating Next Right Pointers in Each Node https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/789/

#include <iostream>
#include <vector>
#include <climits>
#include <queue>

class Node
{
public:
    int key;
    Node* left;
    Node* right;
    Node* next;

    Node() : key{0}, left {nullptr}, right{nullptr}, next{nullptr} {}
    Node(int x) : key {x}, left {nullptr}, right {nullptr}, next{nullptr} {}
};

class BinaryTree
{
private:
    Node* root;

public:
    BinaryTree();
    ~BinaryTree();
    void insert(int key);
    void insertKeys(std::vector<int> keys);
    void inorder();
    void populateRightNext();
    void populateRightNext2();
    void traverseUsingNext();

private:
    void destroyTree(Node* node);
    Node* insert(int key, Node* node);
    void inorder(Node* node);
    Node* getNextRight(Node* node);
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

void BinaryTree::populateRightNext()
{
    if (root == nullptr) {
        return;
    }
    std::queue<Node*> queue;
    queue.push(root);

    while (!queue.empty()) {
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            Node* current = queue.front();
            queue.pop();

            current->next = (i < size - 1) ? queue.front() : nullptr;

            if (current->left != nullptr) {
                queue.push(current->left);
            }

            if (current->right != nullptr) {
                queue.push(current->right);
            }
        }
    }
}

Node* BinaryTree::getNextRight(Node* node)
{
    if (node == nullptr) {
        return nullptr;
    }
    Node* temp = node->next;

    while (temp != nullptr) {
        if (temp->left != nullptr) {
            return temp->left;
        } else if (temp->right != nullptr) {
            return temp->right;
        }

        temp = temp->next;
    }
    return nullptr;
}

void BinaryTree::populateRightNext2()
{
    if (root == nullptr) {
        return;
    }
    Node* temp = root;

    while (temp != nullptr) {
        Node* current = temp;

        while (current != nullptr) {
            if (current->left != nullptr) {
                if (current->right != nullptr) {
                    current->left->next = current->right;
                } else {
                    current->left->next = getNextRight(current);
                }
            }
            if (current->right != nullptr) {
                current->right->next = getNextRight(current);
            }

            current = current->next;
        }
        if (temp->left != nullptr) {
            temp = temp->left;
        } else if (temp->right != nullptr) {
            temp = temp->right;
        } else {
            temp = getNextRight(temp);
        }
    }
}

void BinaryTree::traverseUsingNext()
{
    if (root == nullptr) {
        return;
    }

    Node * temp = root;
    while (temp != nullptr) {
        Node* current = temp;
        while (current != nullptr) {
            std::cout << current->key << " ";
            current = current->next;
        }
        std::cout << "\n";
        if (temp->left != nullptr) {
            temp = temp->left;
        } else if (temp->right != nullptr) {
            temp = temp->right;
        } else {
            temp = getNextRight(temp);
        }
    }
}

int main()
{
    std::vector<int> keys {3,9,20,15,7, 1, 4, 17, 12};
    BinaryTree tree;
    tree.insertKeys(keys);
    std::cout << "Inorder traversal of tree: ";
    tree.inorder();

    tree.populateRightNext();
    std::cout << "Traversal using next pointer of nodes: \n";
    tree.traverseUsingNext();

    std::cout << "================================\n";

    std::vector<int> keys2 {3,9,20,15,7, 1, 4, 17, 12};
    BinaryTree tree2;
    tree2.insertKeys(keys2);
    std::cout << "Inorder traversal of tree: ";
    tree2.inorder();

    std::cout << "Traversal using next pointer of nodes: \n";
    tree2.populateRightNext2();
    tree2.traverseUsingNext();

    return 0;
}
