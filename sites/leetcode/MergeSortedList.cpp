// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/

#include <iostream>
#include <vector>

class Node
{
public:
    int key;
    Node* next;

    Node(int x) : key {x}, next{nullptr} {}
};

class LinkedList
{
private:
    Node* head;

public:
    LinkedList() : head{nullptr} {}

    void printList() {
        if (head == nullptr) {
            return;
        }

        Node* temp = head;
        while (temp != nullptr) {
            std::cout << temp->key << " ";
            temp = temp->next;
        }
        std::cout << "\n";
    }

    void addFront(int key) {
        Node* node = new Node(key);

        if (head != nullptr) {
            node->next = head;
        }

        head = node;
    }

    void addKeys(const std::vector<int> keys) {
        for (auto key : keys) {
            addFront(key);
        }
    }

    bool isEmpty() {
        return head == nullptr;
    }

    Node* mergeRec(Node* node1, Node* node2) {
        Node* newHead = node1;
        Node* temp = node1;
        node1 = node1->next;

        while (node1 != nullptr && node2 != nullptr) {
            if (node1->key < node2->key) {
                temp->next = node1;
                node1 = node1->next;
            } else {
                temp->next = node2;
                node2 = node2->next;
            }
            temp = temp->next;
        }

        temp->next = (node1 == nullptr) ? node2 : node1;

        return newHead;
    }

    void merge(LinkedList first, LinkedList second) {
        if (first.isEmpty()) {
            head = second.head;
        } else if (second.isEmpty()) {
            head = first.head;
        } else if (first.head->key < second.head->key) {
            head = mergeRec(first.head, second.head);
        } else {
            head = mergeRec(second.head, first.head);
        }
    }
};

int main()
{
    std::vector<int> keys1 {5, 1, 0, -3, -99};
    std::vector<int> keys2 {4, 2, 1};

    LinkedList list1;
    LinkedList list2;

    std::cout << "List 1: ";
    list1.addKeys(keys1);
    list1.printList();

    std::cout << "List 2: ";
    list2.addKeys(keys2);
    list2.printList();

    LinkedList list3;
    list3.merge(list1, list2);
    std::cout << "Merged List : \n";
    list3.printList();
}
