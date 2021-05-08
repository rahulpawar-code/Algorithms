// TechieDelight https://www.techiedelight.com/find-next-node-in-same-level-binary-tree/

#include <vector>
#include <iostream>
#include <list>
#include <climits>

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

    // Construct a balanced tree https://www.techiedelight.com/construct-balanced-bst-given-keys/
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

    int findNextRight(int key)
    {
        if (root == nullptr || key == INT_MIN) {
            return INT_MIN;
        }

        std::list<Node*> queue;
        queue.push_back(root);

        Node* current = nullptr;
        while (!queue.empty()) {
            int size = queue.size();

            while (size--) {
                current = queue.front();
                queue.pop_front();

                if (current->key == key) {
                    if (size == 0) {
                        return INT_MIN;
                    }

                    return queue.front()->key;
                }

                if (current->left != nullptr) {
                    queue.push_back(current->left);
                }

                if (current->right != nullptr) {
                    queue.push_back(current->right);
                }
            }
        }

        return INT_MIN;
    }
};

void test(Tree& tree, int key)
{
    std::cout << "Next right of " << key;
    int right = tree.findNextRight(key);
    if (right == INT_MIN) {
        std::cout << " does not exists\n";
    } else {
        std::cout << " is " << right << "\n";
    }
}

int main()
{
    std::vector<int> keys { 15, 10, 20, 8, 12, 16, 25 };
    Tree tree(keys);
    tree.inorder();
    test(tree, 10);
    test(tree, 25);
}