// Linked list in C, push, append
// Techie Delight https://www.techiedelight.com/linked-list-implementation-part-1/
// https://www.techiedelight.com/linked-list-implementation-part-2/

#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
    int key;
    Node* next;
} Node;

void push(Node** head, int key)
{
    Node* node = (Node*)malloc(sizeof(Node));
    node->key = key;
    node->next = *head;
    *head = node;
}

Node* constructList(int keys[], int n)
{
    Node* head = NULL;
    for (int i = 0; i < n; ++i) {
        push(&head, keys[i]);
    }
    return head;
}

Node* constructListAppend(int keys[], int n)
{
    Node dummy;
    dummy.next = NULL;
    Node* tail = &dummy;
    for (int i = 0; i < n; ++i) {
        push(&(tail->next), keys[i]);
        tail = tail->next;
    }
    return dummy.next;
}

void printList(Node* node)
{
    Node* current = node;
    while (current != NULL) {
        printf("%d -> ", current->key);
        current = current->next;
    }
    printf("NULL \n");
}

int main()
{
    int keys[] = {1, 2, 3, 4, 5};
    int n = sizeof(keys) / sizeof(keys[0]);

    printf("Constructing list in push mode\n");
    struct Node* head = constructList(keys, n);
    printList(head);

    printf("Constructing list in append mode\n");
    Node* head2 = constructListAppend(keys, n);
    printList(head2);

    return 0;
}