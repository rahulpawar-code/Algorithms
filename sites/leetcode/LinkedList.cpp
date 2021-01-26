// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/

#include <iostream>
#include <vector>

class Node 
{
public:
    int key;
    Node* next;

    Node(int x) : key {x}, next {nullptr}
    { }
};

class LinkedList
{
private:
    Node* head;

public:
    LinkedList() : head {nullptr} 
    { }
    
    void deleteNode(Node* node)
    {
        if (node == nullptr || head == nullptr) {
            return;
        }
        
        if (node == head) {
            Node* current = head;
            head = head->next;
            current->next = nullptr;
            return;
        }
        
        Node* current = head;
        while (current->next != node) {
            current = current->next;
        }
        
        current->next = node->next;
        node->next = nullptr;
    }
    
    void deleteWithoutPrevious(Node* node) {
        if (head == nullptr || node == nullptr || node->next == nullptr) {
            return;
        }
        Node* temp = node->next;
        node->key = node->next->key;
        node->next = node->next->next;
        temp->next = nullptr;
        delete temp;
    }
    
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
    
    Node* const find(int key) {
        if (head == nullptr) {
            return nullptr;
        }
        
        Node* current = head;
        while (current != nullptr && current->key != key) {
            current = current->next;
        }
        
        return (current == nullptr) ? nullptr : current; 
    }
};

int main()
{
    std::vector<int> keys {-3, 5, -99, 0, 1};
    LinkedList list;
    list.addKeys(keys);
    list.printList();
    
    int key = 5;
    Node* const node = list.find(key);
    if (node != nullptr) {
        std::cout << "Deleting node with value : " << node->key << "\n";
        list.deleteWithoutPrevious(node);
        //list.deleteNode(node);
    
        list.printList();
    } else {
        std::cout << "List does not contain : " << key << "\n";
    }
    
    
    
    return 0;
}