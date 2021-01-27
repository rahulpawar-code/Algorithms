// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/

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

    void createCycle() {
        if (head == nullptr || head->next == nullptr) {
            return;
        }

        Node* second = head->next;
        Node* previous = nullptr;
        Node* current = head;

        while (current != nullptr) {
            previous = current;
            current = current->next;
        }

        previous->next = second;
    }

    bool hasCycle() {
        if (head == nullptr) {
            return false;
        }
        
        Node* slow = head;
        Node* fast = head->next;

        while (fast != nullptr && fast->next != nullptr) {
            if (slow == fast) {
                return true;
            }
            
            fast = fast->next->next;
            slow = slow->next;
        }

        return false;
    }
};

int main()
{
    std::vector<int> keys {5, 1, 0, -3, -99};
    // std::vector<int> keys {5, 1};
    
    LinkedList list;

    std::cout << "List : ";
    list.addKeys(keys);
    list.printList();

    list.createCycle();

    std::cout << "List has cycle : " << std::boolalpha << list.hasCycle() << "\n";
}