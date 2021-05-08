// Techie Delight https://www.techiedelight.com/construct-balanced-bst-given-keys/

#include <vector>
#include <iostream>

class Tree
{
private:
    class Node
    {
    public:
        int key;
        Node* left;
        Node* right;

        Node(int k) : key(k), left(nullptr), right(nullptr) { }
    };

    Node* root;

    void print(std::vector<Node*>& path)
    {
        for (auto node : path) {
            std::cout << node->key << " ";
        }
        std::cout << "\n";
    }

    void preorder(Node* node, std::vector<Node*>& path)
    {
        if (node == nullptr) {
            return;
        }
        path.push_back(node);
        preorder(node->left, path);
        preorder(node->right, path);
    }

    Node* construct(std::vector<int>& keys, int left, int right)
    {
        if (left > right) {
            return nullptr;
        }

        int mid = left + (right - left) / 2;
        Node* node = new Node(keys[mid]);

        node->left = construct(keys, left, mid - 1);
        node->right = construct(keys, mid + 1, right);

        return node;
    }

public:
    Tree() : root(nullptr) { }

    Tree(std::vector<int> keys)
    {
        root = construct(keys, 0, keys.size() - 1);
    }

    void inorder()
    {
        std::vector<Node*> path;
        preorder(root, path);
        print(path);
    }

};

int main()
{
    std::vector<int> keys { 15, 10, 20, 8, 12, 16, 25 };
    Tree tree(keys);
    tree.inorder();
}