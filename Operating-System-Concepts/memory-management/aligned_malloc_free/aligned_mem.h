// https://www.careercup.com/question?id=2777

#ifndef ALIGNED_MEM_H
#define ALIGNED_MEM_H

#include <stdlib.h>
#include <stdio.h>
#include <stddef.h>

void aligned_free(void * ptr)
{
    if (ptr == NULL) {
        printf("[WARNING] : trying to free null memory\n");
        return;
    }
    printf("[INFO] : Freeing memory at %p\n", ptr);
    free((void *)(*((size_t *)ptr - 1)));
}

void* aligned_malloc(size_t bytes, size_t alignment)
{
    void *p1 = NULL;
    void *p2 = NULL;

    p1 = (void *)malloc(bytes + alignment + sizeof(size_t));

    if (p1 == NULL) {
        printf("[ERROR] : insufficient memory\n");
        return NULL;
    }

    size_t addr = (size_t)p1 + alignment + sizeof(size_t);
    p2 = (void *)(addr - (addr % alignment));

    *((size_t *)p2 - 1) = (size_t)p1;

    return p2;
}

#endif