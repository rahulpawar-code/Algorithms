// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-hard/117/linked-list/840/
// Techie Deligt https://www.techiedelight.com/given-linked-list-change-sorted-order/
// n^2 method

#include <iostream>
#include <vector>

class LinkedList
{
private:
    class Node
    {
    public:
        int key;
        Node* next;

        Node() : key(0), next(nullptr) { }
        Node(int k) : key(k), next(nullptr) { }
    };

    Node* head;

    Node* sortedInsert(Node* head, Node* node)
    {
        Node* dummy = new Node();
        Node* current = dummy;
        dummy->next = head;

        while (current->next != nullptr && current->next->key < node->key) {
            current = current->next;
        }

        node->next = current->next;
        current->next = node;
        return dummy->next;
    }

public:
    LinkedList() : head(nullptr) { }

    ~LinkedList()
    {
        Node* current = head;
        while (current != nullptr) {
            Node* temp = current;
            current = current->next;
            delete temp;
        }
        head = nullptr;
    }

    void push(int val)
    {
        Node* node = new Node(val);
        if (head != nullptr) {
            node->next = head;
        }
        head = node;
    }

    void createListFromVector(std::vector<int>& keys)
    {
        for (auto key : keys) {
            push(key);
        }
    }

    void print()
    {
        Node* current = head;
        while (current != nullptr) {
            std::cout << current->key << " ";
            current = current->next;
        }
        std::cout << "\n";
    }

    void sort()
    {
        Node* current = head;
        Node* next;
        Node* result = nullptr;

        while (current != nullptr) {
            next = current->next;
            result = sortedInsert(result, current);
            current = next;
        }
        head = result;
    }
};

int main()
{
    std::vector<int> keys {6, 3, 4, 8, 2, 9, 10, 5, 1};
    LinkedList list;
    list.createListFromVector(keys);
    list.print();
    list.sort();
    std::cout << "After sorting\n";
    list.print();
    return 0;
}