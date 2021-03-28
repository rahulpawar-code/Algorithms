// http://tharikasblogs.blogspot.com/p/how-to-write-your-own-malloc-and-free.html

#ifndef MYALLOC_H
#define MYALLOC_H

#include <stdio.h>
#include <stddef.h>

#define MAX_MEMSIZE 20000

typedef struct block
{
    size_t size;
    int free;
    struct block *next;
} block;

void initialize();

void* myMalloc(size_t bytes);

void split(struct block *fitting, size_t bytes);

void merge();

void myFree(void* ptr);

#endif