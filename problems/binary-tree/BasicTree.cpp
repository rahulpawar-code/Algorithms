// Binary tree
// Diameter https://www.techiedelight.com/find-diameter-of-a-binary-tree/

#include <iostream>
#include <vector>
#include <queue>
#include <climits>

enum class TRAVERSAL {inorder, preorder, postorder};

class BinaryTree
{
private:
    class Node
    {
    public:
        int key;
        Node* left;
        Node* right;

        Node() : key(0), left(nullptr), right(nullptr) { }
        Node(int k) : key(k), left(nullptr), right(nullptr) { }
    };

    Node* root;

    void constructTree(std::vector<int>& keys)
    {
        std::queue<Node*> nodeQueue;
        if (root == nullptr) {
            root = new Node(keys[0]);
        }
        nodeQueue.push(root);

        int keysIndex = 1;
        while (!nodeQueue.empty()) {
            Node* currentNode = nodeQueue.front();
            nodeQueue.pop();

            if (keysIndex < keys.size() && keys[keysIndex] != INT_MIN) {
                currentNode->left = new Node(keys[keysIndex]);
                nodeQueue.push(currentNode->left);
            }
            keysIndex++;

            if (keysIndex < keys.size() && keys[keysIndex] != INT_MIN) {
                currentNode->right = new Node(keys[keysIndex]);
                nodeQueue.push(currentNode->right);
            }
            keysIndex++;
        }
    }

    void traverseTree (Node* node, const TRAVERSAL& order, std::vector<Node*>& traversal)
    {
        if (node == nullptr) {
            return;
        }

        if (order == TRAVERSAL::inorder) {
            traverseTree(node->left, order, traversal);
            traversal.push_back(node);
            traverseTree(node->right, order, traversal);
        } else if (order == TRAVERSAL::postorder) {
            traverseTree(node->left, order, traversal);
            traverseTree(node->right, order, traversal);
            traversal.push_back(node);
        } else {
            traversal.push_back(node);
            traverseTree(node->left, order, traversal);
            traverseTree(node->right, order, traversal);
        }
    }

    void printTraversal(std::vector<Node*>& traversal)
    {
        for (auto node : traversal) {
            std::cout << node->key << " ";
        }
        std::cout << "\n";
    }

    int height(Node* node)
    {
        if (node == nullptr) {
            return 0;
        }

        return 1 + std::max(height(node->left), height(node->right));
    }

    int getDiameter(Node* node, int& diameter)
    {
        if (node == nullptr) {
            return 0;
        }

        int leftHeight = getDiameter(node->left, diameter);
        int rightHeight = getDiameter(node->right, diameter);
        diameter = std::max(diameter, leftHeight + rightHeight + 1);

        return 1 + std::max(leftHeight, rightHeight);
    }

public:
    BinaryTree() : root(nullptr) { }

    BinaryTree(std::vector<int>& keys) : root(nullptr)
    {
        if (keys.size() == 0) {
            return;
        }
        constructTree(keys);
    }

    void traverseTree(const TRAVERSAL& order)
    {
        std::vector<Node*> traversal;
        traverseTree(root, order, traversal);
        printTraversal(traversal);
    }

    int height()
    {
        return height(root);
    }

    int diameter()
    {
        int dia = 0;
        getDiameter(root, dia);
        return dia;
    }
};

int main()
{
    std::vector<int> keys {1, 2, 3, 4, 5, 6, INT_MIN, 7, INT_MIN, 8, 9, INT_MIN, 10, 11};
    BinaryTree tree(keys);

    std::cout << "Preorder traversal: ";
    tree.traverseTree(TRAVERSAL::preorder);
    std::cout << "Inorder traversal: ";
    tree.traverseTree(TRAVERSAL::inorder);
    std::cout << "Postorder traversal: ";
    tree.traverseTree(TRAVERSAL::postorder);

    std::cout << "Height of tree: " << tree.height() << "\n";
    std::cout << "Diameter of tree: " << tree.diameter() << "\n";
}