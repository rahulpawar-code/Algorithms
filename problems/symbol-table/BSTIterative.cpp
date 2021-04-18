// BST ierative insert, search
// Insert https://www.techiedelight.com/insertion-in-bst/
// Search https://www.techiedelight.com/search-given-key-in-bst/

#include <iostream>
#include <vector>
#include <climits>
#include <cstdlib>
#include <ctime>

class Tree
{
private:
    class Node
    {
    public:
        int key;
        Node* left;
        Node* right;

        Node() : key(INT_MIN), left(nullptr), right(nullptr) { }
        Node(int k) : key(k), left(nullptr), right(nullptr) { }
    };

    Node* root;

    void inorder(Node* node, std::vector<int>& sequence) {
        if (node == nullptr) {
            return;
        }

        inorder(node->left, sequence);
        sequence.push_back(node->key);
        inorder(node->right, sequence);
    }

    void preorder(Node* node, std::vector<int>& sequence) {
        if (node == nullptr) {
            return;
        }

        sequence.push_back(node->key);
        preorder(node->left, sequence);
        preorder(node->right, sequence);
    }

    void postorder(Node* node, std::vector<int>& sequence) {
        if (node == nullptr) {
            return;
        }

        postorder(node->left, sequence);
        postorder(node->right, sequence);
        sequence.push_back(node->key);
    }

    void print(std::vector<int>& sequence)
    {
        for (auto key : sequence) {
            std::cout << key << " ";
        }
        std::cout << "\n";
    }

public:
    Tree() : root(nullptr) { }

    void insert(int key)
    {
        if (root == nullptr) {
            root = new Node(key);
            return;
        }

        Node* parent = nullptr;
        Node* current = root;

        while (current != nullptr) {
            parent = current;

            if (key < current->key) {
                current = current->left;
            } else {
                current = current->right;
            }
        }

        if (key < parent->key) {
            parent->left = new Node(key);
        } else {
            parent->right = new Node(key);
        }
    }

    void insert(std::vector<int> keys)
    {
        for (auto key : keys) {
            insert(key);
        }
    }

    void preorder()
    {
        std::vector<int> sequence;
        preorder(root, sequence);
        print(sequence);
    }

    void inorder()
    {
        std::vector<int> sequence;
        inorder(root, sequence);
        print(sequence);
    }

    void postorder()
    {
        std::vector<int> sequence;
        postorder(root, sequence);
        print(sequence);
    }

    bool search(int key) {
        Node* current = root;

        while (current != nullptr && current->key != key) {
            if (key < current->key) {
                current = current->left;
            } else {
                current = current->right;
            }
        }

        return (current != nullptr) &&  (current->key == key);
    }
};

std::vector<int> generateRandomVector(int size, int min, int max)
{
    std::srand(std::time(nullptr));
    std::vector<int> numbers;
    for (int i = 0; i < size; ++i) {
        int num = min + std::rand() % (max - min + 1);
        numbers.push_back(num);
    }
    return numbers;
}

int main()
{
    std::vector<int> keys = generateRandomVector(15, 1, 50);

    Tree bst;
    bst.insert(keys);
    bst.preorder();
    bst.inorder();
    bst.postorder();
    bst.insert(10);

    std::cout << "Key 10 present : " << std::boolalpha << bst.search(10) << "\n";

    return 0;
}