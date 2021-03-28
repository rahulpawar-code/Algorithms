// http://tharikasblogs.blogspot.com/p/how-to-write-your-own-malloc-and-free.html

/*
* Compilation
gcc -I$(pwd) mymalloc.c test.c
*/

#include <stdio.h>
#include "mymalloc.h"

void main()
{
    int *p = (int *)myMalloc(100 * sizeof(int));
    char *q = (char *)myMalloc(250 * sizeof(char));
    int *r = (int *)myMalloc(1000 * sizeof(int));

    myFree(p);

    char *w = (char *)myMalloc(700);
    myFree(r);

    int *k = (int *)myMalloc(500 * sizeof(int));

    printf("Exiting from main()\n");
}