// https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/

#include <iostream>
#include <vector>
#include <climits>

class ListNode
{
public:
    int key;
    ListNode* next;

    ListNode() : key {0}, next {nullptr} { }
    ListNode(int k) : key {k}, next {nullptr} {}

    ~ListNode() {
        next = nullptr;
    }
};

class LinkedList
{
private:
    ListNode* head;
    void destroyList();
    void createList(std::vector<int>& keys);

public:
    LinkedList();
    LinkedList(std::vector<int>& keys);
    ~LinkedList();
    void addLast(int key);
    void addFront(int key);
    void printList();
    int listToNumber();
    LinkedList* addList(LinkedList* list2);
};

LinkedList::LinkedList() : head{nullptr} {}

LinkedList::~LinkedList()
{
    if (head != nullptr) {
        destroyList();
    }
}

LinkedList::LinkedList(std::vector<int>& keys)
{
    head = nullptr;
    for (auto key : keys) {
        addLast(key);
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
        delete temp;
    }
    head = nullptr;
}

void LinkedList::addFront(int key)
{
    ListNode* node = new ListNode(key);
    if (head != nullptr) {
        node->next = head;
    }
    head = node;
}

void LinkedList::addLast(int key)
{
    ListNode* node = new ListNode(key);
    if (head == nullptr) {
        head = node;
        return;
    }
    ListNode* current = head;
    while (current->next != nullptr) {
        current = current->next;
    }
    current->next = node;
}

void LinkedList::printList()
{
    if (head == nullptr) {
        return;
    }
    ListNode* current = head;
    while (current != nullptr) {
        std::cout << current->key << " ";
        current = current->next;
    }
    std::cout << "\n";
}

int LinkedList::listToNumber()
{
    if (head == nullptr) {
        return INT_MIN;
    }
    int multiplier = 1;
    int number = 0;
    ListNode* current = head;
    while (current != nullptr) {
        number = number + current->key * multiplier;
        multiplier = multiplier * 10;
        current = current->next;
    }
    return number;
}

LinkedList* LinkedList::addList(LinkedList* list2)
{
    LinkedList* res = new LinkedList();
    int carry = 0;

    ListNode* current1 = head;
    ListNode* current2 = list2->head;

    while (current1 != nullptr || current2 != nullptr) {
        int value = (current1 != nullptr ? current1->key : 0) +
                    (current2 != nullptr ? current2->key : 0) + carry;

        res->addLast(value % 10);
        carry = value / 10;

        current1 = current1 != nullptr ? current1->next : nullptr;
        current2 = current2 != nullptr ? current2->next : nullptr;
    }

    if (carry != 0) {
        res->addLast(carry);
    }

    return res;
}

int main()
{
    std::vector<int> num1 {2, 4, 3};
    LinkedList list1(num1);
    std::cout << "List 1 : ";
    list1.printList();
    std::cout << "List 1 integer : " << list1.listToNumber() << "\n";

    std::vector<int> num2 {5, 6, 4, 9, 9};
    LinkedList list2(num2);
    std::cout << "List 2 : ";
    list2.printList();
    std::cout << "List 2 integer : " << list2.listToNumber() << "\n";

    LinkedList* res = list1.addList(&list2);
    std::cout << "Result list : ";
    res->printList();
    std::cout << "Result list integer : " << res->listToNumber() << "\n";

    delete res;
    return 0;
}