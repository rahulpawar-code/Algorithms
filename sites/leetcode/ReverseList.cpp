// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/

#include <iostream>
#include <vector>

class Node
{
public:
    int key;
    Node* next;

    Node(int x) : key {x}, next {nullptr} {}
};

class LinkedList
{
private:
    Node* head;

public:
    LinkedList() : head {nullptr}
    { }

    void addFront(int key) {
        Node* node = new Node(key);
        if (head != nullptr) {
            node->next = head;
        }
        head = node;
    }

    void addKeys(std::vector<int> keys) {
        for (auto i : keys) {
            addFront(i);
        }
    }

    void printList() {
        Node* current = head;
        while (current != nullptr) {
            std::cout << current->key << " ";
            current = current->next;
        }
        std::cout << "\n";
    }

    Node* reverseRec(Node* node) {
        if (node == nullptr || node->next == nullptr) {
            return node;
        }

        Node* temp = reverseRec(node->next);
        node->next->next = node;
        node->next = nullptr;
        return temp;
    }

    void reverseRecursive() {
        head = reverseRec(head);
    }

    void reverse() {
        Node* current = head;
        Node* previous = nullptr;

        while (current != nullptr) {
            Node* temp = current->next;
            current->next = previous;
            previous = current;
            current = temp;
        }

        head = previous;
    }
};

int main()
{
    std::vector<int> keys {-3, 5, -99, 0, 1};
    LinkedList list;

    std::cout << "Orignial List: ";
    list.addKeys(keys);
    list.printList();

    std::cout << "Reverse iterative : ";
    list.reverse();
    list.printList();

    std::cout << "Reverse recursive : ";
    list.reverseRecursive();
    list.printList();

    std::cout << "===============================\n";
    std::vector<int> keys2 {-3};
    LinkedList list2;

    std::cout << "Orignial List: ";
    list2.addKeys(keys2);
    list2.printList();

    std::cout << "Reverse iterative : ";
    list2.reverse();
    list2.printList();

    std::cout << "Reverse recursive : ";
    list2.reverseRecursive();
    list2.printList();

    std::cout << "===============================\n";

    std::vector<int> keys3 {};
    LinkedList list3;

    std::cout << "Orignial List: ";
    list3.addKeys(keys3);
    list3.printList();

    std::cout << "Reverse iterative : ";
    list3.reverse();
    list3.printList();

    std::cout << "Reverse recursive : ";
    list3.reverseRecursive();
    list3.printList();

    std::cout << "===============================\n";

    std::vector<int> keys4 {10, 40};
    LinkedList list4;

    std::cout << "Orignial List: ";
    list4.addKeys(keys4);
    list4.printList();

    std::cout << "Reverse iterative : ";
    list4.reverse();
    list4.printList();

    std::cout << "Reverse recursive : ";
    list4.reverseRecursive();
    list4.printList();

    return 0;
}