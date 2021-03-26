// Segregate even and odd nodes in a Linked List
// https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/

#include <vector>
#include <iostream>


class LinkedList
{
private:
    class Node
    {
        public:
            int key;
            Node* next;

            Node(int k) : key(k), next(nullptr) { }
    };

    Node* head;

public:
    LinkedList() : head(nullptr) { }

    void addLast(int key)
    {
        if (head == nullptr) {
            head = new Node(key);
            return;
        }

        Node* node = head;
        while (node->next != nullptr) {
            node = node->next;
        }
        node->next = new Node(key);
    }

    void constructList(std::vector<int>& keys)
    {
        for (auto key : keys) {
            addLast(key);
        }
    }

    void print()
    {
        if (head == nullptr) {
            return;
        }

        Node* temp = head;
        while (temp != nullptr) {
            std::cout << temp->key;
            if (temp->next != nullptr) {
                std::cout << " -> ";
            }
            temp = temp->next;
        }
        std::cout << "\n";
    }

    void rearrangeKeys()
    {
        if (head == nullptr || head->next == nullptr) {
            return;
        }

        Node* evenStart = nullptr;
        Node* evenEnd = nullptr;
        Node* oddStart = nullptr;
        Node* oddEnd = nullptr;
        Node* current = head;

        while (current != nullptr) {
            int data = current->key;

            if (data % 2 == 0) {
                if (evenStart == nullptr) {
                    evenStart = current;
                    evenEnd = evenStart;
                } else {
                    evenEnd->next = current;
                    evenEnd = evenEnd->next;
                }
            } else {
                if (oddStart == nullptr) {
                    oddStart = current;
                    oddEnd = oddStart;
                } else {
                    oddEnd->next = current;
                    oddEnd = oddEnd->next;
                }
            }
            current = current->next;
        }

        if (oddStart == nullptr || evenStart == nullptr) {
            return;
        }

        evenEnd->next = oddStart;
        oddEnd->next = nullptr;
        head = evenStart;
    }
};

int main()
{
    std::vector<int> keys {1, 4, 5, 3, 8, 7, 10};
    LinkedList list;
    list.constructList(keys);
    list.print();
    std::cout << "List rearranged\n";
    list.rearrangeKeys();
    list.print();
}
