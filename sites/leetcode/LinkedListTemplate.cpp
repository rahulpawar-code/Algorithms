// Simple template

#include <iostream>
#include <vector>

struct ListNode
{
    int val;
    ListNode* next;

    ListNode() : val {0}, next {nullptr} { }
    ListNode(int v) : val {v}, next {nullptr} { }
};

class LinkedList
{
private:
    ListNode* head;
    void destroyList();

public:
    LinkedList();
    LinkedList(std::vector<int>& keys);
    ~LinkedList();
    void printList();
};

LinkedList::LinkedList() : head {nullptr} { }

LinkedList::~LinkedList()
{
    if (head != nullptr) {
        destroyList();
    }
}

LinkedList::LinkedList(std::vector<int>& keys)
{
    head = nullptr;
    head = new ListNode(keys[0]);
    ListNode* tail = head;
    for (int i = 1; i < keys.size(); ++i) {
        tail->next = new ListNode(keys[i]);
        tail = tail->next;
    }
}

void LinkedList::destroyList()
{
    if (head == nullptr) {
        return;
    }

    ListNode* current = head;
    while (current != nullptr) {
        ListNode* temp = current;
        current = current->next;
        temp->next = nullptr;
        delete temp;
    }
}

void LinkedList::printList()
{
    if (head == nullptr) {
        return;
    }
    ListNode* temp = head;
    while (temp != nullptr) {
        std::cout << temp->val << " ";
        temp = temp->next;
    }
    std::cout << "\n";
}

int main()
{
    std::vector<int> keys {1, 2, 3, 4, 5, 6, 7, 8, 9};
    LinkedList list1 (keys);
    std::cout << "List 1 : ";
    list1.printList();
    return 0;
}i
