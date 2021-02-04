// Intersection of Two Linked Lists  https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/785/

#include <iostream>
#include <vector>
#include <cmath>

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
    int length();

public:
    LinkedList();
    LinkedList(std::vector<int>& keys);
    ~LinkedList();
    void printList();
    void stitchList(LinkedList* listB);
    ListNode* getIntersectionNodeMethod1(LinkedList& listB);
    ListNode* getIntersectionNodeMethod2(LinkedList& listB);
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

void LinkedList::stitchList(LinkedList* listB)
{
    ListNode* temp = head->next->next;
    ListNode* tailB = listB->head;
    while (tailB->next != nullptr) {
        tailB = tailB->next;
    }
    tailB->next = temp;
}

int LinkedList::length()
{
    ListNode* current = head;
    int len = 0;
    while (current != nullptr) {
        len++;
        current = current->next;
    }
    return len;
}

ListNode* LinkedList::getIntersectionNodeMethod1(LinkedList& listB)
{
    int lengthA = this->length();
    int lengthB = listB.length();
    int diff = std::abs(lengthA-lengthB);

    ListNode* currentA = head;
    ListNode* currentB = listB.head;

    if (lengthA > lengthB) {
        for (int i = 1; i <= diff; ++i) {
            currentA = currentA->next;
        }
    } else if (lengthA < lengthB){
        for (int i = 1; i <= diff; ++i) {
            currentB = currentB->next;
        }
    }

    while (currentA != nullptr && currentB != nullptr && currentA != currentB) {
        currentA = currentA->next;
        currentB = currentB->next;
    }

    if (currentA == nullptr || currentB == nullptr) {
        return nullptr;
    }

    return currentA;
}

ListNode* LinkedList::getIntersectionNodeMethod2(LinkedList& listB)
{
    if (head == nullptr || listB.head == nullptr) {
        return nullptr;
    }

    ListNode* currentA = head;
    ListNode* currentB = listB.head;

    while (currentA != nullptr && currentB != nullptr && currentA != currentB) {
        currentA = currentA->next;
        currentB = currentB->next;

        if (currentA == currentB) {
            return currentA;
        }

        currentA = (currentA == nullptr ? listB.head : currentA);
        currentB = (currentB == nullptr ? head : currentB);
    }

    return nullptr;
}


void printFromNode(ListNode* node)
{
    while (node != nullptr) {
        std::cout << node->val << " ";
        node = node->next;
    }
    std::cout << "\n";
}

int main()
{
    std::vector<int> keys1 {1, 2, 3, 4, 7, 8, 9};
    LinkedList list1 (keys1);
    std::cout << "List 1 : ";
    list1.printList();

    std::vector<int> keys2 {5, 6};
    LinkedList list2 (keys2);
    std::cout << "List 2 : ";
    list2.printList();

    std::cout << "Stitch list 2 in list 1 \n";
    list1.stitchList(&list2);
    std::cout << "After stitching, List 2 : ";
    list2.printList();

    std::cout << "================================================\n";
    std::cout << "Finding common intersection point method 1\n";
    ListNode* nodeA = list1.getIntersectionNodeMethod1(list2);
    std::cout << "common portion of list: ";
    printFromNode(nodeA);

    std::cout << "================================================\n";
    std::cout << "Finding common intersection point method 2\n";
    ListNode* nodeB = list1.getIntersectionNodeMethod2(list2);
    std::cout << "common portion of list: ";
    printFromNode(nodeB);

    return 0;
}
