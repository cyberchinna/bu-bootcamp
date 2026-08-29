#include <stdio.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Broken swap: Takes arguments by value (no pointers)
// This fails to swap the caller's variables because the function receives local 
// copies of the values, not their memory addresses. Any changes made to 'a' 
// and 'b' disappear when the function stack frame is destroyed.
void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}

int main(void) {
    int x = 4,  y = 5;

    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swap:  x = %d, y = %d\n", x, y);

    int a = 7, b = 8;
    broken_swap(a, b);
    printf("After broken_swap:  a = %d, b = %d\n", a, b);

    return 0;
}