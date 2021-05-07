// https://www.geeksforgeeks.org/interval-tree/
// https://iq.opengenus.org/interval-tree/

#include <iostream>
#include <vector>
#include <climits>

class Interval
{
private:
    int low;
    int high;

public:
    Interval() { }
    Interval(int l, int h) : low(l), high(h) {}
    int getLow() { return low; }
    int getHigh() { return high; }
    void setLow(int l) { low = l; }
    void setHigh(int h) { high = h; }

    bool overlap(Interval& other)
    {
        if (this->low <= other.low && other.low <= this->high) {
            return true;
        }
        return false;
    }
};

class IntervalTree
{
private:
    class Node
    {
    public:
        Interval interval;
        int max;
        Node* left;
        Node* right;

        Node(Interval inter) : left{nullptr}, right{nullptr}
        {
            interval.setLow(inter.getLow());
            interval.setHigh(inter.getHigh());
            max = inter.getHigh();
        }
    };

    Node* root;

    void inorder(Node* node, std::vector<Node*>& path)
    {
        if (node == nullptr) {
            return;
        }

        inorder(node->left, path);
        path.push_back(node);
        inorder(node->right, path);
    }

    void print(std::vector<Node*>& path)
    {
        for (auto node : path) {
            std::cout << "[" << node->interval.getLow() << ", " << node->interval.getHigh() << "]"
                << " max = " << node->max << "\n";
        }
    }

    Node* insert(Node* node, Interval& interval)
    {
        if (node == nullptr) {
            return new Node(interval);
        }

        if (interval.getLow() < node->interval.getLow()) {
            node->left = insert(node->left, interval);
        } else {
            node->right = insert(node->right, interval);
        }

        if (node->max < interval.getHigh()) {
            node->max = interval.getHigh();
        }

        return node;
    }

    Node* search(Node* node, Interval& interval)
    {
        if (node == nullptr) {
            return nullptr;
        }

        if (interval.overlap(node->interval)) {
            return node;
        }

        if (node->left != nullptr && node->left->max >= interval.getLow()) {
            return search(node->left, interval);
        }

        return search(node->right, interval);
    }

public:
    IntervalTree() : root{nullptr} { }

    IntervalTree(std::vector<Interval>& intervals) : root{nullptr}
    {
        for (auto interval : intervals) {
            root = insert(root, interval);
        }
    }

    void inorder()
    {
        std::vector<Node*> path;
        inorder(root, path);
        print(path);
    }

    void search(Interval& interval)
    {
        if (root == nullptr) {
            return;
        }
        Node* node = search(root, interval);
        if (node == nullptr) {
            std::cout << " No overlapping interval\n";
        } else {
            std::cout << " Overlaps with [" << node->interval.getLow() << ", " << node->interval.getHigh() << "]\n";
        }
    }
};

int main()
{
    std::vector<Interval> intervals {{15, 20}, {10, 30}, {17, 19},
        {5, 20}, {12, 15}, {30, 40}};
    IntervalTree tree(intervals);
    std::cout << "Inorder : \n";
    tree.inorder();
    Interval x {5, 6};
    std::cout << "Searching for interval [" << x.getLow() << "," << x.getHigh() << "]";
    tree.search(x);
    return 0;
}

