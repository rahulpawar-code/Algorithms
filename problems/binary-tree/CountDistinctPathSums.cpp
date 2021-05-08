// Count all possible distinct sums (top-down) in a binary tree

#include <iostream>
#include <vector>
#include <unordered_set>

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
    using Path = std::vector<Node*>;

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

    void print(Path& sequence)
    {
        for (auto node : sequence) {
            std::cout << node->key << " ";
        }
        std::cout << "\n";
    }

    void preorder(Node* node, Path& sequence)
    {
        if (node == nullptr) {
            return;
        }

        sequence.push_back(node);
        preorder(node->left, sequence);
        preorder(node->right, sequence);
    }

    void countDistinctSumPaths(Node* node, int sum, std::unordered_set<int>& count,
        Path currentPath, std::vector<Path>& distinctPaths)
    {
        if (node == nullptr) {
            return;
        }

        sum = sum + node->key;
        currentPath.push_back(node);
        if (count.find(sum) == count.end()) {
            count.emplace(sum);
            distinctPaths.push_back(currentPath);
        }

        countDistinctSumPaths(node->left, sum, count, currentPath, distinctPaths);
        countDistinctSumPaths(node->right, sum, count, currentPath, distinctPaths);
    }

public:
    Tree() : root(nullptr) { }

    Tree(std::vector<int>& keys)
    {
        root = construct(keys, 0, keys.size() - 1);
    }

    void preorder()
    {
        std::vector<Node*> sequence;
        preorder(root, sequence);
        print(sequence);
    }

    void countDistinctSumPaths()
    {
        std::unordered_set<int> count;
        Path currentPath;
        std::vector<Path> distinctPaths;
        countDistinctSumPaths(root, 0, count, currentPath, distinctPaths);
        std::cout << "Distinct sum paths count : " << count.size() << "\n";
        if (distinctPaths.size() > 0) {
            std::cout << "Paths :\n";
            for (auto path : distinctPaths) {
                print(path);
            }
        }
    }
};

int main()
{
    std::vector<int> keys {1, 2, 1, -2, -1, 3, -1, 2, 1,
                            3, 4, -5, 5, -4, -3, 2, -2, -1};
    Tree tree(keys);
    std::cout << "Preorder : ";
    tree.preorder();
    tree.countDistinctSumPaths();

    return 0;
}
