// http://tharikasblogs.blogspot.com/p/how-to-write-your-own-malloc-and-free.html

#include <stdio.h>
#include <stddef.h>
#include "mymalloc.h"


char memory[MAX_MEMSIZE];

struct block* freeList = (void *)memory;

void initialize()
{
    freeList->size = MAX_MEMSIZE - sizeof(struct block);
    freeList->free = 1;
    freeList->next = NULL;
}

void split(struct block *fitting, size_t bytes)
{
    struct block *newBlock = (void *)((void *)fitting + bytes + sizeof(struct block));

    newBlock->size = (fitting->size) - bytes - sizeof(struct block);
    newBlock->free = 1;
    newBlock->next = fitting->next;

    fitting->size = bytes;
    fitting->free = 0;
    fitting->next = newBlock;
}

void* myMalloc(size_t bytes)
{
    struct block* prev = NULL;
    struct block* curr = NULL;
    void *result = NULL;

    if (freeList == NULL || !(freeList->size)) {
        initialize();
        printf("[INFO] free memory initalized. Size %ld bytes\n", freeList->size);
    }

    curr = freeList;

    // List traversal
    while ( ((curr->size) < bytes) || ((curr->free) == 0) && (curr->next != NULL)) {
        prev = curr;
        curr = curr->next;
        printf("[INFO] one block traversed\n");
    }

    if ((curr->size) == bytes) {
        curr->free = 0;
        result = (void *)(++curr);
        printf("[INFO] exact fit block allocated at %p. Size %ld bytes\n", result, curr->size);
        return result;
    } else if ((curr->size) > (bytes + sizeof(struct block))) {
        split(curr, bytes);
        result = (void *)(++curr);
        printf("[INFO] fitting block allocated with a split at %p. Size %ld bytes\n", result, curr->size);
        return result;
    } else {
        printf("[ERROR] No sufficient memory to allocate %ld bytes\n", bytes);
        return result;
    }
}


void merge()
{
    struct block* prev = NULL;
    struct block* curr = freeList;

    while ((curr->next) != NULL) {
        if ((curr->free) && (curr->next->free)) {
            curr->size = curr->size + (curr->next->size) + sizeof(struct block);
            curr->next = curr->next->next;
        }

        prev = curr;
        curr = curr->next;
    }
}

void myFree(void* ptr)
{
    if (((void*)memory < ptr) && (ptr < (void *)(memory + MAX_MEMSIZE))) {
        struct block* curr = ptr;
        --curr;
        curr->free = 1;
        merge();
        printf("[Info] Freeing memory at %p. Size %ld bytes\n", ptr, curr->size);
    } else {
        printf("[ERROR] provide a valid pointer allocated by myMalloc\n");
    }
}