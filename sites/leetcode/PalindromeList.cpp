// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/

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

    void printList(Node* node) {
        if (node == nullptr) {
            return;
        }

        while (node != nullptr) {
            std::cout << node->key << " ";
            node = node->next;
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

    Node* reverseList(Node* head) {
        Node* previous = nullptr;
        Node* next = nullptr;

        while (head != nullptr) {
            next = head->next;
            head->next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    bool isPalindrome() {
        if (head == nullptr || head->next == nullptr) {
            return true;
        }

        Node* slow = head;
        Node* fast = head;

        while (fast->next != nullptr && fast->next->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }

        Node* mid = slow;
        slow->next = reverseList(slow->next);
        slow = slow->next;
        Node* nextToMid = slow;
        Node* temp = head;

        while (slow != nullptr) {
            if (temp->key != slow->key) {
                mid->next = reverseList(nextToMid);
                return false;
            }
            temp = temp->next;
            slow = slow->next;
        }

        mid->next = reverseList(nextToMid);
        return true;
    }
};

int main()
{
    std::vector<int> keys {5, 1, 0, -3, -99};
    LinkedList list;

    std::cout << "List : ";
    list.addKeys(keys);
    list.printList();
    std::cout << "Is list palindrome: " << std::boolalpha << list.isPalindrome() << "\n";
    std::cout << "List after call: ";
    list.printList();

    std::cout << "============================================\n";

    std::vector<int> keys2 {1, 2, 2, 1};
    LinkedList list2;

    std::cout << "List : ";
    list2.addKeys(keys2);
    list2.printList();
    std::cout << "Is list palindrome: " << std::boolalpha << list2.isPalindrome() << "\n";
    std::cout << "List after call: ";
    list2.printList();
}

