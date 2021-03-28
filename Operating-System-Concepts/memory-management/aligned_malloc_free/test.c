// https://www.careercup.com/question?id=2777

/*
* Compilation :
gcc -I$(pwd) mymalloc.c test.c

* Memory Leak check
valgrind --leak-check=full --show-leak-kinds=all --track-origins=yes --verbose a.out
*/

#include <stdio.h>
#include "aligned_mem.h"

void main()
{
    int *p = (int *)aligned_malloc(50, 128);
    printf("Allocate aligned memory at : %p\n", p);
    aligned_free(p);
}