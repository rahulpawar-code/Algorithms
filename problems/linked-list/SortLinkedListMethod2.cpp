// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-hard/117/linked-list/840/
// Techie Deligt https://www.techiedelight.com/given-linked-list-change-sorted-order/
// Using merge sort

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

    void frontBackSplit(Node* source, Node** front, Node** back)
    {
        if (source == nullptr || source->next == nullptr) {
            *front = source;
            *back = nullptr;
            return;
        }

        Node* fast = source->next;
        Node* slow = source;

        while (fast != nullptr) {
            fast = fast->next;
            if (fast != nullptr) {
                fast = fast->next;
                slow = slow->next;
            }
        }
        *front = source;
        *back = slow->next;
        slow->next = nullptr;
    }

    void mergesort(Node** head)
    {
        if (*head == nullptr || (*head)->next == nullptr) {
            return;
        }

        Node* a;
        Node* b;
        frontBackSplit(*head, &a, &b);

        mergesort(&a);
        mergesort(&b);

        *head = sortedMerge(a, b);
    }

    Node* sortedMerge(Node* a, Node* b)
    {
        if (a == nullptr) {
            return b;
        } else if (b == nullptr) {
            return a;
        }

        Node* result = nullptr;

        if (a->key < b->key) {
            result = a;
            result->next = sortedMerge(a->next, b);
        } else {
            result = b;
            result->next = sortedMerge(a, b->next);
        }

        return result;
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

    void mergesort()
    {
        mergesort(&head);
    }
};

int main()
{
    std::vector<int> keys {6, 3, 4, 8, 2, 9, 10, 5, 1};
    LinkedList list;
    list.createListFromVector(keys);
    list.print();
    list.mergesort();
    std::cout << "After merge sorting\n";
    list.print();
    return 0;
}