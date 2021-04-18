// BST recursive insert, search, construct balanced tree
// Insert https://www.techiedelight.com/insertion-in-bst/
// Search https://www.techiedelight.com/search-given-key-in-bst/
// Construct balanced tree https://www.techiedelight.com/construct-balanced-bst-given-keys/

#include <iostream>
#include <vector>
#include <climits>
#include <cstdlib>
#include <ctime>
#include <algorithm>

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

    Node* insert(Node* node, int key)
    {
        if (node == nullptr) {
            return new Node(key);
        }

        if (key < node->key) {
            node->left = insert(node->left, key);
        } else {
            node->right = insert(node->right, key);
        }

        return node;
    }

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

    bool search(Node* node, int key) {
        if (node == nullptr) {
            return false;
        }
        if (node->key == key) {
            return true;
        }

        return search(node->left, key) || search(node->right, key);
    }

    void constructBalanced(std::vector<int>& keys, int low, int high, Node*& node)
    {
        if (low > high) {
            return;
        }

        int mid = low + (high - low) / 2;
        node = new Node(keys[mid]);
        constructBalanced(keys, low, mid - 1, node->left);
        constructBalanced(keys, mid + 1, high, node->right);
    }

    Node* findMaximumKey(Node* node)
    {
        while (node->right != nullptr) {
            node = node->right;
        }
        return node;
    }

    Node* deleteKey(Node* node, int key)
    {
        if (node == nullptr) {
            return nullptr;
        }
        if (key < node->key) {
            node->left = deleteKey(node->left, key);
        } else if (node->key < key) {
            node->right = deleteKey(node->right, key);
        } else {
            if (node->left == nullptr && node->right == nullptr) {
                delete node;
                return nullptr;
            } else if (node->left != nullptr && node->right != nullptr) {
                Node* predecessor = findMaximumKey(node->left);
                std::swap(node->key, predecessor->key);
                node->left = deleteKey(node->left, predecessor->key);
            } else {
                if (node->left == nullptr) {
                    node = node->right;
                } else {
                    node = node->left;
                }
            }
        }
        return node;
    }

public:
    Tree() : root(nullptr) { }

    void insert(std::vector<int>& keys)
    {
        for(auto key : keys) {
            root = insert(root, key);
        }
    }

    void insert(int key)
    {
        root = insert(root, key);
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

    bool search(int key)
    {
        return search(root, key);
    }

    void constructBalanced(std::vector<int>& keys)
    {
        std::sort(keys.begin(), keys.end());
        constructBalanced(keys, 0, keys.size() - 1, root);
    }

    void deleteKey(int key)
    {
        root = deleteKey(root, key);
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

    std::cout << "Inserting key 10\n";
    bst.insert(10);
    std::cout << "Key 10 present in tree : " << std::boolalpha << bst.search(10) << "\n";
    bst.inorder();
    std::cout << "Deleting key 10\n";
    bst.deleteKey(10);
    bst.inorder();

    std::cout << "\n=========================================\n";
    std::vector<int> keys2 = generateRandomVector(15, 1, 100);
    Tree bst2;
    bst2.constructBalanced(keys2);
    bst2.preorder();
    bst2.inorder();
    bst2.postorder();

    return 0;
}