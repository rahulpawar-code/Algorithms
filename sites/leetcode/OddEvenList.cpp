// Odd Even Linked List https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/784/

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
    void oddEvenList();
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
    if (keys.size() == 0) {
        return;
    }

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
        std::cout << "Empty List\n";
        return;
    }
    ListNode* temp = head;
    while (temp != nullptr) {
        std::cout << temp->val << " ";
        temp = temp->next;
    }
    std::cout << "\n";
}

void LinkedList::oddEvenList()
{
    if (head == nullptr) {
        return;
    }
    ListNode* odd = head;
    ListNode* even = head->next;
    ListNode* evenHead = even;
    while (even != nullptr && even->next != nullptr) {
        odd->next = even->next;
        odd = odd->next;
        even->next = odd->next;
        even = even->next;
    }
    odd->next = evenHead;
}

int main()
{
    std::vector<int> keys {1, 2, 3, 4, 5, 6, 7, 8, 9};
    LinkedList list (keys);
    std::cout << "List : ";
    list.printList();
    std::cout << "Odd and even separtion : ";
    list.oddEvenList();
    list.printList();
    return 0;
}