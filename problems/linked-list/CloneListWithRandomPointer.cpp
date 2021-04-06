// Techie Delight https://www.techiedelight.com/clone-a-linked-list-with-random-pointers/
// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-hard/117/linked-list/841/

#include <iostream>
#include <vector>
#include <unordered_map>

class LinkedList
{
private:
    class Node
    {
    public:
        int key;
        Node* next;
        Node* random;

        Node(int k) : key(k), next(nullptr) { }
        Node() : key(0), next(nullptr) { }
    };

    Node* head;

    void populateRandom()
    {
        if (head == nullptr) {
            return;
        }

        Node* current = head;
        while (current != nullptr) {
            if (current->next != nullptr) {
                current->random = current->next->next;
            }

            current = current->next;
        }
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

    void push(int key)
    {
        Node* node = new Node(key);
        if (head != nullptr) {
            node->next = head;
        }
        head = node;
    }

    void createList(std::vector<int>& keys)
    {
        for (auto key : keys) {
            push(key);
        }
        populateRandom();
    }

    void print()
    {
        if (head == nullptr) {
            std::cout << "null\n";
            return;
        }

        Node* current = head;
        while (current != nullptr) {
            if (current->random != nullptr) {
                std::cout << current->key << "(" << current->random->key << ") ";
            } else {
                std::cout << current->key << "(null) ";
            }
            current = current->next;
            if (current != nullptr) {
                std::cout << "-> ";
            }
        }
        std::cout << "\n";
    }

    Node* cloneList(Node* head, std::unordered_map<Node*, Node*>& map)
    {
        if (head == nullptr) {
            return nullptr;
        }

        map[head] = new Node(head->key);
        map[head]->next = cloneList(head->next, map);

        return map[head];
    }

    void updateRandomPointer(Node* head, std::unordered_map<Node*, Node*>& map)
    {
        if (map[head] == nullptr) {
            return;
        }
        map[head]->random = map[head->random];
        updateRandomPointer(head->next, map);
    }

    LinkedList clone()
    {
        LinkedList list;
        if (head == nullptr) {
            return list;
        }

        std::unordered_map<Node*, Node*> map;
        list.head = cloneList(head, map);
        updateRandomPointer(head, map);

        return list;
    }
};

int main()
{
    std::vector<int> keys {6, 3, 4, 8, 2, 9, 10, 5, 1};
    LinkedList list;
    list.createList(keys);
    list.print();
    std::cout << "Cloned list : \n";
    LinkedList cList = list.clone();
    cList.print();

    return 0;
}
