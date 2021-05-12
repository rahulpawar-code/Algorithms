// GeeksforGeeks https://www.geeksforgeeks.org/remove-characters-from-the-first-string-which-are-present-in-the-second-string/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define SIZE 256

int* getCharacterFrequency(char* mask)
{
    int* count = (int*)calloc(SIZE, sizeof(int));

    for (int i = 0; *(mask + i) != '\0'; ++i) {
        count[*(mask + i)]++;
    }
    return count;
}

char* removeMaskedCharacter(char* str, char* mask)
{
    char* result = (char*)malloc((strlen(str) + 1) * sizeof(char));
    strcpy(result, str);
    int* count = getCharacterFrequency(mask);

    int index = 0;
    for (int i = 0; *(str + i) != '\0'; ++i) {
        char temp = *(str + i);
        if (count[temp] == 0) {
            *(result + index) = *(str + i);
            index++;
        }
    }

    result[index] = '\0';
    return result;
}

void test(char* str, char* mask)
{
    printf("String : %s\n", str);
    printf("Mask string : %s\n", mask);
    char* result = removeMaskedCharacter(str, mask);
    printf("After removing chars : %s\n", result);
}

void main()
{
    char str[] = "Hello World!! This is a C++ program";
    char mask[] = "odsam";
    test(str, mask);
}
